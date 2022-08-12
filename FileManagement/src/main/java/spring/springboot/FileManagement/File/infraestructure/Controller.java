package spring.springboot.FileManagement.File.infraestructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.springboot.FileManagement.File.application.FileService;
import spring.springboot.FileManagement.File.infraestructure.dto.input.FileInputDTO;
import spring.springboot.FileManagement.File.infraestructure.dto.output.FileOutputDTO;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class Controller {

    @Autowired
    FileService fileService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getFileByIDRoute(
            @PathVariable int id
    ){
        try {
            return fileService.getFileByID(id);
        } catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/upload/{type}")
    public ResponseEntity<?> postFileRoute(
            @ModelAttribute FileInputDTO fileInputDTO,
            @PathVariable String type
            ){
        try{
            return new ResponseEntity<>(fileService.postFile(type, fileInputDTO), HttpStatus.OK);
        }catch (IOException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }

    }
}

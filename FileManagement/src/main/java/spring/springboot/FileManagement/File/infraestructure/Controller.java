package spring.springboot.FileManagement.File.infraestructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.springboot.FileManagement.File.application.FileService;
import spring.springboot.FileManagement.File.infraestructure.dto.input.FileInputDTO;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class Controller {

    @Autowired
    FileService fileService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getFileByIDRoute(
            @PathVariable int id,
            @RequestParam(defaultValue = "C:\\Users\\oscar.clorenzo\\IdeaProjects\\FileManagement\\src\\main\\resources\\downloads\\") String path
    ){
        try {
            return fileService.getFileByID(id, path);
        } catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IOException i){
            return new ResponseEntity<>(i.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
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

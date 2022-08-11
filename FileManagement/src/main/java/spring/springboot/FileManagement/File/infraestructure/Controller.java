package spring.springboot.FileManagement.File.infraestructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.springboot.FileManagement.File.application.FileService;
import spring.springboot.FileManagement.File.infraestructure.dto.input.FileInputDTO;
import spring.springboot.FileManagement.File.infraestructure.dto.output.FileOutputDTO;

@RestController
@RequestMapping("/file")
public class Controller {

    @Autowired
    FileService fileService;

    @GetMapping("/{id}")
    public FileOutputDTO getFileByIDRoute(
            @PathVariable int id
    ){
        return fileService.getFileByID(id);
    }

    @GetMapping("/name/{name}")
    public FileOutputDTO getFileByNameRoute(
            @PathVariable String name
    ){
        return fileService.getFileByName(name);
    }

    @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public FileOutputDTO postFileRoute(
            @ModelAttribute FileInputDTO fileInputDTO
            ){
        return fileService.postFile(fileInputDTO);
    }
}

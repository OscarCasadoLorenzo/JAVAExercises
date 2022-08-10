package spring.springboot.FileManagement.File.infraestructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.springboot.FileManagement.File.application.FileService;

@RestController
@RequestMapping("/file")
public class Controller {

    @Autowired
    FileService fileService;
}

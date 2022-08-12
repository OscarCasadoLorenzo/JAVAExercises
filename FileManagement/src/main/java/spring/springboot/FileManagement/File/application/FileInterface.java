package spring.springboot.FileManagement.File.application;

import org.springframework.http.ResponseEntity;
import spring.springboot.FileManagement.File.infraestructure.dto.input.FileInputDTO;
import spring.springboot.FileManagement.File.infraestructure.dto.output.FileOutputDTO;

import java.io.IOException;

public interface FileInterface {
    ResponseEntity<?> getFileByID(int id);

    FileOutputDTO postFile(String type, FileInputDTO fileInputDTO) throws IOException;
}

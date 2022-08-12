package spring.springboot.FileManagement.File.application;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import spring.springboot.FileManagement.File.infraestructure.dto.input.FileInputDTO;
import spring.springboot.FileManagement.File.infraestructure.dto.output.FileOutputDTO;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileInterface {
    ResponseEntity<?> getFileByID(int id);

    FileOutputDTO getFileByName(String name);

    FileOutputDTO postFile(FileInputDTO fileInputDTO) throws IOException;
}

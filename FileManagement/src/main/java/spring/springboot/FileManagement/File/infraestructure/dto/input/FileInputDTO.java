package spring.springboot.FileManagement.File.infraestructure.dto.input;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FileInputDTO {
    MultipartFile file;

    String name;
}

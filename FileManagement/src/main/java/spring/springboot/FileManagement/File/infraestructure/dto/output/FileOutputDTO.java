package spring.springboot.FileManagement.File.infraestructure.dto.output;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import spring.springboot.FileManagement.File.application.FileEntity;

import java.util.Date;

@Data
public class FileOutputDTO {
    Integer id;

    byte[] data;

    String name;

    Date upload_date;

    public FileOutputDTO(FileEntity fileEntity){
        this.id = fileEntity.getId();
        this.name = fileEntity.getName();
        this.data = fileEntity.getData();
        this.upload_date = fileEntity.getUpload_date();
    }
}

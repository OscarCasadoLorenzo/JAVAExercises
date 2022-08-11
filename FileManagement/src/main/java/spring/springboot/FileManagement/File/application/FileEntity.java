package spring.springboot.FileManagement.File.application;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import spring.springboot.FileManagement.File.infraestructure.dto.input.FileInputDTO;

import javax.persistence.*;
import java.io.File;
import java.util.Date;

@Entity
@Data
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    private String type;

    @Lob
    private byte[] data;

    String name;

    Date upload_date;

    public FileEntity(byte[] data, String name, String type){
        this.data = data;
        this.name = name;
        this.type = type;
        this.upload_date = new Date(System.currentTimeMillis());
    }
}

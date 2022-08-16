package spring.springboot.FileManagement.File.application;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import spring.springboot.FileManagement.File.infraestructure.dto.input.FileInputDTO;
import spring.springboot.FileManagement.File.infraestructure.dto.output.FileOutputDTO;
import spring.springboot.FileManagement.File.repository.FileRepository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

@Service
public class FileService implements FileInterface{

    @Autowired
    FileRepository fileRepository;

    @Override
    public ResponseEntity<Resource> getFileByID(int id, String path) throws IOException {
        FileEntity fileEntity = fileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("File with id: " + id + " doesnt exist."));

        File newFile = new File( path + fileEntity.getName());
        System.out.println("File absolute path: " + newFile.getAbsolutePath());
        newFile.createNewFile();
        FileOutputStream output = new FileOutputStream(newFile);
        output.write(fileEntity.getData());
        output.close();
        return null;
    }

    @Override
    public FileOutputDTO postFile(String type, FileInputDTO fileInputDTO) throws IOException {
        //String fileName = StringUtils.cleanPath(fileInputDTO.getFile().getOriginalFilename());
        String fileName = fileInputDTO.getName()+"."+type;
        byte[] data = fileInputDTO.getFile().getBytes();
        String fileType = fileInputDTO.getFile().getContentType();

        FileEntity fileEntity = new FileEntity(data, fileName, fileType);
        fileRepository.save(fileEntity);

        return new FileOutputDTO(fileEntity);
    }
}

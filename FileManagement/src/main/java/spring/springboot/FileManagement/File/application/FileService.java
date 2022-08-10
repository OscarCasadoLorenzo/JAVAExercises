package spring.springboot.FileManagement.File.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import spring.springboot.FileManagement.File.repository.FileRepository;

import java.nio.file.Path;
import java.util.stream.Stream;

@Service
public class FileService{

    @Autowired
    FileRepository fileRepository;


}

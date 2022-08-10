package spring.springboot.FileManagement.File.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.springboot.FileManagement.File.repository.FileRepository;

@Service
public class FileService implements FileInterface{

    @Autowired
    FileRepository fileRepository;
}

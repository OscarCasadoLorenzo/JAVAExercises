package spring.springboot.FileManagement.File.repository;

import org.springframework.data.repository.CrudRepository;
import spring.springboot.FileManagement.File.application.FileEntity;

public interface FileRepository extends CrudRepository<FileEntity, Integer> {
}

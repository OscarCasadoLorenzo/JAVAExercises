package spring.springboot.FileManagement.File.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.springboot.FileManagement.File.application.FileEntity;

@Repository
public interface FileRepository extends CrudRepository<FileEntity, Integer> {
}

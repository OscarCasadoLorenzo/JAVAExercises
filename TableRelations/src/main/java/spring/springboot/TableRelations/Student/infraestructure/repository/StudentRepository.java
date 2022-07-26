package spring.springboot.TableRelations.Student.infraestructure.repository;

import org.springframework.data.repository.CrudRepository;
import spring.springboot.TableRelations.Student.domain.StudentEntity;

public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {
}

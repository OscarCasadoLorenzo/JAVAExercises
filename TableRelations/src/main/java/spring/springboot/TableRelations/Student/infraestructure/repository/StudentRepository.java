package spring.springboot.TableRelations.Student.infraestructure.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import spring.springboot.TableRelations.Student.domain.StudentEntity;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {

    /*
     @Query("SELECT personID FROM STUDENTS WHERE personID = ?1")
    public Integer isPersonIDBeingUsedByOtherStudent(int idPerson);
     */


}

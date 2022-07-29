package spring.springboot.TableRelations.Student.infraestructure.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import spring.springboot.TableRelations.Student.domain.StudentEntity;


public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {


         @Query(value = "SELECT * FROM STUDENTS s WHERE s.PERSONID= ?", nativeQuery = true)
          public StudentEntity getPersonQuery(Integer personID);



}

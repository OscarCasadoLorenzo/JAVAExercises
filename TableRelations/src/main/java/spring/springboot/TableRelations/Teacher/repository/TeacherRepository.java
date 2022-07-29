package spring.springboot.TableRelations.Teacher.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import spring.springboot.TableRelations.Student.domain.StudentEntity;
import spring.springboot.TableRelations.Teacher.domain.TeacherEntity;

public interface TeacherRepository extends CrudRepository<TeacherEntity, Integer> {
    @Query(value = "SELECT * FROM TEACHERS s WHERE s.PERSONID= ?", nativeQuery = true)
    public TeacherEntity getPersonQuery(Integer personID);

}

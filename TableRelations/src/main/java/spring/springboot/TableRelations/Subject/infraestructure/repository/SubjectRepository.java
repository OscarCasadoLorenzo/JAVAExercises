package spring.springboot.TableRelations.Subject.infraestructure.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import spring.springboot.TableRelations.Subject.domain.SubjectEntity;

import java.util.List;

public interface SubjectRepository extends CrudRepository<SubjectEntity, Integer> {


    @Query(value = "SELECT * FROM SUBJECTS WHERE ID_STUDY IN (SELECT SUBJECTID FROM STUDENTS_SUBJECTS WHERE STUDENTID = ?1)", nativeQuery = true)
    List<SubjectEntity> findSubjectsByStudent(String id);


}

package spring.springboot.TableRelations.Teacher.repository;

import org.springframework.data.repository.CrudRepository;
import spring.springboot.TableRelations.Teacher.domain.TeacherEntity;

public interface TeacherRepository extends CrudRepository<TeacherEntity, String> {
}

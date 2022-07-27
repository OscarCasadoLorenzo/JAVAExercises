package spring.springboot.TableRelations.Subject.infraestructure.repository;

import org.springframework.data.repository.CrudRepository;
import spring.springboot.TableRelations.Subject.domain.SubjectEntity;

public interface SubjectRepository extends CrudRepository<SubjectEntity, Integer> {

}

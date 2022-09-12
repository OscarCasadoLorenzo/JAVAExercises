package spring.springboot.EnterpriseApplication.insfraestructure.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.springboot.WebBackend.domain.PersonEntity;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, Integer> {
}

package spring.springboot.WebBackend.Person.infraestructure.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.springboot.WebBackend.Person.domain.PersonEntity;

import java.util.UUID;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, Integer> {
}

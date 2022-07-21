package spring.springboot.JPAExample.Persona.infraestructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.springboot.JPAExample.Persona.domain.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {
}

package spring.springboot.SpringSecurity.Persona.infraestructure.repository.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import spring.springboot.SpringSecurity.Persona.domain.PersonEntity;

import java.util.List;

@Service
public interface PersonRepository extends CrudRepository<PersonEntity, Integer> {
    /*  RETURN A PERSONENTITY OR A PERSONOUTPUTDTO?
        It is a good practise to return the Entity object, because
        if in the future we would change a class's property it won't
        do the automatic conversion.
    */
    List<PersonEntity> findByName(String name);

}

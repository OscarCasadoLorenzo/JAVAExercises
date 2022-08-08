package spring.springboot.records.Persona.domain;

import ch.qos.logback.core.pattern.parser.OptionTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.springboot.records.Persona.infraestructure.controller.dto.input.PersonaInputDTO;
import spring.springboot.records.Persona.infraestructure.controller.dto.output.PersonaOutputDTO;
import spring.springboot.records.Persona.infraestructure.repository.jpa.PersonRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements PersonInterface{

    @Autowired
    PersonRepository personRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<PersonaOutputDTO> getAllPersons() {
        List<PersonaOutputDTO> personaOutputDTOList = new ArrayList<>();

        for (PersonEntity personEntity : personRepository.findAll()){
            PersonaOutputDTO auxOutputDTO = new PersonaOutputDTO(personEntity);
            personaOutputDTOList.add(auxOutputDTO);
        }

        return personaOutputDTOList;
    }

    @Override
    public boolean existsPerson(int id) {
        return personRepository.existsById(id);
    }

    @Override
    public PersonaOutputDTO getPersonByID(int id) {
        PersonEntity personEntity = personRepository.findById(id).orElse(null);
        PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(personEntity);
        return personaOutputDTO;
    }

    @Override
    public List<PersonaOutputDTO> getPersonsByName(String name) {
        List<PersonaOutputDTO> personaOutputDTOList = new ArrayList<>();

        for (PersonEntity personEntity : personRepository.findByName(name)){
            PersonaOutputDTO auxOutputDTO = new PersonaOutputDTO(personEntity);
            personaOutputDTOList.add(auxOutputDTO);
        }

        return personaOutputDTOList;
    }

    @Override
    public List<PersonaOutputDTO> getPersonsWithCriteriaQuery(
            Optional<String> name,
            Optional<String> user,
            Optional<Date> creation_date) {
        List<PersonaOutputDTO> personaOutputDTOList = new ArrayList<>();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PersonEntity> query = cb.createQuery(PersonEntity.class);
        Root<PersonEntity> personaEntityRoot = query.from(PersonEntity.class);

        List<Predicate> predicates = new ArrayList<>();
        if (name.isPresent())
            predicates.add(cb.like(personaEntityRoot.get("name"), name.get()));
        if (user.isPresent())
            predicates.add(cb.like(personaEntityRoot.get("usuario"), user.get()));
        if (creation_date.isPresent())
            predicates.add(cb.equal(personaEntityRoot.get("created_date"), creation_date.get()));

        query.select(personaEntityRoot).where(cb.and(predicates.toArray(new Predicate[predicates.size()])));

        entityManager.createQuery(query).getResultList().forEach( personEntity -> {
            personaOutputDTOList.add(new PersonaOutputDTO((PersonEntity) personEntity));
        });
        return personaOutputDTOList;
    }

    @Override
    public PersonaOutputDTO postPerson(PersonaInputDTO personInputDTO) {
        PersonEntity personEntity = new PersonEntity(personInputDTO);
        personRepository.save(personEntity);
        PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(personEntity);
        return personaOutputDTO;
    }

    @Override
    public PersonaOutputDTO updatePerson(int id, PersonaInputDTO personaInputDTO) {
        /*
            We could then simply get the entity from the database,
            make the change, and use the save() method as before.
         */
        PersonEntity personInDB = personRepository.findById(id).orElse(null);
        personInDB.updateEntity(personaInputDTO);
        personRepository.save(personInDB);

        PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(personInDB);
        return personaOutputDTO;
    }

    @Override
    public PersonaOutputDTO deletePerson(int id) {
        PersonaOutputDTO personaOutputDTO = getPersonByID(id);
        personRepository.deleteById(id);
        return personaOutputDTO;
    }
}

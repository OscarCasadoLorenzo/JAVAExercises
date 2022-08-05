package spring.springboot.records.Persona.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.springboot.JPAExample.Persona.infraestructure.controller.dto.input.PersonaInputDTO;
import spring.springboot.JPAExample.Persona.infraestructure.controller.dto.output.PersonaOutputDTO;
import spring.springboot.JPAExample.Persona.infraestructure.repository.jpa.PersonRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService implements PersonInterface{

    @Autowired
    PersonRepository personRepository;

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

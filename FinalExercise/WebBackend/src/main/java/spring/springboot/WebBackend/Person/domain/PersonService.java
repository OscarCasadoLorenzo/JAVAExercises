package spring.springboot.WebBackend.Person.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.springboot.WebBackend.Person.infraestructure.controller.dto.input.PersonInputDTO;
import spring.springboot.WebBackend.Person.infraestructure.controller.dto.output.PersonOutputDTO;
import spring.springboot.WebBackend.Person.infraestructure.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService implements PersonInterface{
    @Autowired
    PersonRepository personRepository;

    @Override
    public List<PersonOutputDTO> getAllPersons() {
        List<PersonOutputDTO> personaOutputDTOList = new ArrayList<>();

        for (PersonEntity personEntity : personRepository.findAll()){
            PersonOutputDTO auxOutputDTO = new PersonOutputDTO(personEntity);
            personaOutputDTOList.add(auxOutputDTO);
        }

        return personaOutputDTOList;
    }

    @Override
    public boolean existsPerson(String dni) {
        return personRepository.existsById(dni);
    }

    @Override
    public PersonOutputDTO getPersonByID(String dni) {
        PersonEntity personEntity = personRepository.findById(dni).orElse(null);
        PersonOutputDTO personaOutputDTO = new PersonOutputDTO(personEntity);
        return personaOutputDTO;
    }

    @Override
    public PersonOutputDTO postPerson(PersonInputDTO personInputDTO){

        PersonEntity personEntity = new PersonEntity(personInputDTO);
        personRepository.save(personEntity);
        PersonOutputDTO personaOutputDTO = new PersonOutputDTO(personEntity);
        return personaOutputDTO;

    }

    @Override
    public PersonOutputDTO updatePerson(String dni, PersonInputDTO personaInputDTO){
        /*
            We could then simply get the entity from the database,
            make the change, and use the save() method as before.
         */
        PersonEntity personInDB = personRepository.findById(dni).orElse(null);
        personInDB.updateEntity(personaInputDTO);
        personRepository.save(personInDB);

        PersonOutputDTO personaOutputDTO = new PersonOutputDTO(personInDB);
        return personaOutputDTO;
    }

    @Override
    public PersonOutputDTO deletePerson(String dni) {
        PersonOutputDTO personaOutputDTO = getPersonByID(dni);
        personRepository.deleteById(dni);
        return personaOutputDTO;
    }
}

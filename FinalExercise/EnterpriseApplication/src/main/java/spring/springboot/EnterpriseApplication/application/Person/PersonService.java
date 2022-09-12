package spring.springboot.EnterpriseApplication.application.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.springboot.WebBackend.domain.PersonEntity;
import spring.springboot.WebBackend.exceptions.NotFoundException;
import spring.springboot.WebBackend.infraestructure.controller.dto.input.PersonInputDTO;
import spring.springboot.WebBackend.infraestructure.controller.dto.output.PersonOutputDTO;
import spring.springboot.WebBackend.infraestructure.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

@Service("WebBackendPersonServiceBean")
public class PersonService implements PersonInterface {
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
    public PersonOutputDTO getPersonByID(Integer id){
        PersonEntity personEntity = personRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Person with id " + id + " doesnt exists."));

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
    public PersonOutputDTO updatePerson(Integer id, PersonInputDTO personaInputDTO){
        PersonEntity personEntity = personRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Person with id " + id + " doesnt exists."));

        personEntity.updateEntity(personaInputDTO);
        personRepository.save(personEntity);

        PersonOutputDTO personaOutputDTO = new PersonOutputDTO(personEntity);
        return personaOutputDTO;
    }

    @Override
    public PersonOutputDTO deletePerson(Integer id) {
        PersonOutputDTO personaOutputDTO = getPersonByID(id);
        personRepository.deleteById(id);
        return personaOutputDTO;
    }
}

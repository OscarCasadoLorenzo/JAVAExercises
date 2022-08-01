package spring.springboot.TableRelations.Person.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import spring.springboot.TableRelations.Person.infraestructure.controller.dto.input.PersonaInputDTO;
import spring.springboot.TableRelations.Person.infraestructure.controller.dto.output.PersonaOutputDTO;
import spring.springboot.TableRelations.Person.infraestructure.repository.jpa.PersonRepository;
import spring.springboot.TableRelations.Teacher.infraestructure.controller.dto.output.TeacherOutputDTO;

import javax.validation.Valid;
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
        if(!personRepository.existsById(id))
            throw new RuntimeException("Person with id: " + id + " doesnt exists.");

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
    public PersonaOutputDTO postPerson(PersonaInputDTO personInputDTO){

            PersonEntity personEntity = new PersonEntity(personInputDTO);
            personRepository.save(personEntity);
            PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(personEntity);
            return personaOutputDTO;

    }

    @Override
    public PersonaOutputDTO updatePerson(int id, @Valid PersonaInputDTO personaInputDTO){
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

    public ResponseEntity<?> getTeacher(int id){
        ResponseEntity<?> responseEntity;
        try{
            responseEntity = new RestTemplate().getForEntity("http://localhost:8080/teacher/"+id, TeacherOutputDTO.class);
        }catch (HttpClientErrorException e1) {
            responseEntity = new ResponseEntity<>("HTTP code is not 2XX. Server responded: " + e1.getResponseBodyAsString(), e1.getStatusCode());
        }catch (RestClientException e){
            responseEntity = new ResponseEntity<>("Server didnt respond: ", HttpStatus.I_AM_A_TEAPOT);
        }
        return responseEntity;
    }

}

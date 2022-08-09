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
import spring.springboot.TableRelations.Student.domain.StudentEntity;
import spring.springboot.TableRelations.Student.infraestructure.repository.StudentRepository;
import spring.springboot.TableRelations.Teacher.domain.TeacherEntity;
import spring.springboot.TableRelations.Teacher.infraestructure.controller.dto.output.TeacherOutputDTO;
import spring.springboot.TableRelations.Teacher.repository.TeacherRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements PersonInterface{

    @Autowired
    PersonRepository personRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
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
        if(!personRepository.existsById(id))
            throw new RuntimeException("Person with id: " + id + " does not exists.");

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
    public List<PersonaOutputDTO> getPersonWithCriteriaQuery(
            Optional<String> name,
            Optional<String>  surname,
            Optional<String>  company,
            Optional<String>  teacherName) {

        List<PersonaOutputDTO> personaOutputDTOList = new ArrayList<>();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PersonEntity> query = cb.createQuery(PersonEntity.class);
        Root<PersonEntity> personaEntityRoot = query.from(PersonEntity.class);

        List<Predicate> predicates = new ArrayList<>();
        if (name.isPresent())
            predicates.add(cb.like(personaEntityRoot.get("name"), name.get()));
        if (surname.isPresent())
            predicates.add(cb.like(personaEntityRoot.get("surname"), surname.get()));
        if (company.isPresent())
            predicates.add(cb.like(personaEntityRoot.get("company_email"), company.get()));


        entityManager.createQuery(query).getResultList().forEach( personEntity -> {
            personaOutputDTOList.add(new PersonaOutputDTO((PersonEntity) personEntity));
        });
        return personaOutputDTOList;
    }

    @Override
    public PersonaOutputDTO postPerson(PersonaInputDTO personInputDTO) throws RuntimeException{

            PersonEntity personEntity = new PersonEntity(personInputDTO);

            if(personInputDTO.getStudentID().isPresent() && personInputDTO.getTeacherID().isPresent())
                throw new RuntimeException("A person cant be student and teacher at the same time.");
            if(personInputDTO.getStudentID().isPresent()) {
                StudentEntity student = studentRepository.findById(personInputDTO.getStudentID().get())
                        .orElseThrow(() -> new RuntimeException("Student with id: " + personInputDTO.getStudentID().get() + " doesnt exists."));
            }
            if(personInputDTO.getTeacherID().isPresent()){
                TeacherEntity teacher = teacherRepository.findById(personInputDTO.getTeacherID().get())
                        .orElseThrow(() -> new RuntimeException("Teacher with id: " + personInputDTO.getTeacherID().get() + " doesnt exists."));

            }

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

    public ResponseEntity<?> getTeacherWithTemplate(int id){
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

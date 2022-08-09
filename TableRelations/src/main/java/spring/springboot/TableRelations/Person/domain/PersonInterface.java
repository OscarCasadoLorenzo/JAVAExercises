package spring.springboot.TableRelations.Person.domain;

import org.springframework.web.bind.MethodArgumentNotValidException;
import spring.springboot.TableRelations.Person.infraestructure.controller.dto.input.PersonaInputDTO;
import spring.springboot.TableRelations.Person.infraestructure.controller.dto.output.PersonaOutputDTO;
import spring.springboot.TableRelations.Teacher.infraestructure.controller.dto.output.TeacherOutputDTO;

import java.util.List;
import java.util.Optional;

public interface PersonInterface {

    List<PersonaOutputDTO> getAllPersons();

    boolean existsPerson(int id);

    PersonaOutputDTO getPersonByID(int id);

    List<PersonaOutputDTO> getPersonsByName(String name);

    List<PersonaOutputDTO> getPersonWithCriteriaQuery (
            Optional<String> name,
            Optional<String>  surname,
            Optional<String>  company,
            Optional<String>  teacherName);

    PersonaOutputDTO postPerson(PersonaInputDTO personInputDTO) throws MethodArgumentNotValidException;

    PersonaOutputDTO updatePerson(int id, PersonaInputDTO personaInputDTO);

    PersonaOutputDTO deletePerson(int id);

}

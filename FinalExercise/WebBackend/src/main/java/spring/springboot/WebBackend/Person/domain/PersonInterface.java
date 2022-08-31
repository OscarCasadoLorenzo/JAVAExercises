package spring.springboot.WebBackend.Person.domain;

import org.springframework.web.bind.MethodArgumentNotValidException;
import spring.springboot.WebBackend.Person.infraestructure.controller.dto.input.PersonInputDTO;
import spring.springboot.WebBackend.Person.infraestructure.controller.dto.output.PersonOutputDTO;

import java.util.List;

public interface PersonInterface {

    List<PersonOutputDTO> getAllPersons();

    boolean existsPerson(int id);

    PersonOutputDTO getPersonByID(int id);

    PersonOutputDTO postPerson(PersonInputDTO personInputDTO);

    PersonOutputDTO updatePerson(int id, PersonInputDTO personaInputDTO);

    PersonOutputDTO deletePerson(int id);
}

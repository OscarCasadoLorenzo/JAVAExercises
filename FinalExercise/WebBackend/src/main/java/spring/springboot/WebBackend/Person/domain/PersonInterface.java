package spring.springboot.WebBackend.Person.domain;

import org.springframework.web.bind.MethodArgumentNotValidException;
import spring.springboot.WebBackend.Person.infraestructure.controller.dto.input.PersonInputDTO;
import spring.springboot.WebBackend.Person.infraestructure.controller.dto.output.PersonOutputDTO;

import java.util.List;

public interface PersonInterface {

    List<PersonOutputDTO> getAllPersons();

    boolean existsPerson(String dni);

    PersonOutputDTO getPersonByID(String dni);

    PersonOutputDTO postPerson(PersonInputDTO personInputDTO);

    PersonOutputDTO updatePerson(String dni, PersonInputDTO personaInputDTO);

    PersonOutputDTO deletePerson(String dni);
}

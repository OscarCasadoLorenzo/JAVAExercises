package spring.springboot.WebBackend.Person.domain;

import org.springframework.web.bind.MethodArgumentNotValidException;
import spring.springboot.WebBackend.Person.infraestructure.controller.dto.input.PersonInputDTO;
import spring.springboot.WebBackend.Person.infraestructure.controller.dto.output.PersonOutputDTO;

import java.util.List;
import java.util.UUID;

public interface PersonInterface {

    List<PersonOutputDTO> getAllPersons();

    boolean existsPerson(UUID id);

    PersonOutputDTO getPersonByID(UUID id);

    PersonOutputDTO postPerson(PersonInputDTO personInputDTO);

    PersonOutputDTO updatePerson(UUID id, PersonInputDTO personaInputDTO);

    PersonOutputDTO deletePerson(UUID id);
}

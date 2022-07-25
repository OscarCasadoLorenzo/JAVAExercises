package spring.springboot.TableRelations.Persona.domain;

import org.springframework.web.bind.MethodArgumentNotValidException;
import spring.springboot.TableRelations.Persona.infraestructure.controller.dto.input.PersonaInputDTO;
import spring.springboot.TableRelations.Persona.infraestructure.controller.dto.output.PersonaOutputDTO;

import java.util.List;

public interface PersonInterface {

    List<PersonaOutputDTO> getAllPersons();

    boolean existsPerson(int id);

    PersonaOutputDTO getPersonByID(int id);

    List<PersonaOutputDTO> getPersonsByName(String name);

    PersonaOutputDTO postPerson(PersonaInputDTO personInputDTO) throws MethodArgumentNotValidException;

    PersonaOutputDTO updatePerson(int id, PersonaInputDTO personaInputDTO);

    PersonaOutputDTO deletePerson(int id);
}

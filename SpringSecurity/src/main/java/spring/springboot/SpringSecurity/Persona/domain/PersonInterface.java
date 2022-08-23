package spring.springboot.SpringSecurity.Persona.domain;

import spring.springboot.SpringSecurity.Persona.infraestructure.controller.dto.input.PersonaInputDTO;
import spring.springboot.SpringSecurity.Persona.infraestructure.controller.dto.output.PersonaOutputDTO;

import java.util.List;

public interface PersonInterface {

    String login(String user, String password);

    List<PersonaOutputDTO> getAllPersons();

    boolean existsPerson(int id);

    PersonaOutputDTO getPersonByID(int id);

    List<PersonaOutputDTO> getPersonsByName(String name);

    PersonaOutputDTO postPerson(PersonaInputDTO personInputDTO);

    PersonaOutputDTO updatePerson(int id, PersonaInputDTO personaInputDTO);

    PersonaOutputDTO deletePerson(int id);
}

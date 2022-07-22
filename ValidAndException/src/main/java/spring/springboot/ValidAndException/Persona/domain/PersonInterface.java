package spring.springboot.ValidAndException.Persona.domain;

import spring.springboot.JPAExample.Persona.infraestructure.controller.dto.input.PersonaInputDTO;
import spring.springboot.JPAExample.Persona.infraestructure.controller.dto.output.PersonaOutputDTO;

import java.util.List;

public interface PersonInterface {

    List<PersonaOutputDTO> getAllPersons();

    boolean existsPerson(int id);

    PersonaOutputDTO getPersonByID(int id);

    List<PersonaOutputDTO> getPersonsByName(String name);

    PersonaOutputDTO postPerson(PersonaInputDTO personInputDTO);

    PersonaOutputDTO updatePerson(int id, PersonaInputDTO personaInputDTO);

    PersonaOutputDTO deletePerson(int id);
}

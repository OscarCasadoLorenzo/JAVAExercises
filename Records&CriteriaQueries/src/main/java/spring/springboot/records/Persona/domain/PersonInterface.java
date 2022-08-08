package spring.springboot.records.Persona.domain;

import spring.springboot.records.Persona.infraestructure.controller.dto.input.PersonaInputDTO;
import spring.springboot.records.Persona.infraestructure.controller.dto.output.PersonaOutputDTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PersonInterface {

    List<PersonaOutputDTO> getAllPersons();

    boolean existsPerson(int id);

    PersonaOutputDTO getPersonByID(int id);

    List<PersonaOutputDTO> getPersonsByName(String name);

    List<PersonaOutputDTO> getPersonsWithCriteriaQuery(
            Optional<String> name,
            Optional<String> user,
            Optional<Date> creation_date,
            String dateCondition,
            Optional<String> sorting);

    PersonaOutputDTO postPerson(PersonaInputDTO personInputDTO);

    PersonaOutputDTO updatePerson(int id, PersonaInputDTO personaInputDTO);

    PersonaOutputDTO deletePerson(int id);
}

package spring.springboot.SpringSecurity.Persona.infraestructure.controller.dto.output;

import lombok.Data;
import spring.springboot.SpringSecurity.Persona.domain.PersonEntity;

import java.util.Date;

@Data
public class PersonaOutputDTO {
    //We delete id & password attributes for security

    private String name;
    private int id;
    private String password;
    private String role;


    public PersonaOutputDTO(PersonEntity personEntity){
        if (personEntity == null)
            return;

        name = personEntity.getName();
        id = personEntity.getId_person();
        password = personEntity.getPassword();
        role = personEntity.getRole();
    }
}

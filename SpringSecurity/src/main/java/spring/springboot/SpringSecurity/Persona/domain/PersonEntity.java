package spring.springboot.SpringSecurity.Persona.domain;

import lombok.Data;
import spring.springboot.SpringSecurity.Persona.infraestructure.controller.dto.input.PersonaInputDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class PersonEntity {
    @Id
    @GeneratedValue
    int id_person;

    @Column(nullable = false)
    String password;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String role;

    public PersonEntity(){

    }

    public PersonEntity(PersonaInputDTO personaInputDTO){
        if (personaInputDTO == null)
            return;

        password = personaInputDTO.getPassword();
        name = personaInputDTO.getName();
        role = personaInputDTO.getRole();
    }

    public void updateEntity(PersonaInputDTO personaInputDTO){
        setPassword(personaInputDTO.getPassword());
        setName(personaInputDTO.getName());
        setRole(personaInputDTO.getRole());
    }
}

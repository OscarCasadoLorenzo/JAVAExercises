package spring.springboot.records.Persona.domain;

import lombok.Data;
import spring.springboot.records.Persona.infraestructure.controller.dto.input.PersonaInputDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class PersonEntity {
    @Id
    @GeneratedValue
    int id_person;

    @Column(nullable = false)
    String usuario;

    @Column(nullable = false)
    String password;

    @Column(nullable = false)
    String name;

    String surname;

    @Column(nullable = false)
    String company_email;

    @Column(nullable = false)
    String personal_email;

    @Column(nullable = false)
    String city;

    @Column(nullable = false)
    boolean active;

    Date created_date;

    String image_url;

    Date termination_date;

    public PersonEntity(){

    }

    public PersonEntity(PersonaInputDTO personaInputDTO){
        if (personaInputDTO == null)
            return;

        usuario = personaInputDTO.usuario();
        password = personaInputDTO.password();
        name = personaInputDTO.name();
        surname = personaInputDTO.surname();
        company_email = personaInputDTO.company_email();
        personal_email = personaInputDTO.personal_email();
        city = personaInputDTO.city();
        active = personaInputDTO.active();
        created_date = personaInputDTO.created_date();
        image_url = personaInputDTO.image_url();
        termination_date = personaInputDTO.termination_date();
    }

    public void updateEntity(PersonaInputDTO personaInputDTO){
        setUsuario(personaInputDTO.usuario());
        setPassword(personaInputDTO.password());
        setName(personaInputDTO.name());
        setSurname(personaInputDTO.surname());
        setCompany_email(personaInputDTO.company_email());
        setPersonal_email(personaInputDTO.personal_email());
        setCity(personaInputDTO.city());
        setActive(personaInputDTO.active());
        setCreated_date(personaInputDTO.created_date());
        setImage_url(personaInputDTO.image_url());
        setTermination_date(personaInputDTO.termination_date());
    }
}

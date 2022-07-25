package spring.springboot.TableRelations.Persona.domain;

import lombok.Data;
import spring.springboot.TableRelations.Persona.infraestructure.controller.dto.input.PersonaInputDTO;

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

        usuario = personaInputDTO.getUsuario();
        password = personaInputDTO.getPassword();
        name = personaInputDTO.getName();
        surname = personaInputDTO.getSurname();
        company_email = personaInputDTO.getCompany_email();
        personal_email = personaInputDTO.getPersonal_email();
        city = personaInputDTO.getCity();
        active = personaInputDTO.isActive();
        created_date = personaInputDTO.getCreated_date();
        image_url = personaInputDTO.getImage_url();
        termination_date = personaInputDTO.getTermination_date();
    }

    public void updateEntity(PersonaInputDTO personaInputDTO){
        setUsuario(personaInputDTO.getUsuario());
        setPassword(personaInputDTO.getPassword());
        setName(personaInputDTO.getName());
        setSurname(personaInputDTO.getSurname());
        setCompany_email(personaInputDTO.getCompany_email());
        setPersonal_email(personaInputDTO.getPersonal_email());
        setCity(personaInputDTO.getCity());
        setActive(personaInputDTO.isActive());
        setCreated_date(personaInputDTO.getCreated_date());
        setImage_url(personaInputDTO.getImage_url());
        setTermination_date(personaInputDTO.getTermination_date());
    }
}

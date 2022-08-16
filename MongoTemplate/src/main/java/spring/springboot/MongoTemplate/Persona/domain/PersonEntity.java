package spring.springboot.MongoTemplate.Persona.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import spring.springboot.MongoTemplate.Persona.infraestructure.controller.dto.input.PersonaInputDTO;


import java.util.Date;

@Document
@Data
public class PersonEntity {
    @Id
    int id_person;

    String usuario;

    String password;

    String name;

    String surname;

    String company_email;

    String personal_email;

    String city;

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

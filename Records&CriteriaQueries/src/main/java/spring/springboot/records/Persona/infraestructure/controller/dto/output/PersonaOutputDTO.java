package spring.springboot.records.Persona.infraestructure.controller.dto.output;

import lombok.Data;
import spring.springboot.records.Persona.domain.PersonEntity;

import java.util.Date;

public record PersonaOutputDTO(
        //We delete id & password attributes for security
        String usuario,
        String name,
        String surname,
        String company_email,
        String personal_email,
        String city,
        boolean active,
        Date created_date,
        String image_url
) {


    public PersonaOutputDTO(PersonEntity personEntity){
        this(
            personEntity.getUsuario(),
            personEntity.getName(),
            personEntity.getSurname(),
            personEntity.getCompany_email(),
            personEntity.getPersonal_email(),
            personEntity.getCity(),
            personEntity.isActive(),
            personEntity.getCreated_date(),
            personEntity.getImage_url()
        );
    }
}

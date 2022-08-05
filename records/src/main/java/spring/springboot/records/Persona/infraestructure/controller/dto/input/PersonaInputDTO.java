package spring.springboot.records.Persona.infraestructure.controller.dto.input;

import lombok.Data;

import java.util.Date;

public record PersonaInputDTO(
        String usuario,
        String password,
        String name,
        String surname,
        String company_email,
        String personal_email,
        String city,
        boolean active,
        Date created_date,
        String image_url,
        Date termination_date
) {

}

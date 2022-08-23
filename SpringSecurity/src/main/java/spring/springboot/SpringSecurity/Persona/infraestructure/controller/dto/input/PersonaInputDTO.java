package spring.springboot.SpringSecurity.Persona.infraestructure.controller.dto.input;

import lombok.Data;

import java.util.Date;

@Data
public class PersonaInputDTO {
    private String password;
    private String name;
    private String role = "user";
}

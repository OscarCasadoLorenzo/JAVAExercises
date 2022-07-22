package spring.springboot.ValidAndException.Persona.infraestructure.controller.dto.input;

import lombok.Data;

import javax.validation.Valid;
import java.util.Date;

@Data
public class PersonaInputDTO {
    @Valid
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private boolean active;
    private Date created_date;
    private String image_url;
    private Date termination_date;
}

package spring.springboot.TableRelations.Persona.infraestructure.controller.dto.input;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class PersonaInputDTO {
    @NotBlank
    private String usuario;

    @NotBlank
    private String password;

    @NotBlank
    private String name;

    private String surname;

    @NotBlank
    private String company_email;

    @NotBlank
    private String personal_email;

    @NotBlank
    private String city;

    @NotNull
    private boolean active;

    private Date created_date;

    private String image_url;

    private Date termination_date;
}

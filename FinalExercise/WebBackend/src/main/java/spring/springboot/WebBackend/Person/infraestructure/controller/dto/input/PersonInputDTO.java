package spring.springboot.WebBackend.Person.infraestructure.controller.dto.input;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class PersonInputDTO {
    @NotBlank(message = "DNI property is required.")
    private String dni;

    @NotBlank(message = "Email property is required.")
    @Email(message = "Email property dont have correct syntax.")
    private String email;

    @NotBlank
    private String password;

    @NotBlank(message = "Name property is required.")
    @Size(min = 3, message = "Name property should have at least 3 characters.")
    private String name;

    @NotBlank(message = "Surname property is required.")
    @Size(min = 3, message = "Surname property should have at least 3 characters.")
    private String surname;

    @NotBlank(message = "Phone number property is required.")
    @Pattern(regexp="^[0-9]{9}", message = "Phone property dont have correct syntax.")
    private String phone;


}

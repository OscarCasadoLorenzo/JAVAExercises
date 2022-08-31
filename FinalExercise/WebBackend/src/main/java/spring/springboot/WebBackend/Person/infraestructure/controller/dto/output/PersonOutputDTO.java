package spring.springboot.WebBackend.Person.infraestructure.controller.dto.output;

import spring.springboot.WebBackend.Person.domain.PersonEntity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class PersonOutputDTO {

    private String dni;
    private String email;
    private String password;
    private String name;
    private String surname;
    private String phone;
    private String rol;

    public PersonOutputDTO(PersonEntity personEntity){
        this.dni = personEntity.getDni();
        this.email = personEntity.getEmail();
        this.password = personEntity.getPassword();
        this.name = personEntity.getName();
        this.surname = personEntity.getSurname();
        this.phone = personEntity.getPhone();
        this.rol = personEntity.getRol();
    }
}

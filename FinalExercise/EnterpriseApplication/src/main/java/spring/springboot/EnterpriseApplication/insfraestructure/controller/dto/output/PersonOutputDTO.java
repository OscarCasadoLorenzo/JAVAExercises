package spring.springboot.EnterpriseApplication.insfraestructure.controller.dto.output;

import lombok.Data;
import spring.springboot.EnterpriseApplication.domain.PersonEntity;

@Data
public class PersonOutputDTO {
    private Integer id;
    private String dni;
    private String email;
    private String password;
    private String name;
    private String surname;
    private String phone;
    private String rol;

    public PersonOutputDTO(PersonEntity personEntity){
        this.id = personEntity.getId();
        this.dni = personEntity.getDni();
        this.email = personEntity.getEmail();
        this.password = personEntity.getPassword();
        this.name = personEntity.getName();
        this.surname = personEntity.getSurname();
        this.phone = personEntity.getPhone();
        this.rol = personEntity.getRol();
    }
}

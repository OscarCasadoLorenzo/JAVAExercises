package spring.springboot.TableRelations.Person.infraestructure.controller.dto.output;

import lombok.Data;
import spring.springboot.TableRelations.Person.domain.PersonEntity;

import java.util.Date;

@Data
public class PersonaOutputDTO {
    //We delete id & password attributes for security
    private String usuario;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private boolean active;
    private Date created_date;
    private String image_url;
    private Date termination_date;

    public PersonaOutputDTO(PersonEntity personEntity){
        if (personEntity == null)
            return;

        usuario = personEntity.getUsuario();
        name = personEntity.getName();
        surname = personEntity.getSurname();
        company_email = personEntity.getCompany_email();
        personal_email = personEntity.getPersonal_email();
        city = personEntity.getCity();
        active = personEntity.isActive();
        created_date = personEntity.getCreated_date();
        image_url = personEntity.getImage_url();
        termination_date = personEntity.getTermination_date();
    }
}

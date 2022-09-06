package spring.springboot.WebBackend.Person.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import spring.springboot.WebBackend.Person.infraestructure.controller.dto.input.PersonInputDTO;
import spring.springboot.WebBackend.Ticket.domain.TicketEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "PERSONS")
public class PersonEntity {
    @Id
    @Column(name="personID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "dni")
    private String dni;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "role")
    @ColumnDefault("USER")
    private String rol;

    @OneToMany(mappedBy = "personEntity")
    private List<TicketEntity> ticketEntity;

    public PersonEntity(PersonInputDTO personInputDTO) {
        this.dni = personInputDTO.getDni();
        this.email = personInputDTO.getEmail();
        this.password = personInputDTO.getPassword();
        this.name = personInputDTO.getName();
        this.surname = personInputDTO.getSurname();
        this.phone = personInputDTO.getPhone();
        this.rol = "USER";
    }

    public PersonEntity(String dni, String email, String password, String name, String surname, String phone, String role) {
        this.dni = dni;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.rol = role;
    }

    public void updateEntity(PersonInputDTO personaInputDTO) {
        this.dni = personaInputDTO.getDni();
        this.email = personaInputDTO.getEmail();
        this.password = personaInputDTO.getPassword();
        this.name = personaInputDTO.getName();
        this.surname = personaInputDTO.getSurname();
        this.phone = personaInputDTO.getPhone();
    }
}

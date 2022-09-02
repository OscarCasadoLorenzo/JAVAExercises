package spring.springboot.WebBackend.Person.domain;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import spring.springboot.WebBackend.Person.infraestructure.controller.dto.input.PersonInputDTO;
import spring.springboot.WebBackend.Ticket.domain.TicketEntity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "PERSONS")
public class PersonEntity {
    @Column(name = "id")
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

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

    @Column(name = "rol")
    @ColumnDefault("USER")
    private String rol;

    @OneToMany
    @JoinColumn(name="ticketID")
    private List<TicketEntity> tickets;

    PersonEntity(){

    }

    public PersonEntity(PersonInputDTO personInputDTO) {
        this.dni = personInputDTO.getDni();
        this.email = personInputDTO.getEmail();
        this.password = personInputDTO.getPassword();
        this.name = personInputDTO.getName();
        this.surname = personInputDTO.getSurname();
        this.phone = personInputDTO.getPhone();
        this.rol = "USER";
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

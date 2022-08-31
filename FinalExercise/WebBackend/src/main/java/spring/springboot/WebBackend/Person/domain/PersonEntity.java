package spring.springboot.WebBackend.Person.domain;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import spring.springboot.WebBackend.Person.infraestructure.controller.dto.input.PersonInputDTO;
import spring.springboot.WebBackend.Ticket.domain.TicketEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "PERSONS")
public class PersonEntity {
    @Column(name = "id")
    @Id
    private String dni;

    @Column(name = "email")
    String email;

    @Column(name = "password")
    String password;

    @Column(name = "name")
    String name;

    @Column(name = "surname")
    String surname;

    @Column(name = "phone")
    String phone;

    @Column(name = "rol")
    @ColumnDefault("USER")
    String rol;

    @OneToMany
    @JoinColumn(name="ticketID")
    List<TicketEntity> tickets;

    PersonEntity(){

    }

    public PersonEntity(PersonInputDTO personInputDTO) {
        this.dni = personInputDTO.getDni();
        this.email = personInputDTO.getEmail();
        this.password = personInputDTO.getPassword();
        this.name = personInputDTO.getName();
        this.surname = personInputDTO.getSurname();
        this.phone = personInputDTO.getPhone();
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

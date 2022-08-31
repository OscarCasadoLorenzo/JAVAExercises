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

    }
}

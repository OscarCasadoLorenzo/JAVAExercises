package spring.springboot.WebBackend.Person.domain;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import spring.springboot.WebBackend.Ticket.domain.TicketEntity;

import javax.persistence.*;
import java.util.Arrays;
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

    @Column(name = "name")
    String name;

    @Column(name = "surname")
    String surname;

    @Column(name = "phone")
    Integer phone;

    @Column(name = "rol")
    @ColumnDefault("USER")
    String rol;

    @OneToMany
    @JoinColumn(name="ticketID")
    List<TicketEntity> tickets;

    PersonEntity(){

    }

    public PersonEntity(String email, String name, String surname, Integer phone) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }
}

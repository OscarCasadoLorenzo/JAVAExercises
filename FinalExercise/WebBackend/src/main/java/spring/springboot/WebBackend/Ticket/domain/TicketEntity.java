package spring.springboot.WebBackend.Ticket.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import spring.springboot.WebBackend.Person.domain.PersonEntity;
import spring.springboot.WebBackend.Trip.domain.TripEntity;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "TICKETS")
public class TicketEntity {
    @Column(name = "id")
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @ManyToOne
    @JoinColumn(name="tripID")
    TripEntity tripEntity;

    @ManyToOne
    @JoinColumn(name="personID")
    PersonEntity personEntity;

}

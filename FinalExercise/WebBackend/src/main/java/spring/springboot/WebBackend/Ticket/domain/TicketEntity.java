package spring.springboot.WebBackend.Ticket.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;
import spring.springboot.WebBackend.Person.domain.PersonEntity;

import javax.persistence.*;
import java.util.Date;
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

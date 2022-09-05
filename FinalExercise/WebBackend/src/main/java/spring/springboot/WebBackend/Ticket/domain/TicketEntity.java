package spring.springboot.WebBackend.Ticket.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import spring.springboot.WebBackend.Person.domain.PersonEntity;
import spring.springboot.WebBackend.Ticket.infraestructure.controller.dto.input.TicketInputDTO;
import spring.springboot.WebBackend.Trip.domain.TripEntity;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TICKETS")
public class TicketEntity {
    @Id
    @Column(name="ticketID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="tripID")
    private TripEntity tripEntity;

    @ManyToOne
    @JoinColumn(name="personID")
    private PersonEntity personEntity;

    public TicketEntity(TripEntity tripEntity, PersonEntity personEntity){
        this.tripEntity = tripEntity;
        this.personEntity = personEntity;
    }

    public void updateEntity(TripEntity tripEntity, PersonEntity personEntity){
        this.tripEntity = tripEntity;
        this.personEntity = personEntity;
    }
}

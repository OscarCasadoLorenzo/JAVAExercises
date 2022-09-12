package spring.springboot.EnterpriseApplication.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    @Column(name = "confirmed")
    private Boolean confirmed;

    public TicketEntity(TripEntity tripEntity, PersonEntity personEntity){
        this.confirmed = false;
        this.tripEntity = tripEntity;
        this.personEntity = personEntity;
    }

    public void updateEntity(TripEntity tripEntity, PersonEntity personEntity){
        this.tripEntity = tripEntity;
        this.personEntity = personEntity;
    }
}

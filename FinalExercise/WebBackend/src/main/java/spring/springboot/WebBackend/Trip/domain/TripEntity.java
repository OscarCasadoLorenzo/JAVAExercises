package spring.springboot.WebBackend.Trip.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import spring.springboot.WebBackend.Person.domain.PersonEntity;
import spring.springboot.WebBackend.Ticket.domain.TicketEntity;
import spring.springboot.WebBackend.Trip.infraestructure.controller.dto.input.TripInputDTO;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TRIPS")
public class TripEntity {
    @Id
    @Column(name="tripID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "exitDate")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "exitHour")
    private Integer exitHour;

    @OneToMany(mappedBy = "tripEntity")
    List<TicketEntity> ticketEntity;

    public TripEntity(TripInputDTO tripInputDTO){
        this.origin= tripInputDTO.getOrigin();
        this.destination = tripInputDTO.getDestination();
        this.capacity = tripInputDTO.getCapacity();
        this.date = tripInputDTO.getDate();
        this.exitHour = tripInputDTO.getHour();
    }

    public void updateEntity(TripInputDTO tripInputDTO){
        this.origin= tripInputDTO.getOrigin();
        this.destination = tripInputDTO.getDestination();
        this.capacity = tripInputDTO.getCapacity();
        this.date = tripInputDTO.getDate();
        this.exitHour = tripInputDTO.getHour();
    }

}

package spring.springboot.WebBackend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.springboot.WebBackend.infraestructure.controller.dto.input.TripInputDTO;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TRIPS")
public class TripEntity {
    @Id
    @Column(name="tripID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "exitDate")
    @Temporal(TemporalType.DATE)
    private Date exitDate;

    @Column(name = "exitHour")
    private Integer exitHour;

    @OneToMany(mappedBy = "tripEntity")
    List<TicketEntity> ticketEntity;

    public TripEntity(TripInputDTO tripInputDTO){
        this.origin= "Vitoria";
        this.capacity = 40;
        this.destination = tripInputDTO.getDestination();
        this.exitDate = tripInputDTO.getDate();
        this.exitHour = tripInputDTO.getHour();
    }

    public TripEntity(String destination, Date exitDate, Integer exitHour){
        this.origin= "Vitoria";
        this.capacity = 40;
        this.destination = destination;
        this.exitDate = exitDate;
        this.exitHour = exitHour;
    }

    public void updateEntity(TripInputDTO tripInputDTO){
        this.destination = tripInputDTO.getDestination();
        this.exitDate = tripInputDTO.getDate();
        this.exitHour = tripInputDTO.getHour();
    }
}

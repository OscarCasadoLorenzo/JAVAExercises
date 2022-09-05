package spring.springboot.WebBackend.Trip.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import spring.springboot.WebBackend.Ticket.domain.TicketEntity;

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

    @Column(name = "date")
    private Date date;

    @Column(name = "exitHour")
    private Integer exitHour;

    @OneToMany(mappedBy = "tripEntity")
    List<TicketEntity> ticketEntity;
}

package spring.springboot.WebBackend.Trip.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "TRIPS")
public class TripEntity {
    @Column(name = "id")
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column(name = "origin")
    String origin;

    @Column(name = "destination")
    String destination;

    @Column(name = "capacity")
    Integer capacity;

    @Column(name = "date")
    Date date;

    @Column(name = "date")
    Integer hour;
}

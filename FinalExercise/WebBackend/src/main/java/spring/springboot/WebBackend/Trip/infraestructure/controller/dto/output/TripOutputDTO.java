package spring.springboot.WebBackend.Trip.infraestructure.controller.dto.output;

import lombok.Setter;
import spring.springboot.WebBackend.Trip.domain.TripEntity;

import java.util.Date;
import java.util.UUID;

@Setter
public class TripOutputDTO {
    private Integer id;
    private String origin;
    private String destination;
    private Integer capacity;
    private Date date;
    private Integer hour;

    public TripOutputDTO(TripEntity tripEntity){
        this.id = tripEntity.getId();
        this.origin = tripEntity.getOrigin();
        this.destination = tripEntity.getDestination();
        this.capacity = tripEntity.getCapacity();
        this.date = tripEntity.getDate();
        this.hour = tripEntity.getExitHour();
    }
}

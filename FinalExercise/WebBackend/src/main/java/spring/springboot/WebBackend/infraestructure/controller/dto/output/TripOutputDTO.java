package spring.springboot.WebBackend.infraestructure.controller.dto.output;

import lombok.Getter;
import lombok.Setter;
import spring.springboot.WebBackend.domain.TripEntity;

import java.util.Date;

@Setter
@Getter
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
        this.date = tripEntity.getExitDate();
        this.hour = tripEntity.getExitHour();
    }
}

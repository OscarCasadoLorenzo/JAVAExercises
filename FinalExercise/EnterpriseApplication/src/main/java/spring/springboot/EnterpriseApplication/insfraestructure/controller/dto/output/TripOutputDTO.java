package spring.springboot.EnterpriseApplication.insfraestructure.controller.dto.output;

import lombok.*;
import spring.springboot.EnterpriseApplication.domain.TripEntity;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @Override
    public String toString() {
        return "Trip id=" + id + "\n" +
                "Trip origin='" + origin + "\n" +
                "Trip destination='" + destination + "\n" +
                "Trip capacity=" + capacity + "\n" +
                "Trip date=" + date  + "\n" +
                "Trip hour=" + hour;
    }
}

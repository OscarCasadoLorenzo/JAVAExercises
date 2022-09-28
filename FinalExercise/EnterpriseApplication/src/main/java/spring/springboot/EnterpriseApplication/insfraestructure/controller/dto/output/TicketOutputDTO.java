package spring.springboot.EnterpriseApplication.insfraestructure.controller.dto.output;

import lombok.*;
import spring.springboot.EnterpriseApplication.domain.TicketEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketOutputDTO {
    private Integer ticketID;

    private PersonOutputDTO person;

    private TripOutputDTO trip;

    private Boolean confirmed;

    public TicketOutputDTO(TicketEntity ticketEntity){
        this.ticketID = ticketEntity.getId();
        this.person = new PersonOutputDTO(ticketEntity.getPersonEntity());
        this.trip = new TripOutputDTO(ticketEntity.getTripEntity());
    }

    @Override
    public String toString() {
        return "Ticket ID: " + ticketID + "\n" +
                 person + "\n" +
                 trip;
    }
}

package spring.springboot.WebBackend.Ticket.infraestructure.controller.dto.output;

import lombok.Getter;
import lombok.Setter;
import spring.springboot.WebBackend.Person.infraestructure.controller.dto.output.PersonOutputDTO;
import spring.springboot.WebBackend.Ticket.domain.TicketEntity;
import spring.springboot.WebBackend.Trip.infraestructure.controller.dto.output.TripOutputDTO;

import java.util.UUID;

@Getter
@Setter
public class TicketOutputDTO {
    private Integer ticketID;

    private PersonOutputDTO person;

    private TripOutputDTO trip;

    public TicketOutputDTO(TicketEntity ticketEntity){
        this.ticketID = ticketEntity.getId();
        //this.person = new PersonOutputDTO(ticketEntity.getPersonEntity());
        //this.trip = new TripOutputDTO(ticketEntity.getTripEntity());
    }
}

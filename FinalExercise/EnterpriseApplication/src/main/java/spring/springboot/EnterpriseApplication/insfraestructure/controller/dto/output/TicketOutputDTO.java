package spring.springboot.EnterpriseApplication.insfraestructure.controller.dto.output;

import lombok.Getter;
import lombok.Setter;
import spring.springboot.WebBackend.domain.TicketEntity;

@Getter
@Setter
public class TicketOutputDTO {
    private Integer ticketID;

    private PersonOutputDTO person;

    private TripOutputDTO trip;

    private Boolean confirmed;

    public TicketOutputDTO(TicketEntity ticketEntity){
        this.ticketID = ticketEntity.getId();
        this.person = new PersonOutputDTO(ticketEntity.getPersonEntity());
        this.trip = new TripOutputDTO(ticketEntity.getTripEntity());
        this.confirmed = ticketEntity.getConfirmed();
    }
}

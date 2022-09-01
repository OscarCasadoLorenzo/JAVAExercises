package spring.springboot.WebBackend.Ticket.domain;

import spring.springboot.WebBackend.Ticket.infraestructure.controller.dto.input.TicketInputDTO;
import spring.springboot.WebBackend.Ticket.infraestructure.controller.dto.output.TicketOutputDTO;

import java.util.List;
import java.util.UUID;

public interface TicketInterface {
    List<TicketOutputDTO> getAllTickets();

    boolean existsTicket(UUID id);

    TicketOutputDTO getTicketByID(UUID id);

    TicketOutputDTO postTicket(TicketInputDTO ticketInputDTO);

    TicketOutputDTO updateTicket(UUID id, TicketInputDTO ticketInputDTO);

    TicketOutputDTO deleteTicket(UUID id);
}

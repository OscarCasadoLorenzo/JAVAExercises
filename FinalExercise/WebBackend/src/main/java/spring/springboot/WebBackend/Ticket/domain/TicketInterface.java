package spring.springboot.WebBackend.Ticket.domain;

import spring.springboot.WebBackend.Ticket.infraestructure.controller.dto.input.TicketInputDTO;
import spring.springboot.WebBackend.Ticket.infraestructure.controller.dto.output.TicketOutputDTO;

import java.util.List;
import java.util.UUID;

public interface TicketInterface {
    List<TicketOutputDTO> getAllTickets();

    TicketOutputDTO getTicketByID(Integer id);

    TicketOutputDTO postTicket(TicketInputDTO ticketInputDTO);

    TicketOutputDTO updateTicket(Integer id, TicketInputDTO ticketInputDTO);

    TicketOutputDTO deleteTicket(Integer id);
}

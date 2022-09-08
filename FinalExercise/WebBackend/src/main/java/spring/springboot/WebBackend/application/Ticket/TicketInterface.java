package spring.springboot.WebBackend.application.Ticket;

import spring.springboot.WebBackend.infraestructure.controller.dto.input.TicketInputDTO;
import spring.springboot.WebBackend.infraestructure.controller.dto.output.TicketOutputDTO;

import java.util.List;

public interface TicketInterface {
    List<TicketOutputDTO> getAllTickets();

    TicketOutputDTO getTicketByID(Integer id);

    TicketOutputDTO postTicket(TicketInputDTO ticketInputDTO);

    TicketOutputDTO updateTicket(Integer id, TicketInputDTO ticketInputDTO);

    TicketOutputDTO deleteTicket(Integer id);
}

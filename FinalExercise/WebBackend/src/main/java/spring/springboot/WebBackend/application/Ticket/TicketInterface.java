package spring.springboot.WebBackend.application.Ticket;

import spring.springboot.WebBackend.infraestructure.controller.dto.input.TicketInputDTO;
import spring.springboot.WebBackend.infraestructure.controller.dto.output.TicketOutputDTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TicketInterface {
    List<TicketOutputDTO> getAllTickets();

    List<TicketOutputDTO> getTicketsByDestination(
            String destination,
            Date inferiorDate,
            Optional<Date> superiorDate,
            Optional<Integer> superiorExitHour,
            Optional<Integer> inferiorExitHour);

    TicketOutputDTO postTicket(TicketInputDTO ticketInputDTO);
}

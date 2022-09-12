package spring.springboot.EnterpriseApplication.application.Ticket;

import spring.springboot.EnterpriseApplication.insfraestructure.controller.dto.input.TicketInputDTO;
import spring.springboot.EnterpriseApplication.insfraestructure.controller.dto.output.TicketOutputDTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TicketInterface {
    List<TicketOutputDTO> getAllTickets();

    TicketOutputDTO getTicketByID(Integer id);


    List<TicketOutputDTO> getTicketsByDestination(
            String destination,
            Date inferiorDate,
            Optional<Date> superiorDate,
            Optional<Integer> superiorExitHour,
            Optional<Integer> inferiorExitHour);

    TicketOutputDTO postTicket(TicketInputDTO ticketInputDTO);

    TicketOutputDTO updateTicket(Integer id, TicketInputDTO ticketInputDTO);

    TicketOutputDTO deleteTicket(Integer id);
}

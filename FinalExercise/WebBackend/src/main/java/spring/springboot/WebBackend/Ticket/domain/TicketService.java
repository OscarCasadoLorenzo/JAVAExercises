package spring.springboot.WebBackend.Ticket.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.springboot.WebBackend.Ticket.infraestructure.controller.dto.input.TicketInputDTO;
import spring.springboot.WebBackend.Ticket.infraestructure.controller.dto.output.TicketOutputDTO;
import spring.springboot.WebBackend.Ticket.infraestructure.repository.TicketRepository;

import java.util.List;
import java.util.UUID;

@Service
public class TicketService implements TicketInterface {

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public List<TicketOutputDTO> getAllTickets() {
        return null;
    }

    @Override
    public boolean existsTicket(UUID id) {
        return false;
    }

    @Override
    public TicketOutputDTO getTicketByID(UUID id) {
        return null;
    }

    @Override
    public TicketOutputDTO postTicket(TicketInputDTO ticketInputDTO) {
        return null;
    }

    @Override
    public TicketOutputDTO updateTicket(UUID id, TicketInputDTO ticketInputDTO) {
        return null;
    }

    @Override
    public TicketOutputDTO deleteTicket(UUID id) {
        return null;
    }
}

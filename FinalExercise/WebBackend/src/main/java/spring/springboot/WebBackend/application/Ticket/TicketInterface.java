package spring.springboot.WebBackend.application.Ticket;

import spring.springboot.WebBackend.infraestructure.controller.dto.input.TicketInputDTO;

import java.util.List;

public interface TicketInterface {
    String postTicket(TicketInputDTO ticketInputDTO);
}

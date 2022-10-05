package spring.springboot.WebBackend.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.springboot.WebBackend.application.Ticket.TicketService;
import spring.springboot.WebBackend.infraestructure.controller.dto.input.TicketInputDTO;
import spring.springboot.WebBackend.exceptions.UnprocesableException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/backweb/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping
    public String postTicketRoute(@Valid @RequestBody TicketInputDTO ticketInputDTO, BindingResult errors){
        if(errors.hasErrors())
            throw new UnprocesableException(errors);
        return ticketService.postTicket(ticketInputDTO);
    }
}

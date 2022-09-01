package spring.springboot.WebBackend.Ticket.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.springboot.WebBackend.Ticket.domain.TicketService;
import spring.springboot.WebBackend.Ticket.infraestructure.controller.dto.input.TicketInputDTO;
import spring.springboot.WebBackend.Ticket.infraestructure.controller.dto.output.TicketOutputDTO;
import spring.springboot.WebBackend.exceptions.UnprocesableException;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v0/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @GetMapping
    public List<TicketOutputDTO> getAllTicketsRoute(){
        return ticketService.getAllTickets();
    }

    @GetMapping("/{id}")
    public TicketOutputDTO getTicketByIDRoute(@PathVariable UUID id){
        return ticketService.getTicketByID(id);
    }


    @GetMapping("/availability/:destinationCity")
    public TicketOutputDTO getAvailabilityRoute(
            @RequestParam Date inferiorDate,
            @RequestParam(required = false) Date superiorDate,
            @RequestParam(required = false) Date inferiorHour,
            @RequestParam(required = false) Date superiorHour

    ){
        return null;
    }

    @PostMapping
    public TicketOutputDTO postTicketRoute(@Valid @RequestBody TicketInputDTO ticketInputDTO, BindingResult errors){
        if(errors.hasErrors())
            throw new UnprocesableException(errors);
        return ticketService.postTicket(ticketInputDTO);
    }

    @PutMapping("/{id}")
    public TicketOutputDTO updateTicketRoute(@PathVariable UUID id, @Valid @RequestBody TicketInputDTO ticketInputDTO, BindingResult errors){
        if(errors.hasErrors())
            throw new UnprocesableException(errors);
        return ticketService.updateTicket(id, ticketInputDTO);
    }

    @DeleteMapping("/{id}")
    public TicketOutputDTO deleteTicketRoute(@PathVariable UUID id){
        return ticketService.deleteTicket(id);
    }
}

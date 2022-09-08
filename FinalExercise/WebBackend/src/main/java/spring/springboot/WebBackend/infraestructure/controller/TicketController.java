package spring.springboot.WebBackend.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.springboot.WebBackend.application.Ticket.TicketService;
import spring.springboot.WebBackend.infraestructure.controller.dto.input.TicketInputDTO;
import spring.springboot.WebBackend.infraestructure.controller.dto.output.TicketOutputDTO;
import spring.springboot.WebBackend.exceptions.UnprocesableException;
import spring.springboot.WebBackend.infraestructure.controller.dto.output.TripOutputDTO;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    public TicketOutputDTO getTicketByIDRoute(@PathVariable Integer id){
        return ticketService.getTicketByID(id);
    }

    @GetMapping("/availability/{destination}")
    public List<TicketOutputDTO> getTicketsByDestinationRoute(
            @PathVariable String destination,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date inferiorDate,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Optional<Date> superiorDate,
            @RequestParam(required = false) Optional<Integer> inferiorHour,
            @RequestParam(required = false) Optional<Integer> superiorHour

    ){
        return ticketService.getTicketsByDestination(destination, inferiorDate, superiorDate, inferiorHour, superiorHour);
    }

    @PostMapping
    public TicketOutputDTO postTicketRoute(@Valid @RequestBody TicketInputDTO ticketInputDTO, BindingResult errors){
        if(errors.hasErrors())
            throw new UnprocesableException(errors);
        return ticketService.postTicket(ticketInputDTO);
    }

    @PutMapping("/{id}")
    public TicketOutputDTO updateTicketRoute(@PathVariable Integer id, @Valid @RequestBody TicketInputDTO ticketInputDTO, BindingResult errors){
        if(errors.hasErrors())
            throw new UnprocesableException(errors);
        return ticketService.updateTicket(id, ticketInputDTO);
    }

    @DeleteMapping("/{id}")
    public TicketOutputDTO deleteTicketRoute(@PathVariable Integer id){
        return ticketService.deleteTicket(id);
    }
}

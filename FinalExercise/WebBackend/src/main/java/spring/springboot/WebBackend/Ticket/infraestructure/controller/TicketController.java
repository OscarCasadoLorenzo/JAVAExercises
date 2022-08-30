package spring.springboot.WebBackend.Ticket.infraestructure.controller;

import org.springframework.web.bind.annotation.*;
import spring.springboot.WebBackend.Ticket.infraestructure.controller.dto.input.TicketInputDTO;
import spring.springboot.WebBackend.Ticket.infraestructure.controller.dto.output.TicketOutputDTO;

import java.util.Date;

@RestController
@RequestMapping("/api/v0")
public class TicketController {

    @PostMapping("/ticket")
    public TicketOutputDTO postTicketRoute(
            TicketInputDTO ticketInputDTO
    ){
        return null;
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


}

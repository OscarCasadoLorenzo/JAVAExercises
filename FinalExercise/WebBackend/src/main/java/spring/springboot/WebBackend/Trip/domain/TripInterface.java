package spring.springboot.WebBackend.Trip.domain;

import spring.springboot.WebBackend.Ticket.infraestructure.controller.dto.input.TicketInputDTO;
import spring.springboot.WebBackend.Ticket.infraestructure.controller.dto.output.TicketOutputDTO;
import spring.springboot.WebBackend.Trip.infraestructure.controller.dto.input.TripInputDTO;
import spring.springboot.WebBackend.Trip.infraestructure.controller.dto.output.TripOutputDTO;

import java.util.List;

public interface TripInterface {
    List<TripOutputDTO> getAllTrips();

    TripOutputDTO getTripsByID(Integer id);

    TripOutputDTO postTrip(TripInputDTO tripInputDTO);

    TripOutputDTO updateTrip(Integer id, TripInputDTO tripInputDTO);

    TripOutputDTO deleteTrip(Integer id);
}

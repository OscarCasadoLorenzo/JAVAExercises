package spring.springboot.WebBackend.Trip.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.springboot.WebBackend.Ticket.infraestructure.controller.dto.input.TicketInputDTO;
import spring.springboot.WebBackend.Trip.domain.TripService;
import spring.springboot.WebBackend.Trip.infraestructure.controller.dto.input.TripInputDTO;
import spring.springboot.WebBackend.Trip.infraestructure.controller.dto.output.TripOutputDTO;
import spring.springboot.WebBackend.exceptions.UnprocesableException;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v0")
public class TripController {

    @Autowired
    TripService tripService;
    @GetMapping
    public List<TripOutputDTO> getAllTripsRoute(){
        return tripService.getAllTrips();
    }

    @GetMapping("/{id}")
    public TripOutputDTO getTripByIDRoute(@PathVariable Integer id){
        return tripService.getTripByID(id);
    }

    @GetMapping("/availability/:destinationCity")
    public List<TripOutputDTO> getTripAvailabilityRoute(
            @RequestParam Date inferiorDate,
            @RequestParam(required = false) Date superiorDate,
            @RequestParam(required = false) Date inferiorHour,
            @RequestParam(required = false) Date superiorHour

    ){
        return null;
    }

    @PostMapping
    public TripOutputDTO postTripRoute(@Valid @RequestBody TripInputDTO tripInputDTO, BindingResult errors){
        if(errors.hasErrors())
            throw new UnprocesableException(errors);
        return tripService.postTrip(tripInputDTO);
    }

    @PutMapping("/{id}")
    public TripOutputDTO updateTripRoute(@PathVariable Integer id, @Valid @RequestBody TripInputDTO tripInputDTO, BindingResult errors){
        if(errors.hasErrors())
            throw new UnprocesableException(errors);
        return tripService.updateTrip(id, tripInputDTO);
    }

    @DeleteMapping("/{id}")
    public TripOutputDTO deleteTripRoute(@PathVariable Integer id){
        return tripService.deleteTrip(id);
    }
}

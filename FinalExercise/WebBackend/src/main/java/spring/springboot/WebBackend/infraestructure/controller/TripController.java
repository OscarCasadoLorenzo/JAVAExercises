package spring.springboot.WebBackend.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.springboot.WebBackend.application.Trip.TripService;
import spring.springboot.WebBackend.infraestructure.controller.dto.input.TripInputDTO;
import spring.springboot.WebBackend.infraestructure.controller.dto.output.TripOutputDTO;
import spring.springboot.WebBackend.exceptions.UnprocesableException;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("api/v0/trip")
public class TripController {

    List<String> permitedDestinations = Arrays.asList("Barcelona", "Bilbao", "Madrid", "Valencia");

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

    @GetMapping("/availability/{destination}")
    public List<TripOutputDTO> getTripsByAvailabilityRoute(
            @PathVariable String destination,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date inferiorDate,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Optional<Date> superiorDate,
            @RequestParam(required = false) Optional<Integer> inferiorHour,
            @RequestParam(required = false) Optional<Integer> superiorHour

    ){
        return tripService.getTripsByAvailability(destination, inferiorDate, superiorDate, inferiorHour, superiorHour);
    }

    @PostMapping
    public TripOutputDTO postTripRoute(@Valid @RequestBody TripInputDTO tripInputDTO, BindingResult errors){
        if(errors.hasErrors() || !permitedDestinations.contains(tripInputDTO.getDestination()))
            throw new UnprocesableException(errors);
        return tripService.postTrip(tripInputDTO);
    }

    @PutMapping("/{id}")
    public TripOutputDTO updateTripRoute(@PathVariable Integer id, @Valid @RequestBody TripInputDTO tripInputDTO, BindingResult errors){
        if(errors.hasErrors() || !permitedDestinations.contains(tripInputDTO.getDestination()))
            throw new UnprocesableException(errors);
        return tripService.updateTrip(id, tripInputDTO);
    }

    @DeleteMapping("/{id}")
    public TripOutputDTO deleteTripRoute(@PathVariable Integer id){
        return tripService.deleteTrip(id);
    }
}

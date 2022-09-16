package spring.springboot.WebBackend.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.springboot.WebBackend.application.Trip.OpenFeignTripClient;
import spring.springboot.WebBackend.exceptions.UnprocesableException;
import spring.springboot.WebBackend.infraestructure.controller.dto.input.TripInputDTO;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/backweb/trip")
public class TripController {

    List<String> permitedDestinations = Arrays.asList("Barcelona", "Bilbao", "Madrid", "Valencia");

    @Autowired
    OpenFeignTripClient tripClient;

    @GetMapping
    public ResponseEntity getAllTripsRoute(){
        return tripClient.getAllTrips();
    }

    @GetMapping("/{id}")
    public ResponseEntity getTripByIDRoute(@PathVariable Integer id){
        return tripClient.getTripByID(id);
    }

    @GetMapping("/availability/{destination}")
    public ResponseEntity getTripsByAvailabilityRoute(
            @PathVariable String destination,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date inferiorDate,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Optional<Date> superiorDate,
            @RequestParam(required = false) Optional<Integer> inferiorHour,
            @RequestParam(required = false) Optional<Integer> superiorHour

    ){
        return tripClient.getTripsByAvailability(destination, inferiorDate, superiorDate, inferiorHour, superiorHour);
    }

    @PostMapping
    public ResponseEntity postTripRoute(@Valid @RequestBody TripInputDTO tripInputDTO, BindingResult errors){
        if(errors.hasErrors() || !permitedDestinations.contains(tripInputDTO.getDestination()))
            throw new UnprocesableException(errors);
        return tripClient.postTrip(tripInputDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateTripRoute(@PathVariable Integer id, @Valid @RequestBody TripInputDTO tripInputDTO, BindingResult errors){
        if(errors.hasErrors() || !permitedDestinations.contains(tripInputDTO.getDestination()))
            throw new UnprocesableException(errors);
        return tripClient.updateTrip(id, tripInputDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTripRoute(@PathVariable Integer id){
        return tripClient.deleteTrip(id);
    }
}

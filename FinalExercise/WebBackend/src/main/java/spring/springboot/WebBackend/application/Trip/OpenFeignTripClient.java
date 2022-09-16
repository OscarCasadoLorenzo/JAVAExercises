package spring.springboot.WebBackend.application.Trip;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.springboot.WebBackend.infraestructure.controller.dto.input.TripInputDTO;

import java.util.Date;
import java.util.Optional;

@FeignClient(name = "backEnterprise", url="http://localhost:8000/")
public interface OpenFeignTripClient {
    @GetMapping("api/backenterprise/trip")
    ResponseEntity getAllTrips();

    @GetMapping("api/backenterprise/trip/{id}")
    ResponseEntity getTripByID(Integer id);

    @GetMapping("api/backenterprise/trip/availability/{destination}")
    ResponseEntity getTripsByAvailability(
            String destination,
            Date inferiorDate,
            Optional<Date> superiorDate,
            Optional<Integer> superiorExitHour,
            Optional<Integer> inferiorExitHour);

    @PostMapping("api/backenterprise/trip")
    ResponseEntity postTrip(TripInputDTO tripInputDTO);

    @PutMapping("api/backenterprise/trip/{id}")
    ResponseEntity updateTrip(Integer id, TripInputDTO tripInputDTO);

    @DeleteMapping("api/backenterprise/trip/{id}")
    ResponseEntity deleteTrip(Integer id);
}

package spring.springboot.EnterpriseApplication.application.Trip;

import spring.springboot.WebBackend.infraestructure.controller.dto.input.TripInputDTO;
import spring.springboot.WebBackend.infraestructure.controller.dto.output.TripOutputDTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TripInterface {
    List<TripOutputDTO> getAllTrips();

    TripOutputDTO getTripByID(Integer id);

    List<TripOutputDTO> getTripsByAvailability(
            String destination,
            Date inferiorDate,
            Optional<Date> superiorDate,
            Optional<Integer> superiorExitHour,
            Optional<Integer> inferiorExitHour);

    TripOutputDTO postTrip(TripInputDTO tripInputDTO);

    TripOutputDTO updateTrip(Integer id, TripInputDTO tripInputDTO);

    TripOutputDTO deleteTrip(Integer id);
}

package spring.springboot.WebBackend.Trip.domain;

import org.springframework.beans.factory.annotation.Autowired;
import spring.springboot.WebBackend.Trip.infraestructure.controller.dto.input.TripInputDTO;
import spring.springboot.WebBackend.Trip.infraestructure.controller.dto.output.TripOutputDTO;
import spring.springboot.WebBackend.Trip.infraestructure.repository.TripRepository;
import spring.springboot.WebBackend.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public class TripService implements TripInterface{
    @Autowired
    TripRepository tripRepository;


    @Override
    public List<TripOutputDTO> getAllTrips() {
        List<TripOutputDTO> tripOutputDTOList = new ArrayList<>();
        for(TripEntity tripEntity : tripRepository.findAll()){
            tripOutputDTOList.add(new TripOutputDTO(tripEntity));
        }
        return tripOutputDTOList;
    }

    @Override
    public TripOutputDTO getTripsByID(Integer id) {
        return new TripOutputDTO(tripRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Trip with id: " + id + " doesnt exists.")));
    }

    @Override
    public TripOutputDTO postTrip(TripInputDTO tripInputDTO) {
        TripEntity tripEntity = new TripEntity(tripInputDTO);
        tripRepository.save(tripEntity);
        return new TripOutputDTO(tripEntity);
    }

    @Override
    public TripOutputDTO updateTrip(Integer id, TripInputDTO tripInputDTO) {
        TripEntity tripEntity = tripRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Trip with id: " + id + " doesnt exists."));

        tripEntity.updateEntity(tripInputDTO);
        tripRepository.save(tripEntity);
        return new TripOutputDTO(tripEntity);
    }

    @Override
    public TripOutputDTO deleteTrip(Integer id) {
        TripOutputDTO tripOutputDTO = getTripsByID(id);
        tripRepository.deleteById(id);
        return tripOutputDTO;
    }
}

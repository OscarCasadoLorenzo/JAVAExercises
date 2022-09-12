package spring.springboot.EnterpriseApplication.application.Trip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.springboot.EnterpriseApplication.domain.TripEntity;
import spring.springboot.EnterpriseApplication.exceptions.NotFoundException;
import spring.springboot.EnterpriseApplication.insfraestructure.controller.dto.input.TripInputDTO;
import spring.springboot.EnterpriseApplication.insfraestructure.controller.dto.output.TripOutputDTO;
import spring.springboot.EnterpriseApplication.insfraestructure.repository.TripRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TripService implements TripInterface {
    @Autowired
    TripRepository tripRepository;

    @Autowired
    EntityManager entityManager;

    @Override
    public List<TripOutputDTO> getAllTrips() {
        List<TripOutputDTO> tripOutputDTOList = new ArrayList<>();
        for(TripEntity tripEntity : tripRepository.findAll()){
            tripOutputDTOList.add(new TripOutputDTO(tripEntity));
        }
        return tripOutputDTOList;
    }

    @Override
    public TripOutputDTO getTripByID(Integer id) {
        return new TripOutputDTO(tripRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Trip with id: " + id + " doesnt exists.")));
    }

    @Override
    public List<TripOutputDTO> getTripsByAvailability(
            String destination,
            Date inferiorDate,
            Optional<Date> superiorDate,
            Optional<Integer> inferiorExitHour,
            Optional<Integer> superiorExitHour)
    {
        List<TripOutputDTO> tripOutputDTOList = new ArrayList<>();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<TripEntity> query = cb.createQuery(TripEntity.class);
        Root<TripEntity> tripEntityRoot = query.from(TripEntity.class);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.equal(tripEntityRoot.get("destination"), destination));
        predicates.add(cb.greaterThan(tripEntityRoot.get("capacity"), 0));

        predicates.add(cb.greaterThan(tripEntityRoot.get("exitDate"), inferiorDate));
        if(superiorDate.isPresent())
            predicates.add(cb.lessThan(tripEntityRoot.get("exitDate"), inferiorDate));

        if(superiorExitHour.isPresent())
            predicates.add(cb.lessThan(tripEntityRoot.get("exitHour"), superiorExitHour.get()));
        if(inferiorExitHour.isPresent())
            predicates.add(cb.greaterThan(tripEntityRoot.get("exitHour"), inferiorExitHour.get()));

        query.select(tripEntityRoot).where(cb.and(predicates.toArray(new Predicate[predicates.size()]))).orderBy(cb.asc(tripEntityRoot.get("exitDate")));

        entityManager.createQuery(query).getResultList().forEach( tripEntity -> {
                    tripOutputDTOList.add(new TripOutputDTO(tripEntity));
        });
        return tripOutputDTOList;
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
        TripOutputDTO tripOutputDTO = getTripByID(id);
        tripRepository.deleteById(id);
        return tripOutputDTO;
    }
}

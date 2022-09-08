package spring.springboot.WebBackend.application.Ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.springboot.WebBackend.domain.PersonEntity;
import spring.springboot.WebBackend.infraestructure.controller.dto.output.TripOutputDTO;
import spring.springboot.WebBackend.infraestructure.repository.PersonRepository;
import spring.springboot.WebBackend.infraestructure.controller.dto.input.TicketInputDTO;
import spring.springboot.WebBackend.infraestructure.controller.dto.output.TicketOutputDTO;
import spring.springboot.WebBackend.infraestructure.repository.TicketRepository;
import spring.springboot.WebBackend.domain.TripEntity;
import spring.springboot.WebBackend.infraestructure.repository.TripRepository;
import spring.springboot.WebBackend.domain.TicketEntity;
import spring.springboot.WebBackend.exceptions.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService implements TicketInterface {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    TripRepository tripRepository;

    @Autowired
    EntityManager entityManager;

    @Override
    public List<TicketOutputDTO> getAllTickets() {
        List<TicketOutputDTO> ticketOutputDTOList = new ArrayList<>();
        for(TicketEntity ticketEntity : ticketRepository.findAll()){
            ticketOutputDTOList.add(new TicketOutputDTO(ticketEntity));
        }
        return ticketOutputDTOList;
    }

    @Override
    public TicketOutputDTO getTicketByID(Integer id) {
        return new TicketOutputDTO(ticketRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Ticket with id: " + id + " doesnt exists.")));
    }

    @Override
    public List<TicketOutputDTO> getTicketsByDestination(String destination, Date inferiorDate, Optional<Date> superiorDate, Optional<Integer> superiorExitHour, Optional<Integer> inferiorExitHour) {
        List<TicketOutputDTO> ticketOutputDTOList = new ArrayList<>();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<TicketEntity> cq = cb.createQuery(TicketEntity.class);

        Root<TicketEntity> ticketRoot = cq.from(TicketEntity.class);
        Root<TripEntity> tripRoot = cq.from(TripEntity.class);
        cq.multiselect(ticketRoot, tripRoot);
        cq.where(cb.equal(ticketRoot.get("tripID"), tripRoot.get("id")));

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.equal(tripRoot.get("destination"), destination));
        predicates.add(cb.greaterThan(tripRoot.get("exitDate"), inferiorDate));

        if(superiorDate.isPresent())
            predicates.add(cb.lessThan(tripRoot.get("exitDate"), inferiorDate));
        if(superiorExitHour.isPresent())
            predicates.add(cb.lessThan(tripRoot.get("exitHour"), superiorExitHour.get()));
        if(inferiorExitHour.isPresent())
            predicates.add(cb.greaterThan(tripRoot.get("exitHour"), inferiorExitHour.get()));

        cq.select(ticketRoot).where(cb.and(predicates.toArray(new Predicate[predicates.size()]))).orderBy(cb.asc(tripRoot.get("exitDate")));

        entityManager.createQuery(cq).getResultList().forEach( ticketEntity -> {
            ticketOutputDTOList.add(new TicketOutputDTO(ticketEntity));
        });

        return ticketOutputDTOList;
    }

    @Override
    public TicketOutputDTO postTicket(TicketInputDTO ticketInputDTO) {
        Integer personID = ticketInputDTO.getPersonID();
        Integer tripID = ticketInputDTO.getTripID();

        PersonEntity personEntity = personRepository.findById(personID)
                .orElseThrow(() -> new NotFoundException("Ticket with id: " + personID + " doesnt exits."));

        TripEntity tripEntity = tripRepository.findById(tripID)
                .orElseThrow(() -> new NotFoundException("Trip with id: " + tripID + " doesnt exists."));

        TicketEntity ticketEntity = new TicketEntity(tripEntity, personEntity);
        ticketRepository.save(ticketEntity);
        return new TicketOutputDTO(ticketEntity);
    }

    @Override
    public TicketOutputDTO updateTicket(Integer id, TicketInputDTO ticketInputDTO) {
        TicketEntity ticketEntity = ticketRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Ticket with id " + id + " doesnt exists."));

        TripEntity tripEntity = tripRepository.findById(ticketInputDTO.getTripID())
                .orElseThrow(() -> new NotFoundException("Trip with id " + ticketInputDTO.getTripID() + " doesnt exists."));

        PersonEntity personEntity = personRepository.findById(ticketInputDTO.getPersonID())
                .orElseThrow(() -> new NotFoundException("Person with id " + ticketInputDTO.getPersonID() + " doesnt exists."));

        ticketEntity.updateEntity(tripEntity, personEntity);
        ticketRepository.save(ticketEntity);

        return new TicketOutputDTO(ticketEntity);
    }

    @Override
    public TicketOutputDTO deleteTicket(Integer id) {
        TicketOutputDTO ticketOutputDTO = getTicketByID(id);
        ticketRepository.deleteById(id);
        return ticketOutputDTO;
    }
}

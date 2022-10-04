package spring.springboot.EnterpriseApplication.application.Ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.springboot.EnterpriseApplication.application.Email.EmailService;
import spring.springboot.EnterpriseApplication.domain.PendantBookEntity;
import spring.springboot.EnterpriseApplication.domain.PersonEntity;
import spring.springboot.EnterpriseApplication.domain.TicketEntity;
import spring.springboot.EnterpriseApplication.domain.TripEntity;
import spring.springboot.EnterpriseApplication.exceptions.FullCapacityException;
import spring.springboot.EnterpriseApplication.exceptions.NotFoundException;
import spring.springboot.EnterpriseApplication.insfraestructure.controller.dto.input.TicketInputDTO;
import spring.springboot.EnterpriseApplication.insfraestructure.controller.dto.output.TicketOutputDTO;
import spring.springboot.EnterpriseApplication.insfraestructure.repository.PendantBookRepository;
import spring.springboot.EnterpriseApplication.insfraestructure.repository.PersonRepository;
import spring.springboot.EnterpriseApplication.insfraestructure.repository.TicketRepository;
import spring.springboot.EnterpriseApplication.insfraestructure.repository.TripRepository;
import spring.springboot.EnterpriseApplication.kafka.KafkaProducer;

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
public class TicketService implements TicketInterface {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    TripRepository tripRepository;

    @Autowired
    PendantBookRepository pendantBookRepository;

    @Autowired
    EntityManager entityManager;

    @Autowired
    EmailService emailService;

    @Autowired
    KafkaProducer kafkaProducer;

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
        cq.where(cb.equal(ticketRoot.get("tripEntity"), tripRoot.get("id")));

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.equal(tripRoot.get("destination"), destination));
        predicates.add(cb.greaterThan(tripRoot.get("exitDate"), inferiorDate));

        if(superiorDate.isPresent())
            predicates.add(cb.lessThan(tripRoot.get("exitDate"), inferiorDate));
        if(superiorExitHour.isPresent())
            predicates.add(cb.greaterThan(tripRoot.get("exitHour"), superiorExitHour.get()));
        if(inferiorExitHour.isPresent())
            predicates.add(cb.lessThan(tripRoot.get("exitHour"), inferiorExitHour.get()));

        cq.select(ticketRoot).where(cb.and(predicates.toArray(new Predicate[predicates.size()]))).orderBy(cb.asc(tripRoot.get("exitDate")));

        entityManager.createQuery(cq).getResultList().forEach( ticketEntity -> {
            ticketOutputDTOList.add(new TicketOutputDTO(ticketEntity));
        });

        return ticketOutputDTOList;
    }

    @Override
    public TicketOutputDTO postTicket(PendantBookEntity reserveRequest) throws FullCapacityException{
        Integer personID = reserveRequest.getPersonID();
        Integer tripID = reserveRequest.getTripID();

        PersonEntity personEntity = personRepository.findById(personID)
                .orElseThrow(() -> new NotFoundException("Person with id: " + personID + " doesnt exits."));

        TripEntity tripEntity = tripRepository.findById(tripID)
                .orElseThrow(() -> new NotFoundException("Trip with id: " + tripID + " doesnt exists."));

        //Check if Tickets' trip has capacity for one more.
        if(tripEntity.getCapacity() <= 0){
            //Send error email to customer
            emailService.sendEmail(personEntity.getEmail(), "Ticket cancelled", "Your ticket receipt couldn't been booked because trip " + tripID + " has no availability. ");

            //Update PendantBook status associated to ticket
            reserveRequest.setRequeststate("cancelled");
            pendantBookRepository.save(reserveRequest);

            throw new FullCapacityException(tripID);
        }

        //Reduce trip capacity
        tripEntity.setCapacity(tripEntity.getCapacity() - 1);
        //Update trip entity
        tripRepository.save(tripEntity);

        //Update PendantBook status associated to ticket
        reserveRequest.setRequeststate("granted");
        pendantBookRepository.save(reserveRequest);

        //Create ticket
        TicketEntity ticketEntity = new TicketEntity(tripEntity, personEntity);
        ticketEntity.setId(reserveRequest.getId());
        ticketRepository.save(ticketEntity);

        TicketOutputDTO ticketOutputDTO = new TicketOutputDTO(ticketEntity);
        emailService.sendEmail(personEntity.getEmail(), "VirtualTravel Ticket receipt", "Here you have your ticket receipt. \n" + ticketOutputDTO);
        
        return ticketOutputDTO;
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

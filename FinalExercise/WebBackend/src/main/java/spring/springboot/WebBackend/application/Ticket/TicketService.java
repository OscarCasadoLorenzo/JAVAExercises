package spring.springboot.WebBackend.application.Ticket;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.KafkaException;
import org.springframework.stereotype.Service;
import spring.springboot.WebBackend.domain.PendantBookEntity;
import spring.springboot.WebBackend.domain.PersonEntity;
import spring.springboot.WebBackend.exceptions.FullCapacityException;
import spring.springboot.WebBackend.infraestructure.repository.PendantBookRepository;
import spring.springboot.WebBackend.infraestructure.repository.PersonRepository;
import spring.springboot.WebBackend.infraestructure.controller.dto.input.TicketInputDTO;
import spring.springboot.WebBackend.infraestructure.controller.dto.output.TicketOutputDTO;
import spring.springboot.WebBackend.infraestructure.repository.TicketRepository;
import spring.springboot.WebBackend.domain.TripEntity;
import spring.springboot.WebBackend.infraestructure.repository.TripRepository;
import spring.springboot.WebBackend.domain.TicketEntity;
import spring.springboot.WebBackend.exceptions.NotFoundException;
import spring.springboot.WebBackend.kafka.KafkaProducer;

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
    PendantBookRepository pendantBookRepository;

    @Autowired
    EntityManager entityManager;

    @Value("${eureka.instance.instance-id}")
    private String customerServiceID;

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
    public String postTicket(TicketInputDTO ticketInputDTO) {
        Integer personID = ticketInputDTO.getPersonID();
        Integer tripID = ticketInputDTO.getTripID();

        PersonEntity personEntity = personRepository.findById(personID)
                .orElseThrow(() -> new NotFoundException("Person with id: " + personID + " doesnt exits."));

        TripEntity tripEntity = tripRepository.findById(tripID)
                .orElseThrow(() -> new NotFoundException("Trip with id: " + tripID + " doesnt exists."));

        TicketEntity ticketEntity = new TicketEntity(tripEntity, personEntity);

        TicketOutputDTO ticketOutputDTO = new TicketOutputDTO(ticketEntity);


        //Save ticket request on auxiliar pendantBook table
        PendantBookEntity pendantBookEntity = new PendantBookEntity();
        pendantBookEntity.setId(ticketEntity.getId());
        pendantBookEntity.setService(customerServiceID);
        pendantBookEntity.setRequeststate("requested");

        pendantBookRepository.save(pendantBookEntity);

        //Request BackEnterprise to accept the ticket
        try{
            kafkaProducer.sendMessage(ticketOutputDTO);
        }catch (KafkaException k){
            throw new FullCapacityException(tripID);
        }

        return "Ticket was correctly send to our servers. Check your email to take it.";
    }
}

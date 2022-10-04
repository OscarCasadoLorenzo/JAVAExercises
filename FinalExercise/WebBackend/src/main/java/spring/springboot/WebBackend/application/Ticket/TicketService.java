package spring.springboot.WebBackend.application.Ticket;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.KafkaException;
import org.springframework.stereotype.Service;
import spring.springboot.WebBackend.domain.PendantBookEntity;
import spring.springboot.WebBackend.exceptions.FullCapacityException;
import spring.springboot.WebBackend.infraestructure.repository.PendantBookRepository;
import spring.springboot.WebBackend.infraestructure.repository.PersonRepository;
import spring.springboot.WebBackend.infraestructure.controller.dto.input.TicketInputDTO;
import spring.springboot.WebBackend.infraestructure.controller.dto.output.TicketOutputDTO;
import spring.springboot.WebBackend.infraestructure.repository.TicketRepository;
import spring.springboot.WebBackend.infraestructure.repository.TripRepository;
import spring.springboot.WebBackend.domain.TicketEntity;
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
    public String postTicket(TicketInputDTO ticketInputDTO) {
        Integer personID = ticketInputDTO.getPersonID();
        Integer tripID = ticketInputDTO.getTripID();

        //Save ticket request on auxiliar pendantBook table
        PendantBookEntity pendantBookEntity = new PendantBookEntity(tripID, personID, customerServiceID);

        pendantBookRepository.save(pendantBookEntity);

        //Request BackEnterprise to accept the ticket
        try{
            kafkaProducer.sendMessage(pendantBookEntity);
        }catch (KafkaException k){
            throw new FullCapacityException(tripID);
        }

        return "Ticket was correctly send to our servers. Check your email to take it.";
    }
}

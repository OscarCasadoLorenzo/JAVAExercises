package spring.springboot.WebBackend.application.Ticket;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.KafkaException;
import org.springframework.stereotype.Service;
import spring.springboot.WebBackend.domain.PendantBookEntity;
import spring.springboot.WebBackend.exceptions.FullCapacityException;
import spring.springboot.WebBackend.infraestructure.repository.PendantBookRepository;
import spring.springboot.WebBackend.infraestructure.controller.dto.input.TicketInputDTO;
import spring.springboot.WebBackend.kafka.KafkaProducer;

@Service
public class TicketService implements TicketInterface {
    @Autowired
    PendantBookRepository pendantBookRepository;

    @Value("${eureka.instance.instance-id}")
    private String customerServiceID;

    @Autowired
    KafkaProducer kafkaProducer;


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

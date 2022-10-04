package spring.springboot.EnterpriseApplication.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import spring.springboot.EnterpriseApplication.application.Ticket.TicketService;
import spring.springboot.EnterpriseApplication.domain.PendantBookEntity;
import spring.springboot.EnterpriseApplication.exceptions.FullCapacityException;
import spring.springboot.EnterpriseApplication.insfraestructure.controller.dto.input.TicketInputDTO;
import spring.springboot.EnterpriseApplication.insfraestructure.controller.dto.output.TicketOutputDTO;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    TicketService ticketService;

    @KafkaListener(topics = "checkTickets", groupId = "${eureka.instance.instance-id}")
    public void consume(PendantBookEntity reserveRequest){
        LOGGER.info(String.format("Message received from checkTickets topic -> %s", reserveRequest.toString()));

        TicketInputDTO ticketInputDTO = new TicketInputDTO(reserveRequest.ge, reserveRequest.getTrip().getId());
        try{
            ticketService.postTicket(ticketInputDTO);
            LOGGER.info(String.format("Book ok -> %s", reserveRequest));
        }catch (FullCapacityException f){
            LOGGER.error(String.format("Book failed -> %s", reserveRequest));
        }
    }
}

package spring.springboot.EnterpriseApplication.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import spring.springboot.EnterpriseApplication.insfraestructure.controller.dto.input.TicketInputDTO;
import spring.springboot.EnterpriseApplication.insfraestructure.controller.dto.output.TicketOutputDTO;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "checkTickets", groupId = "${eureka.instance.instance-id}")
    public void consume(TicketOutputDTO reserveRequest){
        LOGGER.info(String.format("Message received from checkTickets topic -> %s", reserveRequest.toString()));
    }
}

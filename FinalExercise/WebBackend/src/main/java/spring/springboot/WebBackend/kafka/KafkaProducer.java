package spring.springboot.WebBackend.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import spring.springboot.WebBackend.infraestructure.controller.dto.output.TicketOutputDTO;

@Service
public class KafkaProducer {
    private static  final Logger LOGGUER = LoggerFactory.getLogger(KafkaProducer.class);
    @Autowired
    KafkaTemplate<String, TicketOutputDTO> kafkaTemplate;

    public void sendMessage(TicketOutputDTO reservationRequest) throws KafkaException {
        LOGGUER.info(String.format("Message sent to checkTickets topic -> %s", reservationRequest.toString()));

        Message<TicketOutputDTO> messageRequest = MessageBuilder
                .withPayload(reservationRequest)
                .setHeader(KafkaHeaders.TOPIC, "checkTickets")
                .build();

        kafkaTemplate.send(messageRequest);


    }
}
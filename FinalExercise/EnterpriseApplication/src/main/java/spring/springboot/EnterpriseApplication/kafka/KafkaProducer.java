package spring.springboot.EnterpriseApplication.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private static  final Logger LOGGUER = LoggerFactory.getLogger(KafkaProducer.class);
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message){
        LOGGUER.info(String.format("Message sent %s", message));
        kafkaTemplate.send("confirmTickets", message);
    }
}
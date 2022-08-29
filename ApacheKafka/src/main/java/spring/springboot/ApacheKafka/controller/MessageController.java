package spring.springboot.ApacheKafka.controller;

import org.apache.coyote.Response;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.springboot.ApacheKafka.kafka.KafkaProducer;

@RestController
@RequestMapping("api/v1/kafka")
public class MessageController {

    @Autowired
    KafkaProducer kafkaProducer;

    @GetMapping("")
    public ResponseEntity<String> publish(String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message was sent to the topic");
    }
}

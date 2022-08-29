package spring.springboot.ApacheKafka.controller;

import org.apache.coyote.Response;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.springboot.ApacheKafka.kafka.KafkaProducer;

@RestController
@RequestMapping("kafka/guidelines")
public class MessageController {

    @Autowired
    KafkaProducer kafkaProducer;

    @PostMapping
    public ResponseEntity<String> publish(@RequestParam String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message was sent to the topic");
    }
}

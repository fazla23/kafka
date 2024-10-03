package com.xenon.kafka.rest;

import com.xenon.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/messages")
public class MessageController {
    private final KafkaProducer kafkaProducer;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message){
        kafkaProducer.publishMessage(message);
        return ResponseEntity.ok("Message queued successfully");
    }
}

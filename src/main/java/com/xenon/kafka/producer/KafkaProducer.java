package com.xenon.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {
    private final KafkaTemplate<String,String> kafkaTemplate;
    public void publishMessage(String msg){
        log.info(String.format("Sending message to xenon topic ::%s",msg));
        kafkaTemplate.send("xenon",msg);
    }
}

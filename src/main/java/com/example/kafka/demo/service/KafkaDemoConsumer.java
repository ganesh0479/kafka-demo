package com.example.kafka.demo.service;

import com.example.kafka.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.example.kafka.demo.constant.KafkaDemoConstant.DEMO_TOPIC;

@Service
@Slf4j
public class KafkaDemoConsumer {

    @KafkaListener(topics = DEMO_TOPIC)
    public void consumeMessage(User user) {
        log.info("Consumed Message: " + user);
    }
}

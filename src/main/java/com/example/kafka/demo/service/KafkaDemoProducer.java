package com.example.kafka.demo.service;

import com.example.kafka.demo.model.Status;
import com.example.kafka.demo.model.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.example.kafka.demo.constant.KafkaDemoConstant.DEMO_TOPIC;

@Service
public class KafkaDemoProducer {
    private KafkaTemplate<String, User> kafkaTemplate;

    public KafkaDemoProducer(final KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public Status produceMessage(User user) {
        kafkaTemplate.send(DEMO_TOPIC, user);
        return Status.builder().status(Boolean.TRUE).message("Successfully Sent").build();
    }
}

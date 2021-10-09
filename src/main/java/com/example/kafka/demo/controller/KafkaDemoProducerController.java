package com.example.kafka.demo.controller;

import com.example.kafka.demo.model.Status;
import com.example.kafka.demo.model.User;
import com.example.kafka.demo.service.KafkaDemoProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/producers")
public class KafkaDemoProducerController {
    private KafkaDemoProducer kafkaDemoProducer;

    public KafkaDemoProducerController(KafkaDemoProducer kafkaDemoProducer) {
        this.kafkaDemoProducer = kafkaDemoProducer;
    }

    @PostMapping
    public ResponseEntity<Status> produceMessage(@RequestBody User user) {
        return ResponseEntity.ok(kafkaDemoProducer.produceMessage(user));
    }
}

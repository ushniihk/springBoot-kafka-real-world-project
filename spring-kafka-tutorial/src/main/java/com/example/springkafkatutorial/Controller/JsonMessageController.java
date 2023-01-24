package com.example.springkafkatutorial.Controller;

import com.example.springkafkatutorial.kafka.JsonKafkaProducer;
import com.example.springkafkatutorial.payload.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
@AllArgsConstructor
public class JsonMessageController {
    private final JsonKafkaProducer jsonKafkaProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("json message sent to kafka topic");
    }
}

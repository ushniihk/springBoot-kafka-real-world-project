package com.example.springkafkatutorial.kafka;

import com.example.springkafkatutorial.payload.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class JsonKafkaProducer {

    @Value("${spring.kafka.topic.namejson}")
    public static String javaguidesJson;
    private final KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User data) {
        log.info(String.format("Message sent -> %s", data.toString()));
        Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, javaguidesJson)
                .build();
        kafkaTemplate.send(message);
    }
}
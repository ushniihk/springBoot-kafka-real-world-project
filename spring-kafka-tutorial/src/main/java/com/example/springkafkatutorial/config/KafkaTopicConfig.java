package com.example.springkafkatutorial.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.topic.name}")
    private String javaguides;
    @Value("${spring.kafka.topic.namejson}")
    private String javaguidesJson;


    @Bean
    public NewTopic javaguidesTopic() {
        return TopicBuilder.name(javaguides)
                .build();
    }

    @Bean
    public NewTopic javaguidesJasonTopic() {
        return TopicBuilder.name(javaguidesJson)
                .build();
    }
}

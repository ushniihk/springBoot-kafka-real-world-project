package com.example.springboot;

import com.example.springboot.entity.WikimediaData;
import com.example.springboot.repository.WikimediaDataRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class KafkaDatabaseConsumer {
    private final WikimediaDataRepository dataRepository;

    @KafkaListener(topics = "wikimedia_recentchange", groupId = "myGroup")
    public void consume(String eventMessage) {
        WikimediaData data = new WikimediaData();
        data.setWikiEventData(eventMessage);
        dataRepository.save(data);
        log.info(String.format("Event message received -> %s", eventMessage));
    }
}
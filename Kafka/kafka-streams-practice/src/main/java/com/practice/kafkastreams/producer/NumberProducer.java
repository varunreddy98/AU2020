package com.practice.kafkastreams.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;


@Component
@EnableScheduling
public class NumberProducer {

    @Value("${kafka.topic.input}")
    private String topicName;

    Random random=new Random();

    @Autowired
    private KafkaTemplate<String, Long> kafkaTemplate;

    private Long number = 0L;

    @Scheduled(fixedRate = 2000)
    public void produce() {
        number=random.nextLong();
        System.out.println("Produced :: " + number);
        this.kafkaTemplate.send(topicName, number);
    }
}

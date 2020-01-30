package com.practice.kafkastreams.processor;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OddNumberProcessor {

    @Value("${kafka.topic.even-output}")
    private String outputEvenTopicName;

    public void process(KStream<String, Long> stream){
        stream.filter((k, v) -> v % 2 != 0)
                .mapValues(v -> {
                    System.out.println("no of digits in Odd number:: " + v);
                    long c=0L;
                    while(v!=0)
                    {
                        c++;
                        v=v/10;
                    }

                    return (c);
                })
                .to(outputEvenTopicName);
    }
}

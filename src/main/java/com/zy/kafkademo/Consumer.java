package com.zy.kafkademo;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Zhangying
 * @date 2019/8/1
 */
@Component
@Slf4j
public class Consumer {

    private static final String TOPIC = "test";
    /**
     * receive data from kafka topic
     * @param record
     */
    @KafkaListener(topics = {TOPIC})
    public void listen(ConsumerRecord<?, ?> record) {

        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            log.info("----------------- record =" + record);
            log.info("----------------- message =" + message);
        }
    }

}

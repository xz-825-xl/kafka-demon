package com.zy.kafkademo;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Zhangying
 * @date 2019/8/1
 */
@Component
@Slf4j
@EnableKafka
public class Consumer {

    private static final String TOPIC = "test";
    private int count = 0;

    /**
     * receive data from kafka topic
     *
     * @param record
     */
    @KafkaListener(topics = {TOPIC}, containerFactory = "batchFactory")
    public void listen(ConsumerRecord<?, ?> record, Acknowledgment ack) {

        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            //log.info("----------------- key =" + record.key());
            log.info("----------------- value1 =" + message);
        }

//        if (count % 5 == 0) {
            ack.acknowledge();
//        }
//        count++;
    }

    @KafkaListener(topics = {TOPIC}, containerFactory = "batchFactory")
    public void listen2(ConsumerRecord<?, ?> record, Acknowledgment ack) {

        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            //log.info("----------------- key =" + record.key());
            log.info("----------------- value2 =" + message);
        }

//        if (count % 5 == 0) {
//            ack.acknowledge();
//        }
//        count++;
    }

}

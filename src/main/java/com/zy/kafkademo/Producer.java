package com.zy.kafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;

/**
 * @author Zhangying
 * @date 2019/8/1
 */
@Component
@EnableScheduling
public class Producer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    private int count = 0;
    /**
     * 定时任务
     */
    @Scheduled(cron = "0/10 * * * * ?")
    public void send() {
        String message = count + "";
        ListenableFuture future = kafkaTemplate.send("test", "kafka", message);
        count++;
    }
}

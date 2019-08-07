package com.zy.kafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zhangying
 * @date 2019/8/2
 */
@RestController
@RequestMapping("/kafka")
public class KafkaTestController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @GetMapping("/send")
    public void send(String key, String value) {
        kafkaTemplate.send("nuonuo-dz-customer", key, value);
    }
}

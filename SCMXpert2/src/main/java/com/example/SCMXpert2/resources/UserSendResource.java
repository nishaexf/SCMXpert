package com.example.SCMXpert2.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SCMXpert2.models.Users;

@RestController
@RequestMapping("kafka")
public class UserSendResource {

    @Autowired
    private KafkaTemplate<String, Users> kafkaTemplate;

    private static final String TOPIC = "Kafka_Example";

//    @GetMapping("/publish/{users}")
//    public String post(@PathVariable("users") final String name) {
//
//        //kafkaTemplate.send(TOPIC,"mm");
////
//        return "Published successfully";
//    }
}
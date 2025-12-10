package com.example.demo.consumer;

import com.example.demo.model.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    @KafkaListener(topics = "orders", groupId = "orders-group", containerFactory = "kafkaListenerContainerFactory")
    public void listen(OrderEvent event) {
        System.out.println("Received order event: " + event);
        // add processing logic here (save to DB, call other services, etc.)
    }
}
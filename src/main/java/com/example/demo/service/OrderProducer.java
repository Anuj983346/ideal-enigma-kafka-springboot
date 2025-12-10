package com.example.demo.service;

import com.example.demo.model.OrderEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {
    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;
    private final String topic = "orders";

    public OrderProducer(KafkaTemplate<String, OrderEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrder(OrderEvent event) {
        kafkaTemplate.send(topic, event.getOrderId(), event);
    }
}
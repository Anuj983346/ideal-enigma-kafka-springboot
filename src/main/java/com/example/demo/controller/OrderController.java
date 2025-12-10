package com.example.demo.controller;

import com.example.demo.model.OrderEvent;
import com.example.demo.service.OrderProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderProducer producer;

    public OrderController(OrderProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderEvent order) {
        order.setOrderId(UUID.randomUUID().toString());
        order.setTimestamp(Instant.now().toEpochMilli());
        order.setStatus("CREATED");
        producer.sendOrder(order);
        return ResponseEntity.ok(order.getOrderId());
    }
}
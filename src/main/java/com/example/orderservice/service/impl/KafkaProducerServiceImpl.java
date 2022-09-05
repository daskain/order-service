package com.example.orderservice.service.impl;

import com.example.orderservice.dto.Order;
import com.example.orderservice.dto.OrderRequestDto;
import com.example.orderservice.service.KafkaProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class KafkaProducerServiceImpl implements KafkaProducerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerServiceImpl.class);

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${kafka.topic.requestOrder}")
    private String topic;

    @Override
    public void send() {
        logger.info("message sent to topic {}: {}", topic, getMessage());
        kafkaTemplate.send(topic, getMessage());
    }

    private OrderRequestDto getMessage() {
        List<Order> orderList = new ArrayList<>();
        Map<UUID, Integer> orders = new HashMap<>();
        orders.put(generateID(), 2);
        orders.put(generateID(), 3);
        Order order = new Order(generateID(), orders);
        orderList.add(order);
        OrderRequestDto requestDto = OrderRequestDto.builder()
                .orderId(generateID())
                .orderList(orderList)
                .build();

        return requestDto;
    }

    private UUID generateID() {

        UUID id = UUID.randomUUID();
        return id;
    }
}
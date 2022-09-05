package com.example.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Sheduler {

    private KafkaProducerService producerService;

    @Autowired
    public Sheduler(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    private static int timer;

    @Scheduled(fixedRate = 50000)
    public void reportCurrentTime() {

        producerService.send();

    }
}
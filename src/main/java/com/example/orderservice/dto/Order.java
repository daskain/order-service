package com.example.orderservice.dto;

import lombok.Data;

import java.util.Map;
import java.util.UUID;

@Data
public class Order {

    private UUID orderId;
    private Map<UUID, Integer> listOfProductAndCount;
}

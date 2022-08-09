package com.example.orderservice.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class OrderResponse {

    private UUID responseId;
    private List<Order> orderList;


}

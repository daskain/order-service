package com.example.orderservice.dto;

import lombok.*;

import java.util.Map;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private UUID orderId;
    private Map<UUID, Integer> listOfProductAndCount;
}

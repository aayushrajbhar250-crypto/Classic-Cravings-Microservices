package com.classic.cravings.order.dto;

public record OrderDto(
        String orderId,
        int amount,
        String status
) {

}

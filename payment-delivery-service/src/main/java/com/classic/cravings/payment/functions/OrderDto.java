package com.classic.cravings.payment.functions;

public record OrderDto(
        String orderId,
        int amount,
        String status
) {

}

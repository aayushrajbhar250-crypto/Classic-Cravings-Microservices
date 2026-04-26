package com.classic.cravings.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderCreateRequestDto {

    String orderId;
    String amount;
    String productId;
    String status;
    String userId;

    public OrderCreateRequestDto(String orderId) {
        this.orderId = orderId;
    }

    public OrderCreateRequestDto(String orderId, String amount, String productId, String status, String userId) {
        this.orderId = orderId;
        this.amount = amount;
        this.productId = productId;
        this.status = status;
        this.userId = userId;
    }

}

package com.classic.cravings.order.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class Order {
    String orderId;
    String amount;
    String userId;
    LocalDate orderDate;
    String status;
    String productId;

    public Order() {
    }

    public Order(String orderId, String amount, String userId, LocalDate orderDate, String status) {
        this.orderId = orderId;
        this.amount = amount;
        this.userId = userId;
        this.orderDate = orderDate;
        this.status = status;
    }
}

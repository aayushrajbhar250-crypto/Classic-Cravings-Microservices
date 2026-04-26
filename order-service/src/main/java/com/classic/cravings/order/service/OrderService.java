package com.classic.cravings.order.service;

import com.classic.cravings.order.dto.OrderCreateRequestDto;
import com.classic.cravings.order.dto.OrderDto;
import com.classic.cravings.order.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private StreamBridge streamBridge;

    //order repository
    public Order createOrder(OrderCreateRequestDto Dto) {
        //

        Order order = new Order();
        order.setOrderId( UUID.randomUUID().toString() );
        order.setAmount (  Dto.getAmount() );
        order.setStatus (  "CREATED" );
        order.setUserId (  Dto.getUserId() );
        order.setProductId (  Dto.getProductId() );
        order.setOrderDate ( LocalDate.now () );
        System.out.println ("Order created"+order.getOrderId ());


        //publish the event
        OrderDto orderDto = new OrderDto ( order.getOrderId (),Integer.parseInt ( order.getAmount () ),order.getStatus () );
        Message<OrderDto> message = MessageBuilder.withPayload(orderDto).build ();
        streamBridge.send (  "orderCreated-out-0", message );
        System.out.println ("Order event is published");
        return order;
    }
}

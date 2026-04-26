package com.classic.cravings.payment.functions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Configuration
public class OrderNotification {

    @Bean
    public Consumer<Message<OrderDto>> orderEvents(){
        return message -> {

            OrderDto orderDto = message.getPayload();

            System.out.println ("Order event is received");
            System.out.println ("Delivery Processed start");
            System.out.println ("order id"+orderDto.orderId ());
            System.out.println ("order status"+orderDto.status ());
            System.out.println ("order amount"+orderDto.amount ());
            System.out.println ("-----fine-----");
        };
    }
}

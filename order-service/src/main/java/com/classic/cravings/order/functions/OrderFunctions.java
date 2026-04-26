package com.classic.cravings.order.functions;

import com.classic.cravings.order.dto.OrderDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

@Configuration
public class OrderFunctions {

    @Bean
    public Supplier<String> test(){
        return ()-> "This is testing , hello World!";
    }

    @Bean
    public Supplier<Map<String, String>> hello(){
        return ()-> Map.of ("message", "Hello World!");
    }

    @Bean
    public Function<OrderDto, String> createOrder(){
        return orderDto -> {
            System.out.println ("Creating order");
            System.out.println (orderDto.orderId ());
            System.out.println (orderDto.amount ());
            System.out.println (orderDto.status ());
            return "order created with orderId"+orderDto.orderId ();
        };
    }

}

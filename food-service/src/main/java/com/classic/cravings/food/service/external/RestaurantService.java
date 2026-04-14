package com.classic.cravings.food.service.external;

import com.classic.cravings.food.dto.RestaurantDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "restaurant-service",url = "http://localhost:9091")
public interface RestaurantService {

    @GetMapping("/api/v1/restaurant/{id}")
    RestaurantDto getById (@PathVariable("id") String restaurantId);
}

package com.classic.cravings.food.service.external;

import com.classic.cravings.food.config.AppConstants;
import com.classic.cravings.food.dto.RestaurantDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = AppConstants.RESTAURANT_SERVICE_NAME)
public interface RestaurantService {

    //get restaurants with given id
    @GetMapping("/api/v1/restaurant/{id}")
    RestaurantDto getById (@PathVariable("id") String restaurantId);

    // get all
    @GetMapping("/api/v1/restaurant")
    List<RestaurantDto> getAllRestaurants();

    // create post Api
    @PostMapping("/api/v1/restaurant")
    RestaurantDto create(@RequestBody RestaurantDto dto);

    // delete
    @DeleteMapping
    void delete(@PathVariable("id") String restaurantId);
}

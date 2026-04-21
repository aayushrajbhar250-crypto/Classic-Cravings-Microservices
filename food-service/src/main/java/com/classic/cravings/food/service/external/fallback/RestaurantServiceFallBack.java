package com.classic.cravings.food.service.external.fallback;

import com.classic.cravings.food.dto.RestaurantDto;
import com.classic.cravings.food.service.external.RestaurantService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RestaurantServiceFallBack implements RestaurantService {
    @Override
    public RestaurantDto getById(String restaurantId) {
        return null;
    }

    @Override
    public List<RestaurantDto> getAllRestaurants() {
        return List.of ();
    }

    @Override
    public RestaurantDto create(RestaurantDto dto) {
        return null;
    }

    @Override
    public void delete(String restaurantId) {

    }
}

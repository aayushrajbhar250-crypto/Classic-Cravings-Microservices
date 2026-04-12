package com.classic.cravings.restaurant.repository;

import com.classic.cravings.restaurant.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, String> {
    Optional<Restaurant> findByName(String name);
}

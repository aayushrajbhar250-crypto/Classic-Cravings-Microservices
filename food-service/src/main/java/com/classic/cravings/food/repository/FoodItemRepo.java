package com.classic.cravings.food.repository;

import com.classic.cravings.food.entities.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodItemRepo extends JpaRepository<FoodItem,String> {
}

package com.classic.cravings.food.repository;

import com.classic.cravings.food.entities.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodCategoryRepo extends JpaRepository<FoodCategory,String> {
}

package com.classic.cravings.food.controller;

import com.classic.cravings.food.dto.FoodCategoryDTO;
import com.classic.cravings.food.entities.FoodCategory;
import com.classic.cravings.food.service.FoodCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/food-categories")
public class FoodCategoryController {

    @Autowired
    private FoodCategoryService foodCategoryService;

    @GetMapping
    public List<FoodCategoryDTO> getAllFoodCategories() {
        return foodCategoryService.getAllFoodCategories();
    }

    @GetMapping("/{id}")
    public FoodCategoryDTO getFoodCategory(@PathVariable String id) {
        return foodCategoryService.getFoodCategoryById ( id );
    }

    @PostMapping
    public FoodCategoryDTO CreateFoodCategory(@RequestBody FoodCategoryDTO dto) {
        return foodCategoryService.createFoodCategory(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteFoodCategory(@ PathVariable String id) {
        foodCategoryService.deleteFoodCategory ( id );
    }
}

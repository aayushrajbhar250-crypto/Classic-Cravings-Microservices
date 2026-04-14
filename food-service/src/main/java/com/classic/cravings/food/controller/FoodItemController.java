package com.classic.cravings.food.controller;

import com.classic.cravings.food.dto.FoodItemDTO;
import com.classic.cravings.food.entities.FoodItem;
import com.classic.cravings.food.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/food-items")
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    @GetMapping
    public List<FoodItemDTO> findAllFoodItems() {
        return foodItemService.getAllFoodItems();
    }

    @GetMapping("/{id}")
    public FoodItemDTO getFoodItemById(@PathVariable String id) {
        return foodItemService.getFoodItemById (id);
    }

    @PostMapping
    public FoodItemDTO createFoodItem(@RequestBody FoodItemDTO dto) {
        return foodItemService.createFoodItem(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteFoodItemById(@PathVariable String id) {
        foodItemService.deleteFoodItem ( id );
    }















}

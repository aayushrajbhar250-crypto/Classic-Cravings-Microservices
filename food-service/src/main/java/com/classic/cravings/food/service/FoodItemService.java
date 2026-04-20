package com.classic.cravings.food.service;

import com.classic.cravings.food.dto.FoodCategoryDTO;
import com.classic.cravings.food.dto.FoodItemDTO;
import com.classic.cravings.food.dto.RestaurantDto;
import com.classic.cravings.food.entities.FoodCategory;
import com.classic.cravings.food.entities.FoodItem;
import com.classic.cravings.food.repository.FoodCategoryRepo;
import com.classic.cravings.food.repository.FoodItemRepo;
import com.classic.cravings.food.service.external.RestWebClientService;
import com.classic.cravings.food.service.external.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FoodItemService {

    @Autowired
    private FoodItemRepo foodItemRepo;

    @Autowired
    private FoodCategoryRepo foodCategoryRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RestaurantService  restaurantService;

    @Autowired
    private RestWebClientService restWebClientService;



    public List<FoodItemDTO> getAllFoodItems() {
        return foodItemRepo.findAll ().stream ()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    public FoodItemDTO getFoodItemById(String id) {
        FoodItem foodItem = foodItemRepo.findById ( id).orElseThrow ( () -> new RuntimeException ( "Couldnot find food with id" + id ) );

//        String restaurantServiceUrl = "http://localhost:9091/api/v1/restaurant/" + foodItem.getRestaurantId();

//        RestaurantDto restaurantDto = restTemplate.getForObject ( restaurantServiceUrl, RestaurantDto.class );

        //calling restaurant service to get restaurant by id
//        RestaurantDto restaurantDto = restaurantService.getById ( foodItem.getRestaurantId () );

        RestaurantDto restaurantDto = restWebClientService.getById ( foodItem.getRestaurantId () );
        FoodItemDTO foodItemDTO = convertToDTO ( foodItem );
         foodItemDTO.setRestaurant (  restaurantDto );
         return foodItemDTO;
    }


    public FoodItemDTO createFoodItem(FoodItemDTO dto) {

        FoodCategory category = foodCategoryRepo.findById(dto.getFoodCategoryId ())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        FoodItem foodItem = convertToEntity(dto);
        foodItem.setId(UUID.randomUUID().toString());
        foodItem.setFoodCategory(category);
        FoodItem saved = foodItemRepo.save(foodItem);

        return convertToDTO(saved);
    }


    public void deleteFoodItem(String id) {
        foodItemRepo.deleteById(id);
    }


    private FoodItem convertToEntity(FoodItemDTO dto) {
        FoodItem item = new FoodItem();

        item.setId(dto.getId());
        item.setTitle(dto.getTitle());
        item.setDescription(dto.getDescription());
        item.setQuantity(dto.getQuantity());
        item.setOutOfStock(dto.isOutOfStock());
        item.setFoodType(dto.getFoodType());
        item.setRestaurantId(dto.getRestaurantId());

        return item;
    }


    private FoodItemDTO convertToDTO(FoodItem item) {
        FoodItemDTO dto = new FoodItemDTO();

        dto.setId(item.getId());
        dto.setTitle(item.getTitle());
        dto.setDescription(item.getDescription());
        dto.setQuantity(item.getQuantity());
        dto.setOutOfStock(item.isOutOfStock());
        dto.setFoodType(item.getFoodType());
        dto.setRestaurantId(item.getRestaurantId());

        if (item.getFoodCategory() != null) {
            dto.setFoodCategoryId(item.getFoodCategory().getId());

            FoodCategoryDTO categoryDTO = new FoodCategoryDTO();
            categoryDTO.setId(item.getFoodCategory().getId());
            categoryDTO.setName(item.getFoodCategory().getCategory());
            categoryDTO.setDescription(item.getFoodCategory().getDescription());
            dto.setFoodCategory(categoryDTO);
        }
        return dto;
    }

}

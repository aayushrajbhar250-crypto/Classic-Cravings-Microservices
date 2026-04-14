package com.classic.cravings.food.service;

import com.classic.cravings.food.dto.FoodCategoryDTO;
import com.classic.cravings.food.entities.FoodCategory;
import com.classic.cravings.food.repository.FoodCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FoodCategoryService {

    @Autowired
    private FoodCategoryRepo foodCategoryRepo;

    public List<FoodCategoryDTO> getAllFoodCategories() {
        return foodCategoryRepo.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public FoodCategoryDTO getFoodCategoryById(String id) {
        return foodCategoryRepo.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public FoodCategoryDTO createFoodCategory(FoodCategoryDTO foodCategoryDTO) {

        FoodCategory foodCategory = convertToEntity(foodCategoryDTO);
        foodCategory.setId(UUID.randomUUID().toString());

        FoodCategory saved = foodCategoryRepo.save(foodCategory);

        return convertToDTO(saved);
    }

    public void deleteFoodCategory(String id) {
        foodCategoryRepo.deleteById(id);
    }

    private FoodCategory convertToEntity(FoodCategoryDTO dto) {
        FoodCategory category = new FoodCategory();

        category.setId(dto.getId());
        category.setCategory(dto.getName());
        category.setDescription(dto.getDescription());

        return category;
    }

    private FoodCategoryDTO convertToDTO(FoodCategory foodCategory) {
        FoodCategoryDTO dto = new FoodCategoryDTO();

        dto.setId(foodCategory.getId());
        dto.setName(foodCategory.getCategory());
        dto.setDescription(foodCategory.getDescription());

        return dto;
    }
































//
//    public List<FoodCategoryDTO> getAllFoodCategories() {
//        return foodCategoryRepo.findAll ().stream ()
//                .map ( this::convertToDTO )
//                .collect ( Collectors.toList () );
//    }
//
//    public FoodCategoryDTO getFoodCategoryById(String id) {
//        return foodCategoryRepo.findById (id)
//                .map ( this::convertToDTO )
//                .orElse ( null );
//    }
//
//    public FoodCategoryDTO createFoodCategory(FoodCategoryDTO foodCategoryDTO) {
//        FoodCategory foodCategory = convertToEntity(dto);
//        foodCategory.setId( UUID.randomUUID().toString());
//
//        FoodCategory saved = foodCategoryRepo.save(foodCategory);
//
//        return convertToDTO(saved);
//    }
//
//    public void deleteFoodCategory(String id) {
//        foodCategoryRepo.deleteById (id);
//    }
//
//    private FoodCategoryDTO convertToDTO(FoodCategory foodCategory) {
//        FoodCategoryDTO dto = new FoodCategoryDTO();
//        dto.setId (foodCategory.getId ());
//        dto.setName ( foodCategory.getCategory () );
//        dto.setDescription (foodCategory.getDescription ());
//        return dto;
//
//    }

}

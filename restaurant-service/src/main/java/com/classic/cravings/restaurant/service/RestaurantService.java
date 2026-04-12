package com.classic.cravings.restaurant.service;

import com.classic.cravings.restaurant.dto.RestaurantDto;
import com.classic.cravings.restaurant.entities.Restaurant;
import com.classic.cravings.restaurant.repository.RestaurantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RestaurantService {

    private RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }
    // save a new User
    public RestaurantDto save(RestaurantDto dto) {
        Restaurant restaurant = new Restaurant();
        BeanUtils.copyProperties(dto, restaurant);
        // we generate id
        restaurant.setId ( UUID.randomUUID().toString() );
        restaurant=restaurantRepository.save(restaurant);
        BeanUtils.copyProperties( dto, dto);
        return dto;
    }

    //update an existing restaurant
    public RestaurantDto update(String id, RestaurantDto dto) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if(optionalRestaurant.isPresent()) {
            Restaurant restaurant = optionalRestaurant.get();
            BeanUtils.copyProperties(dto, restaurant);
            restaurant=restaurantRepository.save(restaurant);
            BeanUtils.copyProperties( dto, restaurant);
            return dto;
        }
        throw new RuntimeException ("Restaurant not found with Id :"+id);
    }

    // get restaurant By id
    public RestaurantDto getById(String id) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if(optionalRestaurant.isPresent()) {
            RestaurantDto dto = new RestaurantDto();
            BeanUtils.copyProperties(optionalRestaurant.get(), dto);
            return dto;
        }
        throw new RuntimeException ("Restaurant not found with Id :"+id);
    }
    // find restaurant by name
    @Transactional
    public RestaurantDto findByName(String name) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findByName (name);
        if(optionalRestaurant.isPresent()) {
            RestaurantDto dto = new RestaurantDto();
            BeanUtils.copyProperties(optionalRestaurant.get(), dto);
            return dto;
        }
        throw new RuntimeException ("Restaurant not found with Name :"+name);
    }


    // delete restaurant By id
    public void delete(String id) {
        restaurantRepository.deleteById(id);
    }

    //get all restaurant
    public List<RestaurantDto> getAll() {
        List<Restaurant>  restaurants = restaurantRepository.findAll();
        List<RestaurantDto> dtos = new ArrayList<> ();
        for (Restaurant restaurant : restaurants) {
            RestaurantDto dto = new RestaurantDto();
            BeanUtils.copyProperties(restaurant, dto);
            dtos.add(dto);
        }
        return dtos;
    }
}

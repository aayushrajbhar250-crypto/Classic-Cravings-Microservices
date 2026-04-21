package com.classic.cravings.restaurant.controller;

import com.classic.cravings.restaurant.dto.RestaurantDto;
import com.classic.cravings.restaurant.service.RestaurantService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/restaurant")
public class RestaurantController {

    private RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    // create a new Restaurant
    @PostMapping
    public ResponseEntity<RestaurantDto> save(@RequestBody RestaurantDto dto) {
        RestaurantDto savedRestaurant = restaurantService.save(dto);
        return new ResponseEntity<> ( savedRestaurant, HttpStatus.CREATED );
    }

    // update an existing restaurant
    @PutMapping("/{id}")
    public ResponseEntity<RestaurantDto> update(@PathVariable String id, @RequestParam RestaurantDto dto) {
        RestaurantDto updateRestaurant = restaurantService.update ( id, dto );
        return new ResponseEntity<> (updateRestaurant, HttpStatus.OK );
    }

    // get restaurant by id
    int count =0;
    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDto> getById(@PathVariable String id) {
        RestaurantDto restaurantDto = restaurantService.getById( id );
        count++;
        if (count <= 3){
            System.out.println ("retrying" +count);
            throw new RuntimeException ("service down");
        }
        return new ResponseEntity<>( restaurantDto, HttpStatus.OK );
    }

    //find restaurant By Name
    @GetMapping("/name/{name}")
    public ResponseEntity<RestaurantDto> findByName(@PathVariable String name) {
        RestaurantDto restaurantDto = restaurantService.findByName (name);
        return new ResponseEntity<>( restaurantDto, HttpStatus.OK );
    }

    //Delete by Id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        restaurantService.delete ( id );
        return new ResponseEntity<>(HttpStatus.NO_CONTENT );
    }

    //get all restaurant
    @RateLimiter ( name = "get-all-restaurant-rate-limiter" ,fallbackMethod = "getAllFallBack")
    @GetMapping
    public ResponseEntity<List<RestaurantDto>> getAll() {
        List<RestaurantDto> restaurants = restaurantService.getAll();
        return new ResponseEntity<>( restaurants, HttpStatus.OK );
    }
    public ResponseEntity<List<RestaurantDto>> getAllFallBack(Throwable throwable) {
        System.out.println (throwable.getMessage ());
        return ResponseEntity.ok().body( null );
    }
}

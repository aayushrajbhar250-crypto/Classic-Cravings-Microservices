package com.classic.cravings.food.service.external;

import com.classic.cravings.food.dto.RestaurantDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class RestWebClientService {

    @Autowired
    private WebClient.Builder webClient;

    public RestaurantDto getById(String resId){

        RestaurantDto restaurantDto = webClient.baseUrl("http://restaurant-service")
                .build()
                .get ()
                .uri ("/api/v1/restaurant/{id}",resId)
                .retrieve ()
                .bodyToMono (RestaurantDto.class)
                .block ();

        return restaurantDto;
    }

    // get all restaurant
    public List<RestaurantDto> getAllRestaurants(){
        return webClient.baseUrl("http://restaurant-service")
                .build()
                .get ()
                .uri ("/api/v1/restaurant")
                .retrieve ()
                .bodyToFlux (RestaurantDto.class)
                .collectList ()
                .block ();
    }

    //post request

    public RestaurantDto createRestaurant(RestaurantDto newRestaurantDto){
        return webClient.baseUrl("http://restaurant-service")
                .build()
                .post ()
                .uri ("/api/v1/restaurant")
                .bodyValue (newRestaurantDto)
                .header ( "Authorization","Bearer asdgag" )
                .retrieve ()
                .bodyToMono (RestaurantDto.class)
                .block ();
    }

    // non blocking

    public Mono<RestaurantDto> getResById (String restId){
        return webClient.baseUrl("http://restaurant-service")
                .build().get ()
                .uri ( "/api/v1/restaurant/{id}",restId )
                .retrieve ()
                .bodyToMono ( RestaurantDto.class );
    }

    public Flux<RestaurantDto> getAllNon(){
        return webClient.baseUrl("http://restaurant-service")
                .build()
                .get ()
                .uri ( "/api/v1/restaurant" )
                .retrieve ()
                .bodyToFlux ( RestaurantDto.class );
    }
}

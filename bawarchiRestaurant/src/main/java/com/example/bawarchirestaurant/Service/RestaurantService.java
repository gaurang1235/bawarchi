package com.example.bawarchirestaurant.Service;

import com.example.bawarchirestaurant.Repository.RestaurantRepository;
import com.example.bawarchirestaurant.model.Restaurant;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    private RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant addRestaurant(Restaurant restaurantIn) throws RuntimeException{
        Restaurant restaurantOut = new Restaurant();

        restaurantOut.setUsername(restaurantIn.getUsername());
        restaurantOut.setPassword(restaurantIn.getPassword());
        restaurantOut.setRole("ROLE_RESTAURANT");
        restaurantOut.setName(restaurantIn.getName());
        restaurantOut.setContact(restaurantIn.getContact());
        restaurantOut.setFoodCourtId(restaurantIn.getFoodCourtId());

        restaurantOut = restaurantRepository.save(restaurantOut);

        return restaurantOut;
    }

}

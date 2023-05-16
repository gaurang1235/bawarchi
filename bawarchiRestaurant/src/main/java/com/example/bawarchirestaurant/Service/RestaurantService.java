package com.example.bawarchirestaurant.Service;

import com.example.bawarchirestaurant.Exception.ResourceNotFoundException;
import com.example.bawarchirestaurant.Repository.RestaurantRepository;
import com.example.bawarchirestaurant.model.Restaurant;
import com.example.bawarchirestaurant.model.Role;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    private RestaurantRepository restaurantRepository;

    private AuthService authService;
    private PasswordEncoder passwordEncoder;

    public RestaurantService(RestaurantRepository restaurantRepository, AuthService authService, PasswordEncoder passwordEncoder) {
        this.restaurantRepository = restaurantRepository;
        this.authService = authService;
        this.passwordEncoder = passwordEncoder;
    }

    public Restaurant addRestaurant(Restaurant restaurant, int foodCourtId) throws RuntimeException {
        authService.checkIfUserIdExists(restaurant.getUsername());

        restaurant.setRole(Role.ROLE_RESTAURANT);
        restaurant.setPassword(passwordEncoder.encode(restaurant.getPassword()));
        restaurant.setFoodCourtId(foodCourtId);
        return restaurantRepository.save(restaurant);
    }

    public List<Restaurant> fetchRestaurants(int foodCourtId) throws RuntimeException{
        List<Restaurant> restaurantList = restaurantRepository.findByFoodCourtId(foodCourtId);

        return restaurantList;
    }

    public void deleteRestaurantById(int restaurantId) throws RuntimeException{
        restaurantRepository.deleteById(restaurantId);
    }
    public Restaurant updateRestaurant(Restaurant restaurant, int restaurantId){
        Optional<Restaurant> restaurantToUpdate = restaurantRepository.findById(restaurantId);

        if(restaurantToUpdate.isEmpty()){
            throw new ResourceNotFoundException("No Food Court for the given id " + restaurantId+ " found");
        }

        restaurantToUpdate.get().setName(restaurant.getName());
        restaurantToUpdate.get().setContact(restaurant.getContact());

        return restaurantRepository.save(restaurantToUpdate.get());
    }
}

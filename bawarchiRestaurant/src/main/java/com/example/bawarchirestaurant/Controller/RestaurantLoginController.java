package com.example.bawarchirestaurant.Controller;

import com.example.bawarchirestaurant.Service.RestaurantAuthService;
import com.example.bawarchirestaurant.Service.RestaurantService;
import com.example.bawarchirestaurant.model.Restaurant;
import com.example.bawarchirestaurant.model.RestaurantAuth;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/rlogin")
public class RestaurantLoginController {

    private RestaurantAuthService restaurantAuthService;

    private RestaurantService restaurantService;

    public RestaurantLoginController(RestaurantAuthService restaurantAuthService, RestaurantService restaurantService){
        this.restaurantAuthService = restaurantAuthService;
        this.restaurantService = restaurantService;
    }

    @PostMapping("/")
    public ResponseEntity<RestaurantAuth> loginUser(@RequestBody RestaurantAuth restaurantAuthIn){
       RestaurantAuth restaurantAuthOut = restaurantAuthService.loginCheck(restaurantAuthIn.getUsername(), restaurantAuthIn.getPassword(), restaurantAuthIn.getRole());

        return ResponseEntity.of(Optional.of(restaurantAuthOut));
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurantIn){
        Restaurant restaurantOut = restaurantService.addRestaurant(restaurantIn);

        return ResponseEntity.of(Optional.of(restaurantOut));
    }

}

package com.example.bawarchirestaurant.Controller;

import com.example.bawarchirestaurant.Security.Auth.AuthenticationService;
import com.example.bawarchirestaurant.Security.Auth.JwtResponse;
import com.example.bawarchirestaurant.Service.RestaurantAuthService;
import com.example.bawarchirestaurant.Service.RestaurantService;
import com.example.bawarchirestaurant.Service.AuthService;
import com.example.bawarchirestaurant.model.Restaurant;
import com.example.bawarchirestaurant.model.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/login")
public class RestaurantLoginController {

    private RestaurantAuthService restaurantAuthService;

    private RestaurantService restaurantService;

    private AuthService authService;

    AuthenticationService authenticationService;

    Logger logger = LoggerFactory.getLogger(RestaurantLoginController.class);

    public RestaurantLoginController(AuthenticationService authenticationService, RestaurantAuthService restaurantAuthService, RestaurantService restaurantService, AuthService authService){
        this.authenticationService = authenticationService;
        this.restaurantAuthService = restaurantAuthService;
        this.restaurantService = restaurantService;
        this.authService = authService;
    }

    @PostMapping("/")
    public ResponseEntity<JwtResponse> loginUser(@RequestBody Auth request){

        logger.info("Login API hit at restaurant side");

        JwtResponse response;
        try{
            response= authenticationService.authenticate(request);
        }catch(Exception exception){
            throw exception;
        }

        return ResponseEntity.ok(response);
    }



}

package com.example.bawarchirestaurant.Controller;

import com.example.bawarchirestaurant.Security.Auth.AuthenticationService;
import com.example.bawarchirestaurant.Security.Auth.JwtResponse;
import com.example.bawarchirestaurant.Service.*;
import com.example.bawarchirestaurant.model.AllOrders;
import com.example.bawarchirestaurant.model.Auth;
import com.example.bawarchirestaurant.model.Dish;
import com.example.bawarchirestaurant.model.Restaurant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurantExternal")
public class RestaurantExternalController {

    private RestaurantAuthService restaurantAuthService;

    private RestaurantService restaurantService;

    private DishService dishService;

    private AuthService authService;

    private AllOrdersService allOrdersService;

    AuthenticationService authenticationService;

    Logger logger = LoggerFactory.getLogger(RestaurantExternalController.class);

    public RestaurantExternalController(AuthenticationService authenticationService, RestaurantAuthService restaurantAuthService, RestaurantService restaurantService, AuthService authService, DishService dishService, AllOrdersService allOrdersService){
        this.authenticationService = authenticationService;
        this.restaurantAuthService = restaurantAuthService;
        this.restaurantService = restaurantService;
        this.dishService = dishService;
        this.authService = authService;
        this.allOrdersService = allOrdersService;
    }

    @PostMapping("/addRestaurant/{foodCourtId}")
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant, @PathVariable int foodCourtId){

        logger.info("add Restaurant API hit");

        Restaurant savedRestaurant;
        try{
            savedRestaurant= restaurantService.addRestaurant(restaurant, foodCourtId);
        }catch (RuntimeException exception){
            throw exception;
        }

        return ResponseEntity.of(Optional.of(savedRestaurant));
    }
    @GetMapping("/allRestaurants/{foodCourtId}")
    public ResponseEntity<List<Restaurant>> fetchRestaurants(@PathVariable int foodCourtId){

        logger.info("fetch all Restaurant list for foodcourt API hit");

        List<Restaurant> restaurantList = restaurantService.fetchRestaurants(foodCourtId);

        return ResponseEntity.of(Optional.of(restaurantList));
    }

    @DeleteMapping("/deleteRestaurant/{restaurantId}")
    public void deleteRestaurantById(@PathVariable int restaurantId){

        logger.info("Delete Restaurant API hit");

        try{
            restaurantService.deleteRestaurantById(restaurantId);
        }catch (RuntimeException exception){
            throw exception;
        }
    }
    @PutMapping("/updateRestaurant/{restaurantId}")
    public ResponseEntity<Restaurant> updateRestaurantById(@PathVariable int restaurantId, @RequestBody Restaurant restaurant){

        logger.info("Update Restaurant API hit");

        Restaurant updatedRestaurant;
        try{
            updatedRestaurant= restaurantService.updateRestaurant(restaurant, restaurantId);
        }
        catch(RuntimeException exception){
            throw exception;
        }
        return ResponseEntity.of(Optional.of(updatedRestaurant));
    }


    @PostMapping("/placeOrder/{userId}/{tableNumber}/{restaurantId}")
    public ResponseEntity<AllOrders> placeOrder(@RequestBody AllOrders order, @PathVariable int userId, @PathVariable int tableNumber, @PathVariable int restaurantId){

        logger.info("Place Order API hit");

        AllOrders savedOrder;

        try{
            savedOrder = allOrdersService.addOrder(order, userId, tableNumber, restaurantId);
        }catch(RuntimeException exception){
            throw exception;
        }

        return ResponseEntity.of(Optional.of(savedOrder));

    }

    @GetMapping("/getActiveOrder/{userId}")
    public ResponseEntity<List<AllOrders>> getActiveOrder(@PathVariable int userId){

        logger.info("Get active order API hit");

        List<AllOrders> activeOrder;

        try{
            activeOrder= allOrdersService.fetchActiveOrder(userId);
        }
        catch(RuntimeException exception){
            throw exception;
        }

        return ResponseEntity.of(Optional.of(activeOrder));
    }

    @GetMapping("/{restaurantId}/fetchDishes")
    public ResponseEntity<List<Dish>> fetchDishes(@PathVariable int restaurantId){

        logger.info("Fetch Dish List api hit for a Restaurant");

        List<Dish> dishList = dishService.fetchDishes(restaurantId);

        return ResponseEntity.of(Optional.of(dishList));
    }
}

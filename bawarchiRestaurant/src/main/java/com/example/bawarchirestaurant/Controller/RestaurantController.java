package com.example.bawarchirestaurant.Controller;

import com.example.bawarchirestaurant.Service.AllOrdersService;
import com.example.bawarchirestaurant.Service.DishService;
import com.example.bawarchirestaurant.model.AllOrders;
import com.example.bawarchirestaurant.model.Dish;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private DishService dishService;
    private AllOrdersService allOrdersService;


    Logger logger = LoggerFactory.getLogger(RestaurantController.class);


    public RestaurantController(DishService dishService, AllOrdersService allOrdersService){
        this.dishService = dishService;
        this.allOrdersService = allOrdersService;
    }

    @PostMapping("/{restaurantId}/addDish")
    public ResponseEntity<Dish> addDish(@RequestBody Dish dish, @PathVariable int restaurantId){

        logger.info("add Dish API hit");

        Dish savedDish;
        try{
            savedDish = dishService.addDish(restaurantId, dish);
        }catch(RuntimeException exception){
            throw exception;
        }
        return ResponseEntity.of(Optional.of(savedDish));
    }
    @GetMapping("/{restaurantId}/fetchDishes")
    public ResponseEntity<List<Dish>> fetchDishes(@PathVariable int restaurantId){

        logger.info("Fetch Dish List api hit for a Restaurant");

        List<Dish> dishList = dishService.fetchDishes(restaurantId);

        return ResponseEntity.of(Optional.of(dishList));
    }

    @PutMapping("/updateDish/{dishId}")
    public ResponseEntity<Dish> updateDish(@RequestBody Dish dish, @PathVariable int dishId){

        logger.info("Update Dish API hit");

        Dish updatedDish;
        try{
            updatedDish= dishService.updateDishById(dish, dishId);
        }
        catch(RuntimeException exception){
            throw exception;
        }
        return ResponseEntity.of(Optional.of(updatedDish));
    }

    @DeleteMapping("/deleteDish/{dishId}")
    public void deleteDish(@PathVariable int dishId){

        logger.info("Delete dish API hit");

        try{
            dishService.deleteDishById(dishId);
        }catch (RuntimeException exception){
            throw exception;
        }
    }
    @GetMapping("/{restaurant_id}/fetchPendingOrders")
    public ResponseEntity<List<AllOrders>> fetchPendingOrders(@PathVariable int restaurant_id){

        logger.info("fetch pending orders for Restaurant API hit");

        List<AllOrders> orderList = allOrdersService.fetchPendingOrders(restaurant_id);

        return ResponseEntity.of(Optional.of(orderList));
    }

    @PutMapping("/markOrderComplete/{order_id}")
    public ResponseEntity<AllOrders> updateOrderStatus(@PathVariable int order_id){

        logger.info("mark order complete by Restaurant API hit");

        AllOrders allOrdersOut = allOrdersService.updateOrderStatus(order_id);

        return ResponseEntity.of(Optional.of(allOrdersOut));

    }

}

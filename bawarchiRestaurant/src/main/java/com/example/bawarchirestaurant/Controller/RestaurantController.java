package com.example.bawarchirestaurant.Controller;

import com.example.bawarchirestaurant.Service.DishService;
import com.example.bawarchirestaurant.Service.OrderedService;
import com.example.bawarchirestaurant.model.Dish;
import com.example.bawarchirestaurant.model.Ordered;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private DishService dishService;
    private OrderedService orderedService;


    public RestaurantController(DishService dishService, OrderedService orderedService){
        this.dishService = dishService;
        this.orderedService = orderedService;
    }

    @GetMapping("/{restaurant_id}/fetchDishes")
    public ResponseEntity<List<Dish>> fetchDishes(@PathVariable int restaurant_id){
        List<Dish> dishList = dishService.fetchDishes(restaurant_id);

        return ResponseEntity.of(Optional.of(dishList));
    }


    @PostMapping("/{restaurant_id}/addDish")
    public ResponseEntity<Dish> addDish(@PathVariable int restaurant_id, @RequestBody Dish dishIn){
        Dish dishOut = dishService.addDish(restaurant_id, dishIn);

        return ResponseEntity.of(Optional.of(dishOut));
    }

    @GetMapping("/{restaurant_id}/fetchPendingOrders")
    public ResponseEntity<List<Ordered>> fetchPendingOrders(@PathVariable int restaurant_id){
        List<Ordered> orderList = orderedService.fetchPendingOrders(restaurant_id);

        return ResponseEntity.of(Optional.of(orderList));
    }

    @PutMapping("/markOrderComplete/{order_id}")
    public ResponseEntity<Ordered> updateOrderStatus(@PathVariable int order_id){
        Ordered orderedOut = orderedService.updateOrderStatus(order_id);

        return ResponseEntity.of(Optional.of(orderedOut));

    }

}

package com.example.bawarchirestaurant.Controller;

import com.example.bawarchirestaurant.Service.AllOrdersService;
import com.example.bawarchirestaurant.model.AllOrders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private AllOrdersService allOrdersService;

    public CustomerController(AllOrdersService allOrdersService) {
        this.allOrdersService = allOrdersService;
    }

    @PostMapping("/placeOrder/{userId}/{tableNumber}/{restaurantId}")
    public ResponseEntity<AllOrders> placeOrder(@RequestBody AllOrders order, @PathVariable int userId, @PathVariable int tableNumber, @PathVariable int restaurantId){
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
        List<AllOrders> activeOrder;

        try{
            activeOrder= allOrdersService.fetchActiveOrder(userId);
        }
        catch(RuntimeException exception){
            throw exception;
        }

        return ResponseEntity.of(Optional.of(activeOrder));
    }
}

package com.example.bawarchirestaurant.Service;

import com.example.bawarchirestaurant.Repository.OrderedRepository;
import com.example.bawarchirestaurant.Repository.RestaurantRepository;
import com.example.bawarchirestaurant.model.Ordered;
import com.example.bawarchirestaurant.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderedService {

    private OrderedRepository orderedRepository;
    private RestaurantRepository restaurantRepository;

    public OrderedService(OrderedRepository orderedRepository, RestaurantRepository restaurantRepository){
        this.orderedRepository = orderedRepository;
        this.restaurantRepository = restaurantRepository;
    }


    public List<Ordered> fetchPendingOrders(int restaurant_id) throws RuntimeException{
        Restaurant restaurant = restaurantRepository.findByRestaurantAuthId(restaurant_id);

        if(restaurant==null){
            System.out.println("Restaurant not found");
        }

        List<Ordered> orderList = orderedRepository.findByRestaurantAndStatus(restaurant, false);

        return orderList;
    }

    public Ordered updateOrderStatus(int orderId) throws RuntimeException{
        Ordered order = orderedRepository.findByOrderId(orderId);

        if(order==null){
            System.out.println("Order not found");
        }

        order.setStatus(true);

        order = orderedRepository.save(order);

        return order;
    }
}

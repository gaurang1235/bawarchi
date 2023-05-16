package com.example.bawarchirestaurant.Service;

import com.example.bawarchirestaurant.Repository.OrderedRepository;
import com.example.bawarchirestaurant.Repository.RestaurantRepository;
import com.example.bawarchirestaurant.model.AllOrders;
import com.example.bawarchirestaurant.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllOrdersService {

    private OrderedRepository orderedRepository;
    private RestaurantRepository restaurantRepository;

    public AllOrdersService(OrderedRepository orderedRepository, RestaurantRepository restaurantRepository){
        this.orderedRepository = orderedRepository;
        this.restaurantRepository = restaurantRepository;
    }


    public List<AllOrders> fetchPendingOrders(int restaurant_id) throws RuntimeException{
        Restaurant restaurant = restaurantRepository.findByAuthId(restaurant_id);

        if(restaurant==null){
            System.out.println("Restaurant not found");
        }

        List<AllOrders> orderList = orderedRepository.findByRestaurantAndStatus(restaurant, false);

        return orderList;
    }

    public AllOrders updateOrderStatus(int orderId) throws RuntimeException{
        AllOrders order = orderedRepository.findByOrderId(orderId);

        if(order==null){
            System.out.println("Order not found");
        }

        order.setStatus(true);

        order = orderedRepository.save(order);

        return order;
    }
}

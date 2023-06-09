package com.example.bawarchirestaurant.Repository;


import com.example.bawarchirestaurant.model.AllOrders;
import com.example.bawarchirestaurant.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AllOrdersRepository extends JpaRepository<AllOrders, Integer> {

    List<AllOrders> findByRestaurantAndStatus(Restaurant restaurant, Boolean status);

    AllOrders findByOrderId(int orderId);

    List<AllOrders> findByUserIdAndStatus(int userId, boolean status);
}

package com.example.bawarchirestaurant.Repository;

import com.example.bawarchirestaurant.model.Ordered;
import com.example.bawarchirestaurant.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderedRepository extends JpaRepository<Ordered, Integer> {

    List<Ordered> findByRestaurantAndStatus(Restaurant restaurant, Boolean status);

    Ordered findByOrderId(int orderId);

}

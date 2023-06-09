package com.example.bawarchirestaurant.Repository;

import com.example.bawarchirestaurant.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    Restaurant findByAuthId(int restaurant_id);

    List<Restaurant> findByFoodCourtId(int foodCourtId);

}

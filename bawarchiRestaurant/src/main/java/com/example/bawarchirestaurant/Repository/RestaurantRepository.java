package com.example.bawarchirestaurant.Repository;

import com.example.bawarchirestaurant.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    Restaurant findByRestaurantAuthId(int restaurant_id);

}

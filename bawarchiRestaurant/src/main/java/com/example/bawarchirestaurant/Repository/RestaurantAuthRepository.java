package com.example.bawarchirestaurant.Repository;

import com.example.bawarchirestaurant.model.RestaurantAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantAuthRepository extends JpaRepository<RestaurantAuth, Integer> {

    RestaurantAuth findByUsername(String username);

}

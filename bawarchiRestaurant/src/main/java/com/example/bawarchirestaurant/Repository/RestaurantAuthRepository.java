package com.example.bawarchirestaurant.Repository;


import com.example.bawarchirestaurant.model.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantAuthRepository extends JpaRepository<Auth, Integer> {

    Auth findByUsername(String username);

}
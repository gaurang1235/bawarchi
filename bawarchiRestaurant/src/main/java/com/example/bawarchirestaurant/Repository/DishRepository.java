package com.example.bawarchirestaurant.Repository;

import com.example.bawarchirestaurant.model.Dish;
import com.example.bawarchirestaurant.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Integer> {

    List<Dish> findByRestaurant(Restaurant restaurant);

}

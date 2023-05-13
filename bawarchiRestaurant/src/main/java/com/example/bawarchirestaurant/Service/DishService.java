package com.example.bawarchirestaurant.Service;

import com.example.bawarchirestaurant.Repository.DishRepository;
import com.example.bawarchirestaurant.Repository.RestaurantRepository;
import com.example.bawarchirestaurant.model.Dish;
import com.example.bawarchirestaurant.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {

    private DishRepository dishRepository;

    private RestaurantRepository restaurantRepository;

    public DishService(DishRepository dishRepository, RestaurantRepository restaurantRepository){
        this.dishRepository = dishRepository;
        this.restaurantRepository = restaurantRepository;
    }


    public List<Dish> fetchDishes(int restaurant_id) throws RuntimeException{
        Restaurant restaurant = restaurantRepository.findByRestaurantAuthId(restaurant_id);

        if(restaurant==null){
            System.out.println("Restaurant not found");
        }

        List<Dish> dishList = dishRepository.findByRestaurant(restaurant);

        return dishList;
    }

    public Dish addDish(int restaurant_id, Dish dishIn) throws RuntimeException{
        Restaurant restaurant = restaurantRepository.findByRestaurantAuthId(restaurant_id);

        if(restaurant==null){
            System.out.println("Restaurant not found");
        }

        Dish dishOut = new Dish();

        dishOut.setName(dishIn.getName());
        dishOut.setCategory(dishIn.getCategory());
        dishOut.setPrice(dishIn.getPrice());
        dishOut.setRestaurant(restaurant);

        dishOut = dishRepository.save(dishOut);

        return dishOut;
    }

}

package com.example.bawarchifoodcourt.Controller;

import com.example.bawarchifoodcourt.model.Restaurant;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/foodCourt")
public class FoodCourtController {

    Logger logger = LoggerFactory.getLogger(FoodCourtController.class);

    @PostMapping("/addRestaurant/{foodCourtId}")
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurantIn, @PathVariable int foodCourtId) throws RuntimeException{

        logger.info("Add Restaurant api called");

        String url = "http://dockerhost:9191/login/addRestaurant/" + foodCourtId;
        HttpHeaders headers = new HttpHeaders ();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //headers .set ("Authorization", "Bearer xxxxXxx");
        String json;
        try {
            json = new ObjectMapper().writeValueAsString(restaurantIn);
        } catch (JsonProcessingException e) {
            logger.error("Exception caught while adding food court");
            throw new RuntimeException(e);
        }
        HttpEntity entity = new HttpEntity (json, headers);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(url, HttpMethod.POST, entity, Restaurant.class);
    }


    @GetMapping("/allRestaurants/{foodCourtId}")
    public ResponseEntity<List<Restaurant>> fetchRestaurants(@PathVariable int foodCourtId){

        logger.info("Fetch Restaurant List api called");

        String url = "http://dockerhost:9191/login/allRestaurants/" + foodCourtId;
//        HttpHeaders headers = new HttpHeaders ();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        //headers .set ("Authorization", "Bearer xxxxXxx");
//        String json;
//        try {
//            json = new ObjectMapper().writeValueAsString(restaurantIn);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//        HttpEntity entity = new HttpEntity ();

        RestTemplate restTemplate = new RestTemplate();


        List<Restaurant> restaurantList = new ArrayList<>();


        return (ResponseEntity<List<Restaurant>>) restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, restaurantList.getClass());
    }

    @DeleteMapping("/deleteRestaurant/{restaurantId}")
    public void deleteRestaurantById(@PathVariable int restaurantId){

        logger.info("Delete Restaurant api called");

        String url = "http://dockerhost:9191/login/deleteRestaurant/" + restaurantId;
//        HttpHeaders headers = new HttpHeaders ();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        //headers .set ("Authorization", "Bearer xxxxXxx");
//        String json;
//        try {
//            json = new ObjectMapper().writeValueAsString(restaurantIn);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//        HttpEntity entity = new HttpEntity (json, headers);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(url, HttpMethod.DELETE, HttpEntity.EMPTY, Restaurant.class);
    }


    @PutMapping("/updateRestaurant/{restaurantId}")
    public ResponseEntity<Restaurant> updateRestaurantById(@PathVariable int restaurantId, @RequestBody Restaurant restaurantIn) {

        logger.info("Update Restaurant api called");

        String url = "http://dockerhost:9191/login/updateRestaurant/" + restaurantId;
        HttpHeaders headers = new HttpHeaders ();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //headers .set ("Authorization", "Bearer xxxxXxx");
        String json;
        try {
            json = new ObjectMapper().writeValueAsString(restaurantIn);
        } catch (JsonProcessingException e) {
            logger.error("Exception caught while updating food court");
            throw new RuntimeException(e);
        }
        HttpEntity entity = new HttpEntity (json, headers);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(url, HttpMethod.PUT, entity, Restaurant.class);
    }

}

package com.example.bawarchifoodcourt.Controller;

import com.example.bawarchifoodcourt.model.Restaurant;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/foodCourt")
public class FoodCourtController {

    @PostMapping("/addRestaurant")
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurantIn) throws RuntimeException{

        String url = "http://dockerhost:9191/rlogin/addRestaurant";
        HttpHeaders headers = new HttpHeaders ();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //headers .set ("Authorization", "Bearer xxxxXxx");
        String json;
        try {
            json = new ObjectMapper().writeValueAsString(restaurantIn);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        HttpEntity entity = new HttpEntity (json, headers);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(url, HttpMethod.POST, entity, Restaurant.class);
    }

}

package com.example.bawarchifoodcourt.Controller;

import com.example.bawarchifoodcourt.Service.FoodCourtService;
import com.example.bawarchifoodcourt.model.FoodCourt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/superAdmin")
public class SuperAdminController {

    private FoodCourtService foodCourtService;

    Logger logger = LoggerFactory.getLogger(SuperAdminController.class);

    public SuperAdminController(FoodCourtService foodCourtService){
        this.foodCourtService = foodCourtService;
    }

    @PostMapping("/addFoodCourt")
    public ResponseEntity<FoodCourt> addFoodCourt(@RequestBody FoodCourt foodCourtIn){

        logger.info("Add FoodCourt API called");

        FoodCourt foodCourtOut = foodCourtService.addFoodCourt(foodCourtIn);

        return ResponseEntity.of(Optional.of(foodCourtOut));
    }

    @GetMapping("/allFoodCourts")
    public ResponseEntity<List<FoodCourt>> fetchFoodCourt(){

        logger.info("Fetch Food Court List api called");

        List<FoodCourt> foodCourtList = foodCourtService.fetchFoodCourts();

        return ResponseEntity.of(Optional.of(foodCourtList));
    }

    @DeleteMapping("/deleteFoodCourt/{foodCourtId}")
    public void deleteFoodCourtById(@PathVariable int foodCourtId){

        logger.info("Delete Food Court api called");

        try{
            foodCourtService.deleteFoodCourtById(foodCourtId);
        }catch (RuntimeException exception){
            logger.error("Exception caught while deleting food court");
            throw exception;
        }
    }

    @PutMapping("/updateFoodCourt/{foodCourtId}")
    public ResponseEntity<FoodCourt> updateFoodCourtById(@PathVariable int foodCourtId, @RequestBody FoodCourt foodCourt){

        logger.info("Update Food Court api called");

        FoodCourt updatedFoodCourt;
        try{
            updatedFoodCourt= foodCourtService.updateFoodCourt(foodCourt, foodCourtId);
        }
        catch(RuntimeException exception){
            logger.error("Exception caught while updating food court");
            throw exception;
        }
        return ResponseEntity.of(Optional.of(updatedFoodCourt));
    }

}

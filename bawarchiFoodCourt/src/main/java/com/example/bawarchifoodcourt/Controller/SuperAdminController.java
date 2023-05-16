package com.example.bawarchifoodcourt.Controller;

import com.example.bawarchifoodcourt.Service.FoodCourtService;
import com.example.bawarchifoodcourt.model.FoodCourt;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/superAdmin")
public class SuperAdminController {

    private FoodCourtService foodCourtService;

    public SuperAdminController(FoodCourtService foodCourtService){
        this.foodCourtService = foodCourtService;
    }

    @PostMapping("/addFoodCourt")
    public ResponseEntity<FoodCourt> addFoodCourt(@RequestBody FoodCourt foodCourtIn){
        FoodCourt foodCourtOut = foodCourtService.addFoodCourt(foodCourtIn);

        return ResponseEntity.of(Optional.of(foodCourtOut));
    }

    @GetMapping("/allFoodCourts")
    public ResponseEntity<List<FoodCourt>> fetchFoodCourt(){
        List<FoodCourt> foodCourtList = foodCourtService.fetchFoodCourts();

        return ResponseEntity.of(Optional.of(foodCourtList));
    }

    @DeleteMapping("/deleteFoodCourt/{foodCourtId}")
    public void deleteFoodCourtById(@PathVariable int foodCourtId){
        try{
            foodCourtService.deleteFoodCourtById(foodCourtId);
        }catch (RuntimeException exception){
            throw exception;
        }
    }

    @PutMapping("/updateFoodCourt/{foodCourtId}")
    public ResponseEntity<FoodCourt> updateFoodCourtById(@PathVariable int foodCourtId, @RequestBody FoodCourt foodCourt){
        FoodCourt updatedFoodCourt;
        try{
            updatedFoodCourt= foodCourtService.updateFoodCourt(foodCourt, foodCourtId);
        }
        catch(RuntimeException exception){
            throw exception;
        }
        return ResponseEntity.of(Optional.of(updatedFoodCourt));
    }

}

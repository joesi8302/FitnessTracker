package com.synergisticit.controller;

import com.synergisticit.model.Calorie;
import com.synergisticit.service.CalorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calorie")
public class CalorieController {

    @Autowired
    CalorieService calorieService;


    @GetMapping("/{calId}")
    public ResponseEntity<Calorie> findById(@PathVariable long id) {
        return new ResponseEntity<Calorie>(calorieService.findById(id), HttpStatus.FOUND);
    }

    @GetMapping("/calories")
    public ResponseEntity<List<Calorie>> findAll() {
        List<Calorie> calorieList = calorieService.findAll();

        return new ResponseEntity<List<Calorie>> (calorieList, HttpStatus.FOUND);
    }


    @PostMapping("/saveCalorie")
    public ResponseEntity<String> saveCalorie(@RequestBody Calorie calorie) {
        calorieService.saveCalorie(calorie);
        return new ResponseEntity<String>("New Calorie Item has been saved",HttpStatus.ACCEPTED);
    }


    @PutMapping("/updateCalorie")
    public ResponseEntity<String> updateCalorie(@RequestBody Calorie calorie) {
        Calorie foundCalorie = calorieService.findById(calorie.getId());
        if(foundCalorie != null){
            foundCalorie.setFoodName(calorie.getFoodName());
            foundCalorie.setCalories(calorie.getCalories());

            return new ResponseEntity<String>("Calorie Item with Id: " + calorie.getId() + " has been updated", HttpStatus.ACCEPTED);
        }else {
            return new ResponseEntity<String>("Calorie Item not found", HttpStatus.NOT_FOUND);
        }

    }


    @PostMapping("/deleteCalorie/{calId}")
    public ResponseEntity<String> deleteUserById(@PathVariable long id) {
        Calorie foundCalorie = calorieService.findById(id);
        if(foundCalorie != null){
            calorieService.deleteCalorieById(id);
        }
        return new ResponseEntity<String>("Calorie Item with Id: " + id + " has been deleted", HttpStatus.ACCEPTED);
    }

}

package com.synergisticit.service;

import com.synergisticit.model.Calorie;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CalorieService {

    Calorie findById(long id);
    List<Calorie> findAll();
    void saveCalorie(Calorie calorie);
    Calorie updateCalorie(Calorie calorie);
    void deleteCalorieById(long id);
}

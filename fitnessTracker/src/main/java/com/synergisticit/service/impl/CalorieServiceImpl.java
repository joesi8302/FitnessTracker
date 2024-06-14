package com.synergisticit.service.impl;

import com.synergisticit.model.Calorie;
import com.synergisticit.repository.CalorieRepository;
import com.synergisticit.service.CalorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CalorieServiceImpl implements CalorieService {

    @Autowired
    CalorieRepository calorieRepository;

    @Override
    public Calorie findById(long id) {
        return calorieRepository.findById(id);
    }

    @Override
    public List<Calorie> findAll() {
        return calorieRepository.findAll();
    }

    @Override
    public void saveCalorie(Calorie calorie) {
        calorieRepository.saveUser(calorie);
    }

    @Override
    public Calorie updateCalorie(Calorie calorie) {
        return calorieRepository.saveUser(calorie);

    }

    @Override
    public void deleteCalorieById(long id) {
        calorieRepository.deleteUserById(id);


    }
}

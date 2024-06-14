package com.synergisticit.repository;

import com.mongodb.client.result.DeleteResult;
import com.synergisticit.model.Calorie;


import java.util.List;

public interface CalorieRepository {

    Calorie findById(long id);
    List<Calorie> findAll();
    Calorie saveUser(Calorie calorie);
    Calorie updateUser(Calorie calorie);
    void deleteUserById(long id);

}

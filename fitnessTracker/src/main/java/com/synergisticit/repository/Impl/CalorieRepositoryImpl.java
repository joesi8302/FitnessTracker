package com.synergisticit.repository.Impl;

import com.mongodb.client.result.DeleteResult;
import com.synergisticit.model.Calorie;
import com.synergisticit.repository.CalorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CalorieRepositoryImpl implements CalorieRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Calorie findById(long id) {

        return mongoTemplate.findById(id, Calorie.class);
    }

    @Override
    public List<Calorie> findAll() {
        return mongoTemplate.findAll(Calorie.class);
    }

    @Override
    public Calorie saveUser(Calorie calorie) {
        return mongoTemplate.save(calorie);
    }

    @Override
    public Calorie updateUser(Calorie calorie) {
        return mongoTemplate.save(calorie);
    }

    @Override
    public void deleteUserById(long id) {
        Calorie calorie = new Calorie();
        calorie.setId(id);
        mongoTemplate.remove(calorie);
    }
}

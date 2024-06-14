package com.synergisticit.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "calorieItems")
public class Calorie {

    @Id
    long id;
    String foodName;
    double calories;

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Calories{" +
                "id=" + id +
                ", foodName='" + foodName + '\'' +
                ", calories=" + calories +
                '}';
    }
}

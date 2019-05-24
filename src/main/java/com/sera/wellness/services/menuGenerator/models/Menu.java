package com.sera.wellness.services.menuGenerator.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    private Meal[] meals;
    private Integer rest;
    public Menu(Integer numberOfMeals) {
        if (numberOfMeals!=3 && numberOfMeals !=5) {
            throw new IllegalArgumentException("You can eat only 3 or 5 times !!!1!");
        }
        meals = new Meal[numberOfMeals];
    }
    public void setMeals(Meal[] meals) {
        if (meals.length !=3 && meals.length != 5) {
            throw new IllegalArgumentException("You can eat only 3 or 5 times !!!1!");
        }
        this.meals = meals;
    }
    public Meal[] getMeals() {
        return meals;
    }

}

package com.sera.wellness.services.menuGenerator;

import com.sera.wellness.services.menuGenerator.models.Meal;
import com.sera.wellness.services.menuGenerator.models.Menu;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class MenuGenerator {
    //https://cmtscience.ru/ + https://vk.com/gibkayadieta
    private final float FATS_PER_KG_MIN = 0.8f;
    private final float FATS_PER_KG_MAX = 1.2f;
    private final float FATS_PER_KG_AVG = 1f;

    private final float PROTEIN_PER_KG_MIN = 1f;
    private final float PROTEIN_PER_KG_MAX = 1.5f;
    private final float PROTEIN_PER_KG_AVG = 2f;

    //carbohydrates - rest

    private Integer caloriesPerDay;

    public Menu generate(Menu menu) throws Exception {
        Meal[] meals = menu.getMeals();
        if (meals.length == 3) {
            Integer morningMeal = caloriesPerDay/100 * 20;//because I can
            Integer dayMeal = caloriesPerDay/100 * 40;//because I can
            Integer eveningMeal = caloriesPerDay/100 * 30;//because I can
            Integer rest = caloriesPerDay - morningMeal - dayMeal - eveningMeal;//you can eat candies YUUUHUUUUUU
            menu.setRest(rest);


        } else if (meals.length == 5) {
            throw new Exception("not realized");
        } else {
            throw new IllegalArgumentException("You can eat only 3 or 5 times !!!1!");
        }

        return menu;
    }
}

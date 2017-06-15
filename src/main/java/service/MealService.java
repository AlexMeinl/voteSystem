package service;

import model.Meal;

import java.util.List;

public interface MealService {

    Meal add (Meal meal, Integer r_id);

    void delete(Integer id, Integer r_id);

    Meal get(Integer id, Integer r_id);

    List<Meal> getAll(Integer r_id);

    Meal setRestaurantById(Meal meal, Integer r_id);
}

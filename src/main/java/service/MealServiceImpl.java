package service;


import model.Meal;
import model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repository.MealRepository;
import repository.RestaurantRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MealServiceImpl implements MealService {

    private final MealRepository mealRepository;

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public MealServiceImpl(MealRepository mealRepository, RestaurantRepository restaurantRepository) {
        this.mealRepository = mealRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Meal add(Meal meal, Integer r_id) {
        Assert.notNull(meal, "Meal invalid!!!");
        if (meal.isNew() && meal.getRestaurant().getId() != null) {
            return null;
        }

        mealRepository.save(setRestaurantById(meal, r_id));
        return meal;
    }

    @Override
    public Meal setRestaurantById(Meal meal, Integer r_id) {
        Restaurant newRestaurant = restaurantRepository.findOne(r_id);
        Assert.notNull(meal, "Meal invalid!!!");
        Assert.notNull(newRestaurant, "Restaurant is invalid!!!");
        meal.setRestaurant(newRestaurant);
        return meal;

    }

    @Override
    public void delete(Integer id, Integer r_id) {
        assert (id >= 0 && r_id.equals(mealRepository.findOne(id).getRestaurant().getId()));
        mealRepository.delete(id);
    }

    @Override
    public Meal get(Integer id, Integer r_id) {
        assert (r_id.equals(mealRepository.getOne(id).getRestaurant().getId()));
        return mealRepository.findOne(id);
    }

    @Override
    public List<Meal> getAll(Integer r_id) {
        return restaurantRepository.findOne(r_id).getMenu().stream().collect(Collectors.toList());
    }
}

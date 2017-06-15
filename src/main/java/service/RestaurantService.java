package service;

import model.Meal;
import model.Restaurant;
import model.User;

import java.util.List;

public interface RestaurantService {

    Restaurant add(Restaurant restaurant);

    //void vote(Restaurant restaurant, Integer user_id);
    //Restaurant update(Restaurant restaurant);

//    boolean deleteVotedUser(Integer id, Integer userId);
//
//    boolean addVotedUser(Integer id, User user);

    void delete(Integer id);

    Restaurant get(Integer id);

    List<Restaurant> getAll();

    List<User> getAllVotedUsers(Restaurant restaurant);

    List<Meal> getMenuByRestaurant(Restaurant restaurant);
}

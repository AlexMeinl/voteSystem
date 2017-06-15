package service;

import model.Restaurant;
import model.User;

import java.util.List;

public interface UserService {

    User add(User user);

    void delete(Integer id);

    User get(Integer id);

    List<User> getAll();

    //User update(User user);

    void vote(Restaurant restaurant, Integer loggingUserId);
}
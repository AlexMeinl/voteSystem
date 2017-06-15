package service;

import model.Restaurant;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import repository.RestaurantRepository;
import repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public User add(User user) {
        Assert.notNull(user, "Юзер отсутствует!!!");
        return repository.save(user);
    }

//    public User update(User user) {
//        Assert.notNull(user, "Отсутствуеь юзер!!!");
//        repository.save(user);
//        return user;
//    }

    public void delete(Integer id) {
        repository.delete(id);
    }

    public User get(Integer id) {
        assert (id > 0);
        return repository.findOne(id);
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public void vote(Restaurant restaurant, Integer loggingUserId) {
        Assert.notNull(restaurant, "Отсутствует ресторан!!!!");
        User user = repository.findOne(loggingUserId);
        Assert.notNull(user, "User NOT found!!!");
        if (!user.getRestaurants().isEmpty()) {
            user.getRestaurants().clear();
        }
        user.getRestaurants().add(restaurant);
        repository.save(user);
    }
}

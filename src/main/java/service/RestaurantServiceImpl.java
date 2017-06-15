package service;

import model.Meal;
import model.Restaurant;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import repository.RestaurantRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository repository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Restaurant add(Restaurant restaurant) {
        Assert.notNull(restaurant, "Отсутствует ресторан!!!");
        repository.saveAndFlush(restaurant);
        return restaurant;
    }

//    public Restaurant update(Restaurant restaurant) {
//        Assert.notNull(restaurant, "Отсутствует рестопан!!!");
//        repository.save(restaurant);
//        return restaurant;
//    }

    public void delete(Integer id) {
        repository.delete(id);
    }

    public Restaurant get(Integer id) {
        assert (id > 0);
        return repository.findOne(id);
    }

    public List<Restaurant> getAll() {
        return repository.findAll();
    }

    @Override
    public List<User> getAllVotedUsers(Restaurant restaurant) {
        Assert.notNull(restaurant, "Restaurant is empty!!!");
        return repository.findOne(restaurant.getId()).getVotedUsers();
    }

    @Transactional
    public List<Meal> getMenuByRestaurant(Restaurant restaurant) {
        Assert.notNull(restaurant, "Отсутствует ресторан!!!");
        return repository.findOne(restaurant.getId()).getMenu().stream().collect(Collectors.toList());
    }

//    public boolean deleteVotedUser(Integer id, Integer userId) {
//        VotedUser votedUser = repository.findOne(id).getVotedUsers().stream().filter((v) -> v.getUserId().equals(userId)).findFirst().get();
//        return repository.findOne(id).getVotedUsers().remove(votedUser);
//    }
//
//    public boolean addVotedUser(Integer id, User user) {
//        Assert.notNull(user, "Отсцтсыует юзкр!!!");
//        return repository.findOne(id).getVotedUsers().add(new VotedUser(id, user.getId()));
//    }

    //    public void vote(Restaurant restaurant, Integer user_id)
//    {
//        Assert.notNull(restaurant, "Отсутствует ресторан!!!");
//        Restaurant result = repository.findOne(restaurant.getId());
//        repository.save(result);
//    }
}

package service;

import model.Role;
import model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;


@ContextConfiguration("classpath:spring/spring-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImplTest.class);

    @Autowired
    private UserService service;
    @Autowired
    private RestaurantService restaurantService;

    @Test
    public void add() throws Exception {
        User newUser = service.add(new User(null, "Igor", Collections.singleton(Role.ROLE_USER)));
        LOGGER.info("!!User has been added", newUser.getName());
    }

    @Test
    public void delete() throws Exception {
        service.delete(1);
        System.out.println(service.get(1));
    }

    @Test
    public void get() throws Exception {
        System.out.println(service.get(1));
    }

    @Test
    public void getAll() throws Exception {
        System.out.println(service.getAll().size());
    }

    @Test
    public void vote() throws Exception {
        service.vote(restaurantService.get(3), 1);
        service.vote(restaurantService.get(3), 0);
        System.out.println(service.get(1).getRestaurants().get(0));
        System.out.println(restaurantService.getAllVotedUsers(restaurantService.get(3)));
    }

}
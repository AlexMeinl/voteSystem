package service;

import model.Meal;
import model.Restaurant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration("classpath:spring/spring-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RestaurantServiceImplTest {

    @Autowired
    private RestaurantService service;

    @Test
    public void testAdd() throws Exception {
        Restaurant restaurant = new Restaurant(null,"Xtndthnsq");
        System.out.println(service.add(restaurant));
    }

    @Test
    public void testDelete() throws Exception {
        service.delete(2);
    }

    @Test
    public void testGet() throws Exception {
        System.out.println(service.get(2));
    }

    @Test
    public void testGetAll() throws Exception {
        for (Restaurant restaurant : service.getAll())
            System.out.println(restaurant);
    }

    @Test
    public void testGetMenuByRestaurant() throws Exception {

        for (Meal meal : service.getMenuByRestaurant(service.get(2))) {
            System.out.println(meal);
        }
    }

    @Test
    public void getAllVotedUsers() throws Exception {
        System.out.println(service.getAllVotedUsers(service.get(2)));
    }

}
package service;

import model.Meal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration("classpath:spring/spring-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MealServiceImplTest {

    @Autowired
    private MealService mealService;

    @Test
    public void add() throws Exception {
        System.out.println(mealService.add(new Meal(null, 1000, "gamburger"), 2));
    }

    @Test
    public void delete() throws Exception {
        mealService.delete(9, 2);
    }

    @Test
    public void get() throws Exception {

    }

    @Test
    public void getAll() throws Exception {

    }

}
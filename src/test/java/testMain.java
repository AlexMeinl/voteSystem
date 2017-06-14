import model.Meal;
import model.Role;
import model.User;
import org.springframework.context.support.GenericXmlApplicationContext;
import service.RestaurantService;
import service.UserService;

public class testMain {

        public static void main(String[] args) {

            GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
            ctx.load("classpath:spring/spring-config.xml"); //move from src.main.java to src.main.resources
            ctx.refresh();

            UserService service = ctx.getBean(UserService.class);
            RestaurantService restaurantService = ctx.getBean(RestaurantService.class);

            System.out.println(service.get(0));
            System.out.println(service.add(new User()));
            for (Meal meal : restaurantService.getMenuByRestaurant(restaurantService.get(2))) {
                System.out.println(meal);
            }

            //service.add(new User(null, "name", Role.ROLE_ADMIN));
        }


}

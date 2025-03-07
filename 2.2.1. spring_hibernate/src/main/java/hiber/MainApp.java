package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car(1488, "nissan");
      Car car2 = new Car(1489, "toyota");
      Car car3 = new Car(1490, "opel");

      User user1 = new User("Katya", "Bogomolnaya", "meow@mail.ru");
      User user2 = new User("Danya", "Gorelik", "danya@mail.ru");
      User user3 = new User("Masha", "Ivanova", "ivanova@mail.ru");

      user1.setCar(car1);
      user2.setCar(car2);
      user3.setCar(car3);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);

      System.out.println(userService.getUserByCar("toyota", 1489).getFirstName());
      System.out.println(userService.getUserByCar("opel", 1490).getFirstName());
      System.out.println(userService.getUserByCar("nissan", 1488).getFirstName());

      context.close();
   }
}

package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);


        User user1 = new User("User1", "Lastname1", "user1@mail.ru", new Car("BMW", 3));
        User user2 = new User("User2", "Lastname2", "user2@mail.ru", new Car("BMW", 4));
        User user3 = new User("User3", "Lastname3", "user3@mail.ru", new Car("BMW", 5));
        User user4 = new User("User4", "Lastname4", "user4@mail.ru", new Car("BMW", 7));

        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);
        userService.addUser(user4);

        System.out.println(userService.getUserByCar("BMW", 3));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        context.close();
    }
}

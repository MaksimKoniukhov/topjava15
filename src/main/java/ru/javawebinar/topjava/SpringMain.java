package ru.javawebinar.topjava;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.to.MealWithExceed;
import ru.javawebinar.topjava.web.meal.MealRestController;
import ru.javawebinar.topjava.web.user.AdminRestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class SpringMain {
    public static void main(String[] args) {
        // java 7 Automatic resource management
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml")) {
            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()) + "\n");
            AdminRestController adminUserController = appCtx.getBean(AdminRestController.class);
            User user = adminUserController.create(new User(null, "userName", "email@mail.ru", "password", Role.ROLE_ADMIN));
            System.out.println(user + "\n");

            MealRestController mealRestController = appCtx.getBean(MealRestController.class);
            List<MealWithExceed> listTime = mealRestController.getAllFiltered(LocalDate.MIN, LocalDate.MAX, LocalTime.of(10, 0),
                    LocalTime.of(13, 0));
            System.out.println(listTime + "\n");

            List<MealWithExceed> listDate = mealRestController.getAllFiltered(LocalDate.of(2015, Month.MAY, 31),
                    LocalDate.of(2015, Month.MAY, 31), LocalTime.MIN, LocalTime.MAX);
            System.out.println(listDate + "\n");


        }
    }
}

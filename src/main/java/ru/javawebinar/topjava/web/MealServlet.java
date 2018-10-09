package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.service.MealServiceImpl;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);
    private MealService mealService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.mealService = new MealServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("method get");

        String forward;
        String action = request.getParameter("action");
        if ("delete".equals(action)) {
            int mealId = Integer.parseInt(request.getParameter("id"));
            mealService.delete(mealId);
            response.sendRedirect("meals");
        } else {
            if ("update".equals(action)) {
                forward = "mealForm.jsp";
                int mealId = Integer.parseInt(request.getParameter("id"));
                Meal meal = mealService.getById(mealId);
                request.setAttribute("meal", meal);
            } else if ("create".equals(action)) {
                forward = "mealForm.jsp";
            } else {
                forward = "/meals.jsp";
                request.setAttribute("listMeals", MealsUtil.getFilteredWithExceeded(mealService.getAll(), null, null, 2000));
            }
            request.getRequestDispatcher(forward).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("method post");
        request.setCharacterEncoding("UTF-8");
        String mealId = request.getParameter("id");
        LocalDateTime dateTime = LocalDateTime.parse(request.getParameter("dateTime"));
        String description = request.getParameter("description");
        int calories = Integer.parseInt(request.getParameter("calories"));
        Meal meal = new Meal(dateTime, description, calories);
        if (mealId == null || mealId.isEmpty()) {
            mealService.create(meal);
        } else {
            meal.setId(Integer.parseInt(mealId));
            mealService.update(meal, meal.getId());
        }
        response.sendRedirect("meals");
    }
}

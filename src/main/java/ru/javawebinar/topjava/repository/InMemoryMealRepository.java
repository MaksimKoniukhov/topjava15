package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static ru.javawebinar.topjava.util.MealsUtil.MEALS;

public class InMemoryMealRepository implements MealRepository {
    private static final Map<Integer, Meal> MEAL_MAP = new ConcurrentHashMap<>();
    private static AtomicInteger atomicInteger = new AtomicInteger();

    static {
        MEALS.forEach(meal -> {
            meal.setId(atomicInteger.incrementAndGet());
            MEAL_MAP.put(meal.getId(), meal);
        });
    }

    @Override
    public void add(Meal meal) {
        meal.setId(atomicInteger.incrementAndGet());
        MEAL_MAP.put(meal.getId(), meal);
    }

    @Override
    public void update(Meal meal, int id) {
        MEAL_MAP.put(id, meal);
    }

    @Override
    public void delete(int id) {
        MEAL_MAP.remove(id);
    }

    @Override
    public List<Meal> getAll() {
        return new ArrayList<>(MEAL_MAP.values());
    }

    @Override
    public Meal getById(int id) {
        return MEAL_MAP.get(id);
    }
}

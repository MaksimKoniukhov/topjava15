package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;

import java.util.List;

public interface MealService {
    void create(Meal meal);

    void update(Meal meal, int id);

    void delete(int id);

    List<Meal> getAll();

    Meal getById(int id);
}

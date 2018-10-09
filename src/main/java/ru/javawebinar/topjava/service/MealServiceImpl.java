package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.InMemoryMealRepository;
import ru.javawebinar.topjava.repository.MealRepository;

import java.util.List;

public class MealServiceImpl implements MealService {
    private MealRepository mealRepository;

    public MealServiceImpl() {
        this.mealRepository = new InMemoryMealRepository();
    }

    @Override
    public void create(Meal meal) {
        mealRepository.add(meal);
    }

    @Override
    public void update(Meal meal, int id) {
        mealRepository.update(meal, id);
    }

    @Override
    public void delete(int id) {
        mealRepository.delete(id);
    }

    @Override
    public List<Meal> getAll() {
        return mealRepository.getAll();
    }

    @Override
    public Meal getById(int id) {
        return mealRepository.getById(id);
    }
}

package com.example.animalsfood.model;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class AnimalFoodRepository {
    AnimalFoodDao dao;
    LiveData<List<AnimalAndFood>> animalsAndFood;
    LiveData<List<Food>> allFood;

    public AnimalFoodRepository(Context context) {
        dao = AnimalsFoodDB.getDatabase(context).getDao();
        animalsAndFood = dao.getAllAnimalsWithFood();
        allFood = dao.getAllFood();
    }

    public LiveData<List<AnimalAndFood>> getAnimalsAndFood() {
        return animalsAndFood;
    }

    public LiveData<List<Food>> getAllFood() {
        return allFood;
    }

    public void insertAnimal(Animal animal) {
        new InsertAnimalAsync(dao).execute(animal);
    }

    public void insertFood(Food food) {
        new InsertFoodAsync(dao).execute(food);
    }

    private static class InsertAnimalAsync extends AsyncTask<Animal, Void, Void> {
        private AnimalFoodDao dao;

        InsertAnimalAsync(AnimalFoodDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Animal... animals) {
            dao.insertAnimal(animals[0]);
            return null;
        }
    }

    private static class InsertFoodAsync extends AsyncTask<Food, Void, Void> {
        private AnimalFoodDao dao;

        InsertFoodAsync(AnimalFoodDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Food... food) {
            dao.insertFood(food[0]);
            return null;
        }
    }
}

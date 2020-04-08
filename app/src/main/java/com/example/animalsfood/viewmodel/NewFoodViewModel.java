package com.example.animalsfood.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.example.animalsfood.model.AnimalFoodRepository;
import com.example.animalsfood.model.Food;

public class NewFoodViewModel extends AndroidViewModel {
    private AnimalFoodRepository repository;

    public NewFoodViewModel(@NonNull Application application) {
        super(application);
        repository = new AnimalFoodRepository(application);
    }

    public void insertFood(Food food) {
        repository.insertFood(food);
    }
}

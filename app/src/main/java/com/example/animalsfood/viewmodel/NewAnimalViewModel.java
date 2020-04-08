package com.example.animalsfood.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.animalsfood.model.Animal;
import com.example.animalsfood.model.AnimalFoodRepository;
import com.example.animalsfood.model.Food;

import java.util.List;

public class NewAnimalViewModel extends AndroidViewModel {
    private AnimalFoodRepository repository;
    private LiveData<List<Food>> allFood;

    public NewAnimalViewModel(@NonNull Application application) {
        super(application);
        repository = new AnimalFoodRepository(application);
        allFood = repository.getAllFood();
    }

    public LiveData<List<Food>> getAllFood() {
        return allFood;
    }

    public void insertAnimal(Animal animal) {
        repository.insertAnimal(animal);
    }
}

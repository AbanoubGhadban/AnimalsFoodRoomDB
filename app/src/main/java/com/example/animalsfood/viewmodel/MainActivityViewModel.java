package com.example.animalsfood.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.animalsfood.model.AnimalAndFood;
import com.example.animalsfood.model.AnimalFoodRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private AnimalFoodRepository repository;
    private LiveData<List<AnimalAndFood>> animalsAndFood;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        repository = new AnimalFoodRepository(application);
        animalsAndFood = repository.getAnimalsAndFood();
    }

    public LiveData<List<AnimalAndFood>> getAnimalsAndFood() {
        return animalsAndFood;
    }
}

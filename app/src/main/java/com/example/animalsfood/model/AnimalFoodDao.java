package com.example.animalsfood.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface AnimalFoodDao {
    @Transaction
    @Query("SELECT * FROM Animal")
    LiveData<List<AnimalAndFood>> getAllAnimalsWithFood();

    @Query("SELECT * FROM Food")
    LiveData<List<Food>> getAllFood();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAnimal(Animal animal);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFood(Food food);

    @Query("DELETE FROM Animal")
    void deleteAllAnimals();

    @Query("DELETE FROM Food")
    void deleteAllFood();
}

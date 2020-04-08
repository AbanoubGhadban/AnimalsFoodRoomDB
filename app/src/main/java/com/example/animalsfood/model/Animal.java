package com.example.animalsfood.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Animal {
    @PrimaryKey(autoGenerate = true)
    public long animalId;
    public String name;
    public long favFoodId;

    @Ignore
    public Animal(String name, long favFoodId) {
        this.name = name;
        this.favFoodId = favFoodId;
    }

    public Animal(long animalId, String name, long favFoodId) {
        this.animalId = animalId;
        this.name = name;
        this.favFoodId = favFoodId;
    }
}

package com.example.animalsfood.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Food {
    @PrimaryKey (autoGenerate = true)
    public long foodId;
    public String name;

    public Food(long foodId, String name) {
        this.foodId = foodId;
        this.name = name;
    }

    @Ignore
    public Food(String name) {
        this.name = name;
    }
}

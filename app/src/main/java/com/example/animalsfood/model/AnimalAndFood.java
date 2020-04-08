package com.example.animalsfood.model;

import androidx.room.Embedded;
import androidx.room.Relation;

public class AnimalAndFood {
    @Embedded public Animal animal;
    @Relation(
            parentColumn = "favFoodId",
            entityColumn = "foodId"
    )
    public Food favoriteFood;
}

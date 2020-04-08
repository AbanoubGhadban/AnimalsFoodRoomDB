package com.example.animalsfood.model;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Animal.class, Food.class}, version = 1)
public abstract class AnimalsFoodDB extends RoomDatabase {
    static AnimalsFoodDB INSTANCE;
    public abstract AnimalFoodDao getDao();

    public static AnimalsFoodDB getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (AnimalsFoodDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AnimalsFoodDB.class, "animal_food_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(populateDBCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback populateDBCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDBAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDBAsync extends AsyncTask<Void, Void, Void> {
        private AnimalFoodDao dao;

        PopulateDBAsync(AnimalsFoodDB db) {
            this.dao = db.getDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAllAnimals();
            dao.deleteAllFood();

            dao.insertFood(new Food(1, "Grass"));
            dao.insertFood(new Food(2, "Clover"));
            dao.insertFood(new Food(3, "Corn"));
            dao.insertFood(new Food(4, "Barley"));
            dao.insertFood(new Food(5, "Milk"));

            dao.insertAnimal(new Animal(1, "Cow", 2));
            dao.insertAnimal(new Animal(2, "Buffalo", 1));
            dao.insertAnimal(new Animal(3, "Sheep", 3));
            dao.insertAnimal(new Animal(4, "Goat", 2));
            dao.insertAnimal(new Animal(5, "Giraffe", 4));
            dao.insertAnimal(new Animal(6, "Cat", 5));
            return null;
        }
    }
}

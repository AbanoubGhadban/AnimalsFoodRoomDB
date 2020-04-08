package com.example.animalsfood.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.animalsfood.R;
import com.example.animalsfood.model.Animal;
import com.example.animalsfood.model.Food;
import com.example.animalsfood.viewmodel.NewAnimalViewModel;

import java.util.List;

public class NewAnimalActivity extends AppCompatActivity {
    Spinner foodSpinner;
    EditText tvAnimalName;
    NewAnimalViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_animal);

        tvAnimalName = findViewById(R.id.tv_animal_name);
        foodSpinner = findViewById(R.id.food_spinner);
        final FoodListAdapter adapter = new FoodListAdapter(this);
        foodSpinner.setAdapter(adapter);

        viewModel = ViewModelProviders.of(this).get(NewAnimalViewModel.class);
        viewModel.getAllFood().observe(this, new Observer<List<Food>>() {
            @Override
            public void onChanged(List<Food> foods) {
                adapter.setData(foods);
            }
        });
    }

    public void onSave(View view) {
        String animalName = tvAnimalName.getText().toString().trim();
        if (animalName.length() == 0 || foodSpinner.getSelectedItem() == null)
            return;
        
        Food selectedFood = (Food) foodSpinner.getSelectedItem();
        Animal animal = new Animal(animalName, selectedFood.foodId);
        viewModel.insertAnimal(animal);
        finish();
    }

    public void onCancel(View view) {
        finish();
    }
}

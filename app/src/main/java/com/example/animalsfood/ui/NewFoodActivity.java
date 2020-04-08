package com.example.animalsfood.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.animalsfood.R;
import com.example.animalsfood.model.Animal;
import com.example.animalsfood.model.Food;
import com.example.animalsfood.viewmodel.NewFoodViewModel;

public class NewFoodActivity extends AppCompatActivity {
    NewFoodViewModel viewModel;
    EditText tvAnimalName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_food);

        viewModel = ViewModelProviders.of(this).get(NewFoodViewModel.class);
        tvAnimalName = findViewById(R.id.tv_animal_name);
    }

    public void onSave(View view) {
        String foodName = tvAnimalName.getText().toString().trim();
        if (foodName.length() == 0)
            return;

        Food food = new Food(foodName);
        viewModel.insertFood(food);
        finish();
    }

    public void onCancel(View view) {
        finish();
    }
}

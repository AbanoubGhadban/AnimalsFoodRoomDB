package com.example.animalsfood.ui;

import android.content.Intent;
import android.os.Bundle;

import com.example.animalsfood.model.AnimalAndFood;
import com.example.animalsfood.viewmodel.MainActivityViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.example.animalsfood.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final AnimalFoodListAdapter adapter = new AnimalFoodListAdapter(getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        viewModel.getAnimalsAndFood().observe(this, new Observer<List<AnimalAndFood>>() {
            @Override
            public void onChanged(List<AnimalAndFood> animalAndFoods) {
                adapter.setData(animalAndFoods);
            }
        });
    }

    public void onNewAnimalClicked(View view) {
        Intent intent = new Intent(this, NewAnimalActivity.class);
        startActivity(intent);
    }

    public void onNewFoodClicked(View view) {
        Intent intent = new Intent(this, NewFoodActivity.class);
        startActivity(intent);
    }
}

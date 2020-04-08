package com.example.animalsfood.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animalsfood.R;
import com.example.animalsfood.model.AnimalAndFood;

import java.util.List;

public class AnimalFoodListAdapter extends RecyclerView.Adapter<AnimalFoodListAdapter.AnimalFoodViewHolder> {
    LayoutInflater inflater;
    List<AnimalAndFood> list;

    AnimalFoodListAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public AnimalFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recyclerview_item, parent, false);
        return new AnimalFoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalFoodViewHolder holder, int position) {
        if (list != null) {
            AnimalAndFood current = list.get(position);
            holder.tvAnimalName.setText(current.animal.name);
            holder.tvFavoriteFood.setText(current.favoriteFood.name);
        } else {
            holder.tvAnimalName.setText("Animal not found");
            holder.tvFavoriteFood.setText("");
        }
    }

    @Override
    public int getItemCount() {
        return list != null? list.size() : 0;
    }

    void setData(List<AnimalAndFood> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    static class AnimalFoodViewHolder extends RecyclerView.ViewHolder {
        TextView tvAnimalName;
        TextView tvFavoriteFood;

        public AnimalFoodViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAnimalName = itemView.findViewById(R.id.tv_animal_name);
            tvFavoriteFood = itemView.findViewById(R.id.tv_fav_food);
        }
    }
}

package com.example.animalsfood.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.animalsfood.R;
import com.example.animalsfood.model.Food;

import java.util.List;

public class FoodListAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<Food> list;

    FoodListAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list != null? list.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        Food current = list.get(position);
        TextView textView = convertView.findViewById(android.R.id.text1);
        textView.setText(current.name);
        return convertView;
    }

    void setData(List<Food> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}

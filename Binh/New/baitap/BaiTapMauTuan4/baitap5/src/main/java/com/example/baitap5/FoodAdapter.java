package com.example.baitap5;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Food> data;

    public FoodAdapter(Context context, ArrayList<Food> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return data.indexOf(getItem(i));
    }
    static class ViewHolderFood{
        ImageView imageView;
        TextView textView;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row = view;
        ViewHolderFood holder;

        if(row == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(R.layout.list_food, viewGroup, false);
            holder = new ViewHolderFood();
            holder.imageView = row.findViewById(R.id.imageViewFood);
            holder.textView = row.findViewById(R.id.textViewFood);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolderFood) row.getTag();
        }

        Food food = data.get(i);
        holder.imageView.setImageResource(food.getImageFood());
        holder.textView.setText(food.getNameFood());

        return row;
    }
}

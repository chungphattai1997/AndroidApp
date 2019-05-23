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

public class DrinkAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Drink> data;

    public DrinkAdapter(Context context, ArrayList<Drink> data) {
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

    static class ViewHolder{
        ImageView imageView;
        TextView textView;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row = view;
        ViewHolder holder;

        if(row == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(R.layout.list_drink, viewGroup, false);
            holder = new ViewHolder();
            holder.imageView = row.findViewById(R.id.imageViewDrink);
            holder.textView = row.findViewById(R.id.textViewDrink);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        Drink drink = data.get(i);
        holder.imageView.setImageResource(drink.getImageDrink());
        holder.textView.setText(drink.getNameDrink());

        return row;
    }
}

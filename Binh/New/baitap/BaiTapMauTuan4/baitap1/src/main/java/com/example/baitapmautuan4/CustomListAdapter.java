package com.example.baitapmautuan4;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomListAdapter extends ArrayAdapter<Country> {
    ArrayList<Country> data = null;
    private int layoutInflaterId;
    private Context context;

    public CustomListAdapter(Context context, int layoutInflaterId, ArrayList<Country> listData) {
        super(context, layoutInflaterId, listData);
        this.data = listData;
        this.layoutInflaterId = layoutInflaterId;
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutInflaterId, parent, false);
            holder = new ViewHolder();
            holder.flagView = (ImageView) row.findViewById(R.id.imageView);
            holder.countryNameView = (TextView) row.findViewById(R.id.textViewName);
            holder.populationView = (TextView) row.findViewById(R.id.textViewPopu);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        Country country = data.get(position);
        holder.countryNameView.setText(country.name);
        holder.populationView.setText("Population: " + country.population);
        holder.flagView.setImageResource(country.imageID);

        return row;
    }

    static class ViewHolder {
        ImageView flagView;
        TextView countryNameView;
        TextView populationView;
    }
}

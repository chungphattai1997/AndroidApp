package com.example.batap3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FootballLegendAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<FootballLegend> data = null;

    public FootballLegendAdapter(Context context, ArrayList<FootballLegend> data) {
        this.context = context;
        this.data = data;
    }

    static class ViewHolder{
        ImageView avatar;
        TextView name;
        TextView age;
        ImageView flag;
    }

    @Override
    public int getCount() {
        return this.data.size();
    }

    @Override
    public Object getItem(int i) {
        return this.data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return this.data.indexOf(getItem(i));
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row = view;
        ViewHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(R.layout.list_legends, viewGroup, false);
            holder = new ViewHolder();
            holder.avatar =  row.findViewById(R.id.imageViewAvatar);
            holder.name =  row.findViewById(R.id.textViewName);
            holder.age =  row.findViewById(R.id.textViewAge);
            holder.flag = row.findViewById(R.id.imageViewFlag);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        FootballLegend legend = data.get(i);
        holder.avatar.setImageResource(legend.getAvatar());
        holder.name.setText(legend.getName());
        holder.age.setText(legend.getBorn());
        holder.flag.setImageResource(legend.getFlag());

        return row;
    }
}

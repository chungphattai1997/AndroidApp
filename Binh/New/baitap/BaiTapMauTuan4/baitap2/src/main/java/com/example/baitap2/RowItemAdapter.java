package com.example.baitap2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RowItemAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<RowItem> data = null;

    public RowItemAdapter(Context context, ArrayList<RowItem> data) {
        this.context = context;
        this.data = data;
    }


    static class ViewHolder{
        ImageView imageView;
        TextView textViewTitle;
        TextView textViewDetail;
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

    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;
        ViewHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.imageView = (ImageView) row.findViewById(R.id.imageView);
            holder.textViewTitle = (TextView) row.findViewById(R.id.textViewTitle);
            holder.textViewDetail = (TextView) row.findViewById(R.id.textViewDetail);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        RowItem country = data.get(position);
        holder.imageView.setImageResource(country.getIcon());
        holder.textViewTitle.setText(country.getTitle());
        holder.textViewDetail.setText(country.getDetail());

        return row;
    }
}

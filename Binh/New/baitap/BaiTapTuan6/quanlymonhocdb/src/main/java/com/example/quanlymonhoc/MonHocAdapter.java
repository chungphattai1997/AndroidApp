package com.example.quanlymonhoc;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MonHocAdapter extends BaseAdapter {
    Context context;
    ArrayList<MonHoc> data = null;

    public MonHocAdapter(Context context, ArrayList<MonHoc> data) {
        this.context = context;
        this.data = data;
    }

    static class MonHocHolder {
        ImageView img;
        TextView txt1, txt2, txt3;
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

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row = view;
        MonHocHolder holder = null;
        if(row != null)         {
            holder = (MonHocHolder) row.getTag();
        }
        else
        {
            holder = new MonHocHolder();
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(R.layout.list_item, viewGroup, false);

            holder.img = (ImageView) row.findViewById(R.id.imageViewIcon);
            holder.txt1 = (TextView) row.findViewById(R.id.textViewMaMH);
            holder.txt2 = (TextView) row.findViewById(R.id.textViewTenMH);
            holder.txt3 = (TextView) row.findViewById(R.id.textViewSoTiet);

            row.setTag(holder);
        }
        MonHoc mh = data.get(i);

        holder.img.setImageResource(mh.getImg());
        holder.txt1.setText("Mã MH: " + mh.getMa());
        holder.txt2.setText("Tên MH: " + mh.getTen());
        holder.txt3.setText("Số Tiết: " + mh.getSotiet());

        return row;
    }
}

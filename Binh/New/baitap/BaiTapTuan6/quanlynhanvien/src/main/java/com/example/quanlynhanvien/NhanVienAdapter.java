package com.example.quanlynhanvien;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class NhanVienAdapter extends BaseAdapter {
    Context context;
    ArrayList<NhanVien> data=null;

    public NhanVienAdapter(Context context, ArrayList<NhanVien> data) {
        this.context = context;
        this.data = data;
    }
    static class ViewHolder{
        ImageView imageView;
        TextView textView;
        CheckBox checkBox;
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
        ViewHolder holder;

        if(row == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(R.layout.list_nv, viewGroup, false);
            holder = new ViewHolder();
            holder.imageView = row.findViewById(R.id.imageViewGT);
            holder.textView = row.findViewById(R.id.textViewTen);
            holder.checkBox = row.findViewById(R.id.checkBoxDelete);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        NhanVien nhanVien = data.get(i);
        holder.imageView.setImageResource(nhanVien.getGioiTinh());
        holder.textView.setText(nhanVien.getMaNV()+ " - " + nhanVien.getTenNV());

        return row;
    }
}

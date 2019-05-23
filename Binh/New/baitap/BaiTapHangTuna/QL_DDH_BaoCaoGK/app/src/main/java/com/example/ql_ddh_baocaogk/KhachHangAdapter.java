package com.example.ql_ddh_baocaogk;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class KhachHangAdapter extends BaseAdapter {
    Context context;
    ArrayList<KhachHang> data = null;

    public KhachHangAdapter(Context context, ArrayList<KhachHang> data) {
        this.context = context;
        this.data = data;
    }

    static class KhachHangHolder {
        TextView txt1, txt2;
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
        KhachHangHolder holder = null;
        if(row != null)         {
            holder = (KhachHangHolder) row.getTag();
        }
        else
        {
            holder = new KhachHangHolder();
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(R.layout.list_item, viewGroup, false);

            holder.txt1 = (TextView) row.findViewById(R.id.textViewMaMH);
            holder.txt2 = (TextView) row.findViewById(R.id.textViewTenMH);

            row.setTag(holder);
        }
        KhachHang kh = data.get(i);

        holder.txt1.setText("Mã MH: " + kh.getMa());
        holder.txt2.setText("Tên MH: " + kh.getTen());

        return row;
    }




}

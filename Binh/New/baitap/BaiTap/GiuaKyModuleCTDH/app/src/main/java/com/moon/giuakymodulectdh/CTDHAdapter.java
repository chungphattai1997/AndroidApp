package com.moon.giuakymodulectdh;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CTDHAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<CT_DonHang> data;

    public CTDHAdapter(Context context, ArrayList<CT_DonHang> data) {
        this.context = context;
        this.data = data;
    }
    static class CTDonDHHolder {
        TextView soDDH, maMH, slDat;
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
        CTDonDHHolder holder = null;
        if(row != null)         {
            holder = (CTDonDHHolder) row.getTag();
        }
        else
        {
            holder = new CTDonDHHolder();
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(R.layout.activity_list_ctdh, viewGroup, false);

            holder.soDDH = row.findViewById(R.id.textViewSoDDHCT);
            holder.maMH = row.findViewById(R.id.textViewMaHGCT);
            holder.slDat = row.findViewById(R.id.textViewSLDATCT);

            row.setTag(holder);
        }
        CT_DonHang ct_donHang = data.get(i);

        holder.soDDH.setText(String.valueOf(ct_donHang.getSODDH()));
        holder.maMH.setText(ct_donHang.getMAHG());
        holder.slDat.setText(String.valueOf(ct_donHang.getSLDAT()));

        return row;
    }
}

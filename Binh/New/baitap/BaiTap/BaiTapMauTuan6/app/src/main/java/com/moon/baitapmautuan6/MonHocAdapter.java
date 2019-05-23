package com.moon.baitapmautuan6;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MonHocAdapter extends RecyclerView.Adapter<MonHocAdapter.ViewHolder> {
    private Context context;
    private ArrayList<MonHoc> monHocArrayList;

    public MonHocAdapter(Context context, ArrayList<MonHoc> monHocArrayList) {
        this.context = context;
        this.monHocArrayList = monHocArrayList;
    }

    @NonNull
    @Override
    public MonHocAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
        View view=layoutInflater.inflate(R.layout.recycleview_monhoc_itemlist,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    //Truyền dữ liệu vào các control trong layout item.
    public void onBindViewHolder(MonHocAdapter.ViewHolder viewHolder, int i) {
        MonHoc monHoc = monHocArrayList.get(i);
        viewHolder.imgMonHoc.setImageResource(monHoc.getImgMonHoc());
        viewHolder.tvTen.setText("Tên MH: "+String.valueOf(monHoc.getsTen()));
        viewHolder.tvMaMH.setText("Mã MH: "+String.valueOf(monHoc.getsMaMH()));
        viewHolder.tvSoTiet.setText("Số tiết: "+String.valueOf(monHoc.getiSoTiet()));
    }

    @Override
    public int getItemCount() {
        return monHocArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgMonHoc;
        private TextView tvTen;
        private  TextView tvMaMH;
        private  TextView tvSoTiet;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMonHoc =itemView.findViewById(R.id.imgMonHoc);
            tvTen =itemView.findViewById(R.id.tvTen);
            tvMaMH=itemView.findViewById(R.id.tvMaMH);
            tvSoTiet =itemView.findViewById(R.id.tvSoTiet);
        }
    }
}

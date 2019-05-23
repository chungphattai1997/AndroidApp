package com.myour.quanlidonhanggiuaki;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MatHangAdapter extends RecyclerView.Adapter<MatHangAdapter.ViewHolder>{
    private MatHangActivity context;
    private ArrayList<MatHang> matHangArrayList;
    public int vitri=-1;

    public MatHangAdapter(MatHangActivity context, ArrayList<MatHang> matHangArrayList) {
        this.context = context;
        this.matHangArrayList = matHangArrayList;
    }


    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
        View itemView=layoutInflater.inflate(R.layout.item_mat_hang,viewGroup,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        MatHang matHang=matHangArrayList.get(i);
        viewHolder.tvMaHG.setText(String.valueOf(matHang.getMaHG()));
        viewHolder.tvTenHG.setText("Tên: "+String.valueOf(matHang.getTenHG()));
        viewHolder.tvDonGia.setText("Đơn giá: "+String.valueOf(matHang.getDonGia()));
        viewHolder.tvDVT.setText("- Đơn vị tính: "+String.valueOf(matHang.getDvt()));
        viewHolder.tvDacDiem.setText("Đặc điểm: "+String.valueOf(matHang.getDacDiem()));

        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                context.showDialogMatHang(i);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return matHangArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvMaHG, tvTenHG, tvDonGia, tvDVT, tvDacDiem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMaHG=itemView.findViewById(R.id.textviewMaHG);
            tvTenHG=itemView.findViewById(R.id.textviewTenHG);
            tvDonGia=itemView.findViewById(R.id.textviewDonGia);
            tvDacDiem=itemView.findViewById(R.id.textviewDacDiem);
            tvDVT=itemView.findViewById(R.id.textviewDonViTinh);
        }
    }
}

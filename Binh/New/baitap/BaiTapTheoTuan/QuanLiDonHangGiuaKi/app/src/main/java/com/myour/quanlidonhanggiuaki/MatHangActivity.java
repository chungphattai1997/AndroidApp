package com.myour.quanlidonhanggiuaki;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MatHangActivity extends AppCompatActivity {
    private RecyclerView recViewMatHang;
    private ArrayList<MatHang> matHangArrayList=new ArrayList<>();
    private MatHangAdapter matHangAdapter=new MatHangAdapter(this,matHangArrayList);
    private DatabaseQLDH dbqldh =new DatabaseQLDH(this);
    //dialogThemMatHang
    private EditText edtMaThem, edtTenThem, edtDVTThem, edtDonGiaThem, edtDacDiemThem;
    private Button btnXacNhanThem, btnHuyThem;
    //dialogMatHang
    private TextView tvMatHang;
    private Button btnSua, btnXoa;
    //dialogSuaMatHang
    private EditText edtMaSua, edtTenSua, edtDVTSua, edtDonGiaSua, edtDacDiemSua;
    private Button btnXacNhanSua, btnHuySua;

    private MatHang matHang=new MatHang();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mat_hang);

        setControl();

        recViewMatHang.setAdapter(matHangAdapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recViewMatHang.setLayoutManager(layoutManager);
        loadDB();

        setEvent();
    }

    private void setEvent() {
    }
    public void showDialogMatHang(int position) {
        Dialog dialog=new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_mat_hang);

        setControlDialogMatHang(dialog);

        matHang=matHangArrayList.get(position);
        tvMatHang.setText("Mặt hàng:\n"+matHang.getMaHG()+" - "+matHang.getTenHG());

        setEventDialogMatHang(dialog, position);
        dialog.show();
    }

    private void setEventDialogMatHang(final Dialog dialog, final int position) {
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDiaLogSuaMatHang(position);
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog=new AlertDialog.Builder(MatHangActivity.this);
                alertDialog.setTitle("Xác nhận!");
                alertDialog.setIcon(R.mipmap.ic_launcher);
                alertDialog.setMessage("Mặt hàng "+matHang.getTenHG()+" sẽ bị xóa, bạn có chắc?");
                alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finishAffinity();
                    }
                });
                alertDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alertDialog.show();
            }
        });
    }

    private void showDiaLogSuaMatHang(int position) {
        Dialog dialog=new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_sua_mat_hang);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        setControlDialogSuaMatHang(dialog);

        MatHang matHang=matHangArrayList.get(position);
        edtMaSua.setHint(matHang.getMaHG());
        edtTenSua.setHint(matHang.getTenHG());
        edtDVTSua.setHint(matHang.getDvt());
        edtDonGiaSua.setHint(String.valueOf(matHang.getDonGia()));
        edtDacDiemSua.setHint(matHang.getDacDiem());

        setEventDialogSuaMatHang(dialog);

        dialog.show();
    }

    private void setEventDialogSuaMatHang(final Dialog dialog) {
        btnHuySua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    private void setControlDialogSuaMatHang(Dialog dialog) {
        edtMaSua =dialog.findViewById(R.id.edittextMa);
        edtTenSua =dialog.findViewById(R.id.edittextTen);
        edtDVTSua =dialog.findViewById(R.id.edittextDonViTinh);
        edtDonGiaSua =dialog.findViewById(R.id.edittextDonGia);
        edtDacDiemSua =dialog.findViewById(R.id.edittextDacDiem);
        btnXacNhanSua =dialog.findViewById(R.id.buttonXacNhan);
        btnHuySua =dialog.findViewById(R.id.buttonHuy);
    }


    private void setControlDialogMatHang(Dialog dialog) {
        tvMatHang =dialog.findViewById(R.id.textviewMatHang);
        btnSua=dialog.findViewById(R.id.buttonSua);
        btnXoa=dialog.findViewById(R.id.buttonXoa);
    }

    private void setControl() {
        recViewMatHang=findViewById(R.id.recyclerviewMatHang);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_mat_hang,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuThem :
                showDialogThemMatHang();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void showDialogThemMatHang(){
        Dialog dialog=new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_them_mat_hang);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        setControlDialogThemMatHang(dialog);

        setEventDialogThemMatHang(dialog);

        dialog.show();
    }

    private void setEventDialogThemMatHang(final Dialog dialog) {
        btnXacNhanThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickBtnXacNhan(v);
            }
        });
        btnHuyThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    private void onClickBtnXacNhan(View v) {
        String ma= edtMaThem.getText().toString().trim();
        String ten= edtTenThem.getText().toString().trim();
        String dvt= edtDVTThem.getText().toString().trim();
        String donGia= edtDonGiaThem.getText().toString().trim();
        String dacDiem= edtDacDiemThem.getText().toString().trim();
        if (ma.equals("") || ten.equals("") || dvt.equals("") || donGia.equals("")){
            Toast.makeText(this, "Vui lòng nhập đủ các thông tin!", Toast.LENGTH_SHORT).show();
            edtMaThem.requestFocus();
        } else if(kiemTraKhoaChinh(ma)){
            Toast.makeText(this, "Mặt hàng có mã: "+ma+" đã tồn tại!", Toast.LENGTH_SHORT).show();
            edtMaThem.requestFocus();
        } else{
            String sql="INSERT INTO MATHANG VALUES('"+ma+"','"+ten+"','"+dacDiem+"','"+dvt+"',"+ Integer.parseInt(donGia) +")";
            dbqldh.queryDataSQL(sql);
            Toast.makeText(this, "Đã thêm!", Toast.LENGTH_SHORT).show();
            loadDB();
            edtMaThem.setText(""); edtTenThem.setText(""); edtDacDiemThem.setText(""); edtDVTThem.setText(""); edtDonGiaThem.setText("");
            edtMaThem.requestFocus();
        }
    }

    private boolean kiemTraKhoaChinh(String pk) {
        String sql="SELECT MAHG FROM MATHANG WHERE MAHG='"+pk+"'";
        Cursor cursor= dbqldh.queryGetDataSQL(sql);
        if(cursor.moveToNext()){
            return true;
        }else return false;
    }

    private void loadDB() {
        matHangArrayList.clear();
        Cursor cursor = dbqldh.queryGetDataSQL("SELECT * FROM MATHANG");
        if (cursor.moveToFirst()) {
            do {
                String ma = cursor.getString(0);
                String ten = cursor.getString(1);
                String dacDiem=cursor.getString(2);
                String dvt=cursor.getString(3);
                int donGia=cursor.getInt(4);
                matHangArrayList.add(new MatHang(ma, ten, dacDiem, dvt, donGia));
            } while (cursor.moveToNext());
            matHangAdapter.notifyDataSetChanged();
        }
        cursor.close();
    }

    private void setControlDialogThemMatHang(Dialog dialog) {
        edtMaThem =dialog.findViewById(R.id.edittextMa);
        edtTenThem =dialog.findViewById(R.id.edittextTen);
        edtDVTThem =dialog.findViewById(R.id.edittextDonViTinh);
        edtDonGiaThem =dialog.findViewById(R.id.edittextDonGia);
        edtDacDiemThem =dialog.findViewById(R.id.edittextDacDiem);
        btnXacNhanThem =dialog.findViewById(R.id.buttonXacNhan);
        btnHuyThem =dialog.findViewById(R.id.buttonHuy);
    }
}

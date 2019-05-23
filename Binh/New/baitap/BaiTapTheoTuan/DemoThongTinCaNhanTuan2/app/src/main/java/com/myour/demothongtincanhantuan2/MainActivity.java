package com.myour.demothongtincanhantuan2;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText edtTen, edtCMND, edtThongTinBoSung;
    private RadioButton rdbtnTrungCap, rdbtnCaoDang, rdbtnDaiHoc;
    private CheckBox chbDocBao, chbDocSach, chbDocCoding;
    private Button btnGuiThongTin, btnDong;
    private TextView tvThongTin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControl();

        setEvent();
    }

    private void setEvent() {
        btnGuiThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogThongTin();
            }
        });
    }

    private void showDialogThongTin() {
        final Dialog dialog=new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_thong_tin);
//        DisplayMetrics metrics = getResources().getDisplayMetrics();
//        int width = metrics.widthPixels;
//        int height = metrics.heightPixels;
//        dialog.getWindow().setLayout((6 * width)/7, (4 * height)/5);
        dialog.getWindow().setLayout(500,600);

        tvThongTin=dialog.findViewById(R.id.textviewThongTin);
        btnDong=dialog.findViewById(R.id.buttonDong);
        btnDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        tvThongTin.setText(getThongTin());
        dialog.show();
    }

    private String getThongTin() {
        String thongtin="";
        String bangcap="";
        String sothich="";
        if (rdbtnTrungCap.isChecked()) bangcap=rdbtnTrungCap.getText().toString();
        if (rdbtnCaoDang.isChecked()) bangcap=rdbtnCaoDang.getText().toString();
        if (rdbtnDaiHoc.isChecked()) bangcap=rdbtnDaiHoc.getText().toString();
        if (chbDocBao.isChecked()) sothich+="\n"+chbDocBao.getText().toString();
        if (chbDocSach.isChecked()) sothich+="\n"+chbDocSach.getText().toString();
        if (chbDocCoding.isChecked()) sothich+="\n"+chbDocCoding.getText().toString();
        thongtin="Họ tên: "+edtTen.getText().toString().trim()+"\nCMND: "+edtCMND.getText().toString().trim();
        thongtin+="\n"+bangcap+sothich+"\n----------------\nThông tin bổ sung:\n"+edtThongTinBoSung.getText().toString().trim();
        return thongtin;
    }

    private void setControl() {
        edtTen=findViewById(R.id.edittextTen);
        edtCMND=findViewById(R.id.edittextCMND);
        edtThongTinBoSung=findViewById(R.id.edittextThongTinBoSung);
        rdbtnTrungCap=findViewById(R.id.rdbtnTrungCap);
        rdbtnCaoDang=findViewById(R.id.rdbtnCaoDang);
        rdbtnDaiHoc=findViewById(R.id.rdbtnDaiHoc);
        chbDocBao=findViewById(R.id.chbDocBao);
        chbDocSach=findViewById(R.id.chbDocSach);
        chbDocCoding=findViewById(R.id.chbDocCoding);
        btnGuiThongTin=findViewById(R.id.buttonGuiThongTin);
    }
}

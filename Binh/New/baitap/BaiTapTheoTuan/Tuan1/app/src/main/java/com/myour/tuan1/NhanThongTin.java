package com.myour.tuan1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NhanThongTin extends AppCompatActivity {
    //SetControl
    TextView tvThongTin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actv_nhan_thong_tin);
        //lấy thông tin
        Intent intent=getIntent();
        tvThongTin = findViewById(R.id.tvNhanThongTin);
        //Intent intent =new Intent(Intent.ACTION_SCREEN_ON);
        String msg=intent.getStringExtra("msg");
        tvThongTin.setText(msg);
    }
}

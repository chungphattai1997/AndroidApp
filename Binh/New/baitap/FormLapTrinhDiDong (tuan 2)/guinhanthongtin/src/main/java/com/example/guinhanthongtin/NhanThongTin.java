package com.example.guinhanthongtin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NhanThongTin extends AppCompatActivity implements View.OnClickListener {
    TextView textViewNhan;
    Button btnThoat;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_thong_tin);
        setControl();
    }
    private void setControl(){
        textViewNhan = (TextView) findViewById(R.id.textViewNhan);
        btnThoat = (Button) findViewById(R.id.btnThoat);
        Intent intent = getIntent();
        String msg = intent.getStringExtra("msg");
        textViewNhan.setText(msg);
        btnThoat.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}

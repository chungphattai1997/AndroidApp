package com.example.tuan1test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class GuiThongTin extends AppCompatActivity {
    EditText txtThongTin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtThongTin = findViewById(R.id.txtThongTin);
    }

    public void clickGuiThongTin(View view) {
        Toast.makeText(this, "gửi thông tin", Toast.LENGTH_SHORT).show();
        Log.d("test", "gửi thông tin");

        Intent intent = new Intent(this, NhanThongTin.class);
        intent.putExtra("msg", txtThongTin.getText().toString());
        startActivity(intent);

    }
}




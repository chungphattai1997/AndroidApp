package com.example.calculator_thuchang2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txtSoA, txtSoB, txtKetQuaOk;
    Button btnCong, btnTru, btnNhan, btnChia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setConTrol();
        setEvent();
    }

    private void setConTrol(){
        txtSoA = findViewById(R.id.txtA);
        txtSoB = findViewById(R.id.txtB);
        txtKetQuaOk = findViewById(R.id.txtKetQua);

        btnCong = findViewById(R.id.congBtn);
        btnTru = findViewById(R.id.truBtn);
        btnNhan = findViewById(R.id.nhanBtn);
        btnChia = findViewById(R.id.chiaBtn);
    }

    private  void setEvent(){
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pheptinh("+");
            }
        });

        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pheptinh("-");
            }
        });

        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pheptinh("*");
            }
        });

        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pheptinh("/");
            }
        });
    }

    private void pheptinh(String pt){
        int soA = Integer.parseInt(txtSoA.getText().toString());
        int soB = Integer.parseInt(txtSoB.getText().toString());
        int kq = 0;

        switch (pt){
            case "+":
                kq = soA + soB;
                break;
            case "-":
                kq = soA - soB;
                break;
            case "*":
                kq = soA * soB;
                break;
            case "/":
                kq = soA / soB;
                break;
        }

        txtKetQuaOk.setText(String.valueOf(kq));

    }
}

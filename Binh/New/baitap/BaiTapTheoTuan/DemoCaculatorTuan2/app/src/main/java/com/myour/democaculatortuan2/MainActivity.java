package com.myour.democaculatortuan2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtSoA, edtSoB;
    private Button btnCong, btnTru, btnNhan, btnChia;
    private TextView tvKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControl();

        setEvent();
    }

    private void setEvent() {
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Kết quả cộng!", Toast.LENGTH_SHORT).show();
                tvKetQua.setText(String.valueOf(tinh("+")));
            }
        });
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Kết quả trừ!", Toast.LENGTH_SHORT).show();
                tvKetQua.setText(String.valueOf(tinh("-")));
            }
        });
        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Kết quả nhân!", Toast.LENGTH_SHORT).show();
                tvKetQua.setText(String.valueOf(tinh("*")));
            }
        });
        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Kết quả chia!", Toast.LENGTH_SHORT).show();
                tvKetQua.setText(String.valueOf(tinh("/")));
            }
        });
    }

    private int tinh(String pt) {
        int soA=Integer.parseInt(edtSoA.getText().toString());
        int soB=Integer.parseInt(edtSoB.getText().toString());
        int kq=0;
        switch (pt){
            case "+":
                kq=soA+soB;
                break;
            case "-":
                kq=soA-soB;
                break;
            case "*":
                kq=soA*soB;
                break;
            case "/":
                kq=soA/soB;
                break;
        }
        return kq;
    }

    private void setControl() {
        edtSoA=findViewById(R.id.edtSoA);
        edtSoB=findViewById(R.id.edtSoB);
        btnCong=findViewById(R.id.btnCong);
        btnTru=findViewById(R.id.btnTru);
        btnNhan=findViewById(R.id.btnNhan);
        btnChia=findViewById(R.id.btnChia);
        tvKetQua=findViewById(R.id.tvKetQua);
    }
}

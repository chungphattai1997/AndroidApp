package com.example.formlaptrinhdidong;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnCong , btnTru , btnNhan , btnChia ;

    private EditText editTextA , editTextB , editTextKetQua ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setConTrol();
    }
    private void setConTrol(){
        btnCong = (Button) findViewById(R.id.btnCong);
        btnTru = (Button) findViewById(R.id.btnTru);
        btnNhan = (Button) findViewById(R.id.btnNhan);
        btnChia = (Button) findViewById(R.id.btnChia);

        editTextA = (EditText) findViewById(R.id.editTextA);
        editTextB = (EditText) findViewById(R.id.editTextB);
        editTextKetQua = (EditText) findViewById(R.id.editTextKetQua);

        btnCong.setOnClickListener(this);
        btnTru.setOnClickListener(this);
        btnNhan.setOnClickListener(this);
        btnChia.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int soA = Integer.parseInt(editTextA.getText().toString().trim());
        int soB = Integer.parseInt(editTextB.getText().toString().trim());
        float kq = 0;
        switch (view.getId()){
            case R.id.btnCong:
                kq = soA + soB;
                break;
            case R.id.btnTru:
                kq = soA - soB;
                break;
            case R.id.btnNhan:
                kq = soA * soB;
                break;
            case R.id.btnChia:
                kq = (float) soA / soB;
                break;
        }
        editTextKetQua.setText(String.valueOf(kq));
    }
}

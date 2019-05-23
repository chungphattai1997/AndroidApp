package com.example.apptracnghiem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity implements View.OnClickListener {

    Button btnLui, btnTien, btnResult;
    RadioButton radioDong, radioTay, radioNam, radioBac;
    public int dem = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        setControll();
    }
    void setControll(){
        btnLui = (Button) findViewById(R.id.btnLui);
        btnTien = (Button) findViewById(R.id.btnTien);
        btnResult = (Button) findViewById(R.id.btnResult);
        radioDong = (RadioButton) findViewById(R.id.radioDong);
        radioTay = (RadioButton) findViewById(R.id.radioTay);
        radioNam = (RadioButton) findViewById(R.id.radioNam);
        radioBac = (RadioButton) findViewById(R.id.radioBac);

        btnLui.setText("<");
        btnTien.setText(">");

        btnLui.setOnClickListener(this);
        btnTien.setOnClickListener(this);
        btnResult.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.btnLui:
                intent = new Intent(this, Activity6.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
                break;
            case R.id.btnResult:
                intent = new Intent(this, Activity7.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                if(radioDong.isChecked()) dem ++;
                startActivity(intent);
                break;

            case R.id.btnTien:
                intent = new Intent(this, Activity3.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
                break;
        }
    }
}

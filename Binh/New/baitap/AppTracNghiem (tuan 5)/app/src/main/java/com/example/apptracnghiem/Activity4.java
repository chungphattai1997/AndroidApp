package com.example.apptracnghiem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class Activity4 extends AppCompatActivity implements View.OnClickListener {
    Button btnLui, btnTien, btnResult;
    Spinner spinner1, spinner2, spinner3;
    public int dem = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        setControll();
    }
    void setControll(){
        btnLui = (Button) findViewById(R.id.btnLui);
        btnTien = (Button) findViewById(R.id.btnTien);
        btnResult = (Button) findViewById(R.id.btnResult);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);


        btnLui.setText("<");
        btnTien.setText(">");

        btnLui.setOnClickListener(this);
        btnTien.setOnClickListener(this);
        btnResult.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnLui:
                intent = new Intent(this, Activity3.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
                break;
            case R.id.btnResult:
                intent = new Intent(this, Activity7.class);

                startActivity(intent);
                break;
            case R.id.btnTien:
                intent = new Intent(this, Activity5.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
                break;
        }
    }
}

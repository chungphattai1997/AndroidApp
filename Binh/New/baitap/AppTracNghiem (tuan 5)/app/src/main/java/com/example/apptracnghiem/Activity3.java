package com.example.apptracnghiem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class Activity3 extends AppCompatActivity implements View.OnClickListener {
    Button btnLui, btnTien, btnResult;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    public int dem = 0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        setControll();
    }
    void setControll(){
        btnLui = (Button) findViewById(R.id.btnLui);
        btnTien = (Button) findViewById(R.id.btnTien);
        btnResult = (Button) findViewById(R.id.btnResult);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkBox4);

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
                intent = new Intent(this, Activity2.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
                break;
            case R.id.btnResult:
                intent = new Intent(this, Activity7.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                if(checkBox1.isChecked()) dem++;
                if(checkBox2.isChecked()) dem++;
                if(checkBox3.isChecked()) dem++;
                startActivity(intent);
                break;
            case R.id.btnTien:
                intent = new Intent(this, Activity4.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
                break;
        }
    }
}

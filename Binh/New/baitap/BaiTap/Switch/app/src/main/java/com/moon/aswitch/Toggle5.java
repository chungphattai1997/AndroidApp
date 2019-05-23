package com.moon.aswitch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Toggle5 extends AppCompatActivity implements View.OnClickListener {

    Button btnPre,btnNext,btnResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle);
        setControl();
    }

    private void setControl() {
        btnNext=(Button)findViewById(R.id.btnNext);
        btnPre=(Button)findViewById(R.id.btnPre);
        btnResult=(Button)findViewById(R.id.btnResult);
        btnPre.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnResult.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case  R.id.btnPre:
                intent=new Intent(this, Spinner4.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
                break;
            case R.id.btnNext:
                intent=new Intent(this,Switch6.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
                break;
        }
    }
}

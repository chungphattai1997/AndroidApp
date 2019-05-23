package com.myour.quanlidonhanggiuaki;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnMatHang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMatHang=findViewById(R.id.buttonMatHang);
        btnMatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickBtnMatHang(v);
            }
        });
    }

    private void clickBtnMatHang(View v) {
        Intent intent=new Intent(this,MatHangActivity.class);
        startActivity(intent);
    }
}

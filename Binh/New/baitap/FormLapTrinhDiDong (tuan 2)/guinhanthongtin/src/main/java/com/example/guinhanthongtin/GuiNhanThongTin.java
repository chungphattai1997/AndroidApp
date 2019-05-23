package com.example.guinhanthongtin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GuiNhanThongTin extends AppCompatActivity implements View.OnClickListener {
    EditText editTextTT;
    Button btnGui;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui_nhan_thong_tin);
        setControl();
    }
    private void setControl(){
        editTextTT = (EditText) findViewById(R.id.editTextTT);
        btnGui = (Button) findViewById(R.id.btnGui);
        btnGui.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "Gửi thông tin", Toast.LENGTH_SHORT).show();
        Log.d("test", "gửi thông tin");
        Intent intent = new Intent(this, NhanThongTin.class);
        intent.putExtra("msg", editTextTT.getText().toString());
        startActivity(intent);
    }
}

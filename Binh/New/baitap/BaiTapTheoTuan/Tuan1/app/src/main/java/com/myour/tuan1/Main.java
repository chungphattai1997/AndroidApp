package com.myour.tuan1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main extends AppCompatActivity {
    EditText txtThongTin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actv_main);
        txtThongTin=findViewById(R.id.txtThongTin);
    }
    public void onGuiThongTin(View view){
        //hiển thị thông báo
        Toast.makeText(this, "Gửi thông tin", Toast.LENGTH_SHORT).show();
        //Log
//        Log.d("test","gửi thông tin");
        //Chuyển màn hình
        Intent intent =new Intent(this,NhanThongTin.class);
        //Lấy dữ liệu và xử lý
        intent.putExtra("msg",txtThongTin.getText().toString());
        startActivity(intent);

        Log.d("test","1. onCreate");
    }
    protected void onStart(){
        super.onStart();
        Log.d("test","2. onStart");
    }
    protected void onResume() {
        super.onResume();
        Log.d("test","3. onResume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("test","4. onPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("test","5. onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("test","6. onDestroy");
    }
}

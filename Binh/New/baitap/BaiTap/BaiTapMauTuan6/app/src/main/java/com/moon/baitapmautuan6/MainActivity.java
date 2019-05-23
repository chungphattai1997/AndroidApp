package com.moon.baitapmautuan6;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTen;
    private  EditText editTextMaMH;
    private  EditText editTextSoTiet;
    private Button btnInsert;
    private  Button btnDelete;
    private  Button btnUpdate;
    private  Button btnLoad;
    private ArrayList<MonHoc> monHocArrayList =new ArrayList<>();
    private MonHocAdapter monhocAdapter;
    private RecyclerView recyclerViewListMonHoc;
    private  int index=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        monhocAdapter =new MonHocAdapter(this, monHocArrayList);
        recyclerViewListMonHoc.setAdapter(monhocAdapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerViewListMonHoc.setLayoutManager(layoutManager);
        setEvent();
    }

    private void setEvent() {
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                monHocArrayList.add(getMonHoc());
                monhocAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Thêm xong rồi đó!", Toast.LENGTH_SHORT).show();
            }
        });
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private MonHoc getMonHoc(){
        MonHoc monHoc =new MonHoc();
        monHoc.setImgMonHoc(R.drawable.ic_launcher_background);
        monHoc.setsTen(editTextTen.getText().toString());
        monHoc.setsMaMH(editTextMaMH.getText().toString());
        monHoc.setiSoTiet((editTextSoTiet.getText().toString()));
        return monHoc;
    }
    private void setControl() {
        editTextTen =findViewById(R.id.editTextTen);
        editTextMaMH=findViewById(R.id.editTextMaMH);
        editTextSoTiet =findViewById(R.id.editTextSoTiet);
        btnInsert=findViewById(R.id.buttonInsert);
        btnDelete=findViewById(R.id.buttonDelete);
        btnUpdate=findViewById(R.id.buttonUpdate);
        btnLoad=findViewById(R.id.buttonLoad);
        recyclerViewListMonHoc =findViewById(R.id.recycleView);
    }
}


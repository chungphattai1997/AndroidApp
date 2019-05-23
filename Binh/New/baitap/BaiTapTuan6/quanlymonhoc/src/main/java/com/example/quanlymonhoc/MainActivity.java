package com.example.quanlymonhoc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    ArrayList<MonHoc> data = new ArrayList<>();

    MonHocAdapter adapter = null;
    Button btnInsert, btnSave;
    EditText editTextMaMH, editTextTenMH, editTextSoTiet;
    static int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControll();
        setEvent();
    }
    void setControll(){
        listView = findViewById(R.id.listView);
        btnInsert = findViewById(R.id.btnDelete);
        btnSave = findViewById(R.id.btnUpdate);
        editTextMaMH = findViewById(R.id.editTextMaMH);
        editTextTenMH = findViewById(R.id.editTextTenMH);
        editTextSoTiet = findViewById(R.id.editTextSoTiet);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //deleteMH();
                saveDB();
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                //updateMH();
                loadDB();
            }
        });
    }
    void saveDB(){
        MyDatabase db = new MyDatabase(this);
        MonHoc monHoc = new MonHoc();
        monHoc.setImg(R.drawable.city);
        monHoc.setMa(editTextMaMH.getText().toString());
        monHoc.setTen(editTextTenMH.getText().toString());
        monHoc.setSotiet(editTextSoTiet.getText().toString());
        db.saveMonHocs(monHoc);
    }
    void loadDB(){
        MyDatabase db = new MyDatabase(this);
        data.clear();
        db.getMonHocS(data);
        adapter.notifyDataSetChanged();
    }
    void setEvent(){
        adapter = new MonHocAdapter(this, data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        MonHoc mh = data.get(i);
        index = i;
        editTextMaMH.setText(mh.getMa());
        editTextTenMH.setText(mh.getTen());
        editTextSoTiet.setText(mh.getSotiet());
    }

}

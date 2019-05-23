package com.example.quanlymonhoc;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    ArrayList<MonHoc> data = new ArrayList<>();

    MonHocAdapter adapter = null;
    Button btnInsert, btnDelete, btnExit, btnUpdate;
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
        btnInsert = findViewById(R.id.btnInsert);
        btnDelete = findViewById(R.id.btnDelete);
        btnExit = findViewById(R.id.btnExit);
        btnUpdate = findViewById(R.id.btnUpdate);
        editTextMaMH = findViewById(R.id.editTextMaMH);
        editTextTenMH = findViewById(R.id.editTextTenMH);
        editTextSoTiet = findViewById(R.id.editTextSoTiet);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertMH();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteMH();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                updateMH();
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
                System.exit(0);
            }
        });
    }
    void khoiTao(){
        data.add(new MonHoc(R.drawable.city,"1", "Công Nghệ", "5"));
    }
    void setEvent(){
        khoiTao();
        adapter = new MonHocAdapter(this, data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }
    private MonHoc getMonHoc() {
        MonHoc monHoc = new MonHoc();
        monHoc.setImg(R.drawable.city);
        monHoc.setMa(editTextMaMH.getText().toString());
        monHoc.setTen(editTextTenMH.getText().toString());
        monHoc.setSotiet(editTextSoTiet.getText().toString());
        return monHoc;
    }
    public void insertMH()   {
        if(data.size()==0) {
            Toast.makeText(this, "Update Không Thành Công!", Toast.LENGTH_SHORT).show();
            return;
        }
        MonHoc monHoc = getMonHoc();
        data.add(monHoc);
        adapter.notifyDataSetChanged();
    }
    public void deleteMH(){

        if(index >= 0) {
            data.remove(index);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Xóa thành công", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "Xóa không thành công", Toast.LENGTH_SHORT).show();


    }
    public void updateMH()
    {
        String ma = editTextMaMH.getText().toString();
        String ten = editTextTenMH.getText().toString();
        String st = editTextSoTiet.getText().toString();

        data.get(index).setMa(ma);
        data.get(index).setTen(ten);
        data.get(index).setSotiet(st);
        Toast.makeText(this, "Update Thành Công!", Toast.LENGTH_SHORT).show();
        adapter.notifyDataSetChanged();
    }

    public void searchMH(){

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

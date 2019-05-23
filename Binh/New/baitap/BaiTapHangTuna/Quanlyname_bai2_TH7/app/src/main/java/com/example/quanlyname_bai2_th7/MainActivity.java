package com.example.quanlyname_bai2_th7;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    ArrayList<KhachHang> data = new ArrayList<>();

    KhachHangAdapter adapter = null;
    Button btnThemOk, btnXoaOk, btnSuaOk, btnTimOk, btnReLoadKH;
    EditText editTextMaKH, editTextTenKH;
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
        btnThemOk = findViewById(R.id.btnThem);
        btnXoaOk = findViewById(R.id.btnXoa);
        btnSuaOk = findViewById(R.id.btnSua);
        btnTimOk = findViewById(R.id.btnTim);
        editTextMaKH = findViewById(R.id.editTextMaKH);
        editTextTenKH = findViewById(R.id.editTextTenKH);
        btnReLoadKH = findViewById(R.id.btnReLoadKH);


        btnReLoadKH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDB();
            }
        });

        btnThemOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveDB();
                loadDB();
            }
        });


        btnXoaOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                xoaKHDB();
                loadDB();
            }
        });


        btnSuaOk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                MyDatabase db = new MyDatabase(MainActivity.this);

                KhachHang khachHang = new KhachHang();
                khachHang.setTen(editTextTenKH.getText().toString());
                khachHang.setMa(editTextMaKH.getText().toString());
                db.updateKhachHang(khachHang);
                loadDB();
            }
        });

        btnTimOk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                MyDatabase db = new MyDatabase(MainActivity.this);
                data.clear();
                KhachHang khachHang = new KhachHang();
                khachHang = db.findKhachHang(editTextMaKH.getText().toString());
                data.add(khachHang);
                adapter.notifyDataSetChanged();


            }
        });
    }

    void checkNull(){
        //TODO: Kiểm tra xem đã nhập đủ MÃ với họ tên chưa mới cho Insert. (Còn trùng mã thì bữa kiểm tra rồi). -->done
        //TODO: EDIT thì không cho sửa cái MÃ Khách Hàng, chỉ cho sửa tên thôi, cũng kiểm tra xem cái Tên có null k. -->done 1/2
        //ToDO: XÓA thì kiểm tra Khách Hàng này đã lập ĐƠN ĐĂT HÀNG chưa. Bằng cách: "Select * from DONDH where MAKH = maKH", với maKH là Mã của Khách Hàng đang chọn để Xóa
        //ToDO: Tìm: Thì kiểm tra xem nhập Mã Khách Hàng chưa. Vì tìm theo mã nên không cần nhập Họ tên. -->done
    }

    boolean checkDieuKienChoInsert(){
        String ma = editTextMaKH.getText().toString();
        String ten = editTextTenKH.getText().toString();
        //Toast.makeText(MainActivity.this, ma, Toast.LENGTH_SHORT).show();

        if(ma.length() == 0){
            Toast.makeText(MainActivity.this, "Mã khách hàng không được NULL!", Toast.LENGTH_SHORT).show();
            return false;
        }else if(ten.length() == 0){
            Toast.makeText(MainActivity.this, "Tên khách hàng không được NULL!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }



    void xoaKHDB(){
        MyDatabase db = new MyDatabase(this);
        String maKH = editTextMaKH.getText().toString();
        db.deleteKhachHang(maKH);
    }

    void saveDB(){
        MyDatabase db = new MyDatabase(this);
        KhachHang khachHang = new KhachHang();
        khachHang.setMa(editTextMaKH.getText().toString());
        khachHang.setTen(editTextTenKH.getText().toString());
        db.saveKhachHangs(khachHang);
    }
    void loadDB(){
        MyDatabase db = new MyDatabase(this);
        data.clear();
        db.getKhachHangS(data);
        adapter.notifyDataSetChanged();
    }


    void setEvent(){
        adapter = new KhachHangAdapter(this, data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        KhachHang kh = data.get(i);
        index = i;
        editTextMaKH.setText(kh.getMa());
        editTextTenKH.setText(kh.getTen());
    }
}

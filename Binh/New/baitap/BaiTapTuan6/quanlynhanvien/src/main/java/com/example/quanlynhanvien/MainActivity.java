package com.example.quanlynhanvien;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<NhanVien> data = new ArrayList<>();
    private NhanVienAdapter adapter = null;
    private ListView listView;

    private Button btnNhap;
    private ImageButton btnDelete;
    private EditText editMa,editTen;
    private RadioGroup genderGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControll();
        setEvent();
    }

    void setControll(){
        btnNhap = findViewById(R.id.btnNhapNV);
        btnDelete =findViewById(R.id.btnDelete);
        editMa = findViewById(R.id.editTextMaNV);
        editTen = findViewById(R.id.editTextTenNV);
        genderGroup = findViewById(R.id.radioGroup);

        listView = findViewById(R.id.listView);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulyNhap();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulyXoa();
            }
        });
    }
    void setEvent(){
        khoiTao();
        adapter = new NhanVienAdapter( this, data);
        listView.setAdapter(adapter);
    }

    void khoiTao(){
        data.add(new NhanVien("1", "Nhật", R.drawable.nam));
        data.add(new NhanVien("2", "Anh", R.drawable.nu));
    }

    public void xulyNhap()
    {
        String ma = editMa.getText()+"";
        String ten = editTen.getText()+"";
        int gioitinh = R.drawable.nam;
        if(genderGroup.getCheckedRadioButtonId() == R.id.radioButtonNu)
            gioitinh = R.drawable.nu;

        NhanVien emp = new NhanVien(ma, ten, gioitinh);
        data.add(emp);
        adapter.notifyDataSetChanged();

        editMa.setText("");
        editTen.setText("");
        editMa.requestFocus();
    }

    public void xulyXoa()
    {

        for(int i = data.size() - 1 ; i >= 0; i--)
        {
            View v = listView.getChildAt(i);
            CheckBox chk = (CheckBox) v.findViewById(R.id.checkBoxDelete);
            if(chk.isChecked())
            {
                data.remove(i);
            }
        }

        adapter.notifyDataSetChanged();

        for(int i = data.size() - 1 ; i >= 0; i--)
        {
            View v = listView.getChildAt(i);
            CheckBox chk = (CheckBox) v.findViewById(R.id.checkBoxDelete);
            if(chk.isChecked())
            {
                chk.setChecked(false);
            }
        }
    }
}

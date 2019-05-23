package com.myour.demothongtintuan2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtTen;
    private RadioButton rdbtnNam, rdbtnNu;
    private CheckBox chbYeuMauTim, chbThichMauHong, chbSongNoiTam, chbHayKhocTham;
    private Button btnThongTin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControl();

        setEvent();
    }

    private void setEvent() {
        btnThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickBtnThongTin(v);
            }
        });
    }

    private void clickBtnThongTin(View v) {
        String result="";
        int i=0;
        result="Tên: "+edtTen.getText().toString().trim();
        if (rdbtnNam.isChecked()){
            result=result+"\nGiới tính: "+rdbtnNam.getText();
        }else{
            result=result+"\nGiới tính: "+rdbtnNu.getText();
        }
        result=result+"\nSở thích: ";
        if (chbYeuMauTim.isChecked()){
            result=result+"\n-"+chbYeuMauTim.getText();
            i++;
        }
        if (chbThichMauHong.isChecked()){
            result=result+"\n-"+chbThichMauHong.getText();
            i++;
        }
        if (chbSongNoiTam.isChecked()) {
            result = result + "\n-" + chbSongNoiTam.getText();
            i++;
        }
        if (chbHayKhocTham.isChecked()) {
            result = result + "\n-" + chbHayKhocTham.getText();
            i++;
        }
        if(i==0){result=result+"\n Không thích gì!";}
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }

    private void setControl() {
        edtTen=findViewById(R.id.edtTen);
        rdbtnNam=findViewById(R.id.radiobuttonNam);
        rdbtnNu=findViewById(R.id.radiobuttonNu);
        chbYeuMauTim=findViewById(R.id.checkboxYeuMauTim);
        chbSongNoiTam=findViewById(R.id.checkboxSongNoiTam);
        chbThichMauHong=findViewById(R.id.checkboxThichMauHong);
        chbHayKhocTham=findViewById(R.id.checkboxHayKhocTham);
        btnThongTin=findViewById(R.id.buttonThongTin);
    }
}

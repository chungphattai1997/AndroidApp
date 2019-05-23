package com.example.thongtincanhan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ThongTinCaNhan extends AppCompatActivity implements View.OnClickListener {

    private Button btnThongTin;
    private EditText editTextName;
    private RadioButton radioButtonNam, radioButtonNư;
    private CheckBox checkBox_MauTim, checkBox_MauHong, checkBox_NoiTam, checkBox_KhocTham;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_ca_nhan);
        setControl();
    }
    private void setControl(){
        btnThongTin = (Button) findViewById(R.id.btnThongTIn);
        editTextName = (EditText) findViewById(R.id.editTextName);
        radioButtonNam = (RadioButton) findViewById(R.id.radioButtonNam);
        radioButtonNư = (RadioButton) findViewById(R.id.radioButtonNu);
        checkBox_MauTim = (CheckBox) findViewById(R.id.checkBox_MauTim);
        checkBox_MauHong = (CheckBox) findViewById(R.id.checkBox_MauHong);
        checkBox_NoiTam = (CheckBox) findViewById(R.id.checkBox_NoiTam);
        checkBox_KhocTham = (CheckBox) findViewById(R.id.checkBox_KhocTham);
        btnThongTin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String msg = "";
        msg += "Họ Tên: " + String.valueOf(editTextName.getText().toString().trim()) +"\n";

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        RadioButton rad = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
        msg += "Giới tính: " + rad.getText().toString();

        msg += "\n- Sở thích:";
        if(checkBox_MauTim.isChecked()){
            msg += "\n\t+ " + checkBox_MauTim.getText();
        }
        if(checkBox_MauHong.isChecked()){
            msg += "\n\t+ " + checkBox_MauHong.getText();
        }
        if(checkBox_NoiTam.isChecked()){
            msg += "\n\t+ " + checkBox_NoiTam.getText();
        }
        if(checkBox_KhocTham.isChecked()){
            msg += "\n\t+ " + checkBox_KhocTham.getText();
        }
        Toast.makeText(ThongTinCaNhan.this,msg, Toast.LENGTH_LONG).show();
    }
}

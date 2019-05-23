package com.example.soyeulylich;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SoYeuLyLich extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextName, editTextCMND, editTextTTBS;
    private RadioButton radioButtonTC, radioButtonCD, radioButtonDH;
    private CheckBox checkBoxDB, checkBoxCG, checkBoxCTT;
    private Button btnGui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_so_yeu_ly_lich);
        setControl();
    }
    private void setControl(){
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextCMND = (EditText) findViewById(R.id.editTextCMND);
        editTextTTBS = (EditText) findViewById(R.id.editTextTTBS);
        radioButtonTC = (RadioButton) findViewById(R.id.radioButtonTC);
        radioButtonCD = (RadioButton) findViewById(R.id.radioButtonCD);
        radioButtonDH = (RadioButton) findViewById(R.id.radioButtonDH);
        checkBoxDB = (CheckBox) findViewById(R.id.checkBoxDB);
        checkBoxCG = (CheckBox) findViewById(R.id.checkBoxCG);
        checkBoxCTT = (CheckBox) findViewById(R.id.checkBoxCTT);
        btnGui = (Button) findViewById(R.id.btnGui);
        btnGui.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String ten = editTextName.getText().toString().trim();
        //Kiểm tra name
        if(ten.length()<3)
        {
            editTextName.requestFocus();
            editTextName.selectAll();
            Toast.makeText(this, "Tên phải >= 3 ký tự", Toast.LENGTH_LONG).show();
            return;
        }
        // Kiểm tra CMND
        String cmnd = editTextCMND.getText().toString().trim();
        if(cmnd.length()!= 9)
        {
            editTextCMND.requestFocus();
            editTextCMND.selectAll();
            Toast.makeText(this, "CMND phải đúng 9 ký tự", Toast.LENGTH_LONG).show();
            return;
        }

        String bang = "";
        RadioGroup group=(RadioGroup) findViewById(R.id.radioGroup);
        int id = group.getCheckedRadioButtonId();
        RadioButton rad = (RadioButton) findViewById(id);
        bang = rad.getText().toString().trim();


        String sothich = "";
        if(checkBoxDB.isChecked())
            sothich += checkBoxDB.getText()+"\n";
        if(checkBoxCG.isChecked())
            sothich += checkBoxCG.getText()+"\n";
        if(checkBoxCTT.isChecked())
            sothich += checkBoxCTT.getText()+"\n";
        String bosung= editTextTTBS.getText().toString().trim();

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Thông tin cá nhân");
        builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        //tạo nội dung
        String msg = "Tên: " + ten+  "\n";
        msg += "CMND: " + cmnd + "\n";
        msg += "Bằng cấp: " + bang + "\n";
        msg += "Sở thích: " + sothich;
        msg += "—————————–\n";
        msg += "Thông tin bổ sung:\n";
        msg += bosung + "\n";
        msg += "—————————–";
        builder.setMessage(msg);//thiết lập nội dung
        builder.create().show();//hiển thị Dialog
    }

}

package com.example.changeformattext;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class ChangeFormatText extends AppCompatActivity implements View.OnClickListener {

    private Button btnKQ;
    private RadioButton radioButtonOdd, radioButtonEven, radioButtonBoth;
    private CheckBox checkBoxBG, checkBoxTC, checkBoxCT;
    private TextView textViewKQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_format_text);
        setControl();
    }
    private void setControl(){
        btnKQ = (Button) findViewById(R.id.btnKQ);
        radioButtonOdd = (RadioButton) findViewById(R.id.radioButtonOdd);
        radioButtonEven = (RadioButton) findViewById(R.id.radioButtonEven);
        radioButtonBoth = (RadioButton) findViewById(R.id.radioButtonBoth);
        checkBoxBG = (CheckBox) findViewById(R.id.checkBoxBG);
        checkBoxTC = (CheckBox) findViewById(R.id.checkBoxTC);
        checkBoxCT = (CheckBox) findViewById(R.id.checkBoxCT);
        textViewKQ = (TextView) findViewById(R.id.textViewKQ);
        btnKQ.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        int type = radioGroup.indexOfChild(findViewById(radioGroup.getCheckedRadioButtonId()));
        //Toast.makeText(this, String.valueOf(type),Toast.LENGTH_SHORT).show();
        Random r = new Random();
        int max = 100;
        int min = 1;
        int i = 0;
        switch (type){
            case 0:
                while (true){
                    i = r.nextInt(max - min + 1) + min;
                    if(i % 2 != 0) break;
                }
                break;
            case 1:
                while (true){
                    i = r.nextInt(max - min + 1) + min;
                    if(i % 2 == 0) break;
                }
                break;
            case 2:
                i = r.nextInt(max - min + 1) + min;
                break;
        }
        textViewKQ.setText(String.valueOf(i));

        if(checkBoxBG.isChecked()){
            textViewKQ.setBackgroundColor(Color.BLUE);
        }
        else {
            textViewKQ.setBackgroundColor(Color.GRAY);
        }
        if(checkBoxTC.isChecked()){
            textViewKQ.setTextColor(Color.RED);
        }
        else {
            textViewKQ.setTextColor(Color.BLACK);
        }
        if(checkBoxCT.isChecked()){
            textViewKQ.setGravity(Gravity.CENTER);
        }
        else {
            textViewKQ.setGravity(Gravity.LEFT);
        }

    }
}

package com.example.nhom1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TurnOffAlarm extends AppCompatActivity {
    public static int index = 0;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turnoff_alarm);
        button= (Button) findViewById(R.id.btnDismiss);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chuoiString = "off";
                Intent myIntent = new Intent(getApplicationContext(),RingsTone.class);
                myIntent.putExtra("extra",chuoiString);
                getApplicationContext().startService(myIntent);
                //ContextCompat.startForegroundService(getApplicationContext(), myIntent);
                Toast.makeText(TurnOffAlarm.this,"Alarm has been stop!!!",Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void turnOffAlarm(int choose){
        switch (choose){
            case 0:
                AlertDialog.Builder alartBuilder = new AlertDialog.Builder(this);
                final Button btnOff = new Button(this);
                btnOff.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
                break;
            case 1:
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
                alertBuilder.setTitle("Enter answer to dismiss alarm");
                final EditText input = new EditText(this);
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                alertBuilder.setView(input);
                alertBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(input.getText().toString().isEmpty()){
                            return;
                        }

                    }
                });
                break;
            case 2:
                break;
        }
    }
}

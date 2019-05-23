package com.example.apptracnghiem;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Activity7 extends AppCompatActivity implements View.OnClickListener {

    ListView listView;
    Button btnRestart, btnExit;
    ArrayList<String> arrList=null;
    ArrayAdapter<String> adapter=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_7);
        setControll();
    }

    void setControll(){
        listView = (ListView) findViewById(R.id.listView);
        btnRestart = (Button) findViewById(R.id.btnRestart);
        btnExit = (Button) findViewById(R.id.btnExit);

        arrList=new ArrayList<String>();
        //2. Gán Data Source (ArrayList object) vào ArrayAdapter

        Intent it = getIntent();
        String msg1 = it.getStringExtra("cau1");

        String msg2 = it.getStringExtra("cau2");

        arrList.add(0,"Câu 1: "+msg1+"!");
        arrList.add(1, "Câu 2: Có " + msg2 + "/3 đáp án đúng!");

        adapter=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, arrList);
        //3. gán Adapter vào ListView
        listView.setAdapter(adapter);

        btnExit.setOnClickListener(this);
        btnRestart.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnExit:
                finishAffinity();
                System.exit(0);
                break;
            case R.id.btnRestart:
                Intent intent = new Intent(this, MainActivity.class);
                //intent.setFlags(Intent.);
                startActivity(intent);
                break;
        }
    }
}

package com.example.baitap2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private ArrayList<RowItem> data = new ArrayList<RowItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControll();
        setEvent();
    }

    void setControll(){
        listView = findViewById(R.id.listView);
    }
    void setEvent(){
        KhoiTao();
        RowItemAdapter rowItemAdapter = new RowItemAdapter(this, data);
        listView.setAdapter(rowItemAdapter);
        listView.setOnItemClickListener(this);
    }

    void KhoiTao(){
        data.add(new RowItem(R.drawable.strawberry, "Strawberry", "It is an aggregate accessory fruit"));
        data.add(new RowItem(R.drawable.banana, "Banana", "It is the largest herbaceous flowering plant"));
        data.add(new RowItem(R.drawable.orange, "Orange", "Citrus Fruit"));
        data.add(new RowItem(R.drawable.fruit, "Mixed", "Mixed Fruits"));
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Item " + (i + 1) + ": " + data.get(i).getTitle() + "\n" + data.get(i).getDetail(),
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }
}


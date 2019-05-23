package com.example.baitapmautuan4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Country> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControll();
        setEvent();

    }

    void setControll() {
        listView = (ListView) findViewById(R.id.listView);
    }

    void setEvent() {
        KhoiTao();
        CustomListAdapter adapter = new CustomListAdapter(this, R.layout.list_item_layout, data);
        listView.setAdapter(adapter);
    }

    void KhoiTao() {
        data.add(new Country(R.drawable.vn, "Việt Nam", 10000000));
        data.add(new Country(R.drawable.my, "Mỹ", 222222222));
        data.add(new Country(R.drawable.phap, "Pháp", 999999999));
    }

}

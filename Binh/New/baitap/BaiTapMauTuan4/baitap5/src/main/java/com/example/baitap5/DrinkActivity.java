package com.example.baitap5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DrinkActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private ArrayList<Drink> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        setControll();
        setEvent();
    }
    void setControll(){
        listView = findViewById(R.id.listViewDrink);
    }
    void setEvent(){
        createDrink();
        DrinkAdapter adapter = new DrinkAdapter(this, data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }
    void createDrink(){
        data.add(new Drink(R.drawable.coca, "Coca"));
        data.add(new Drink(R.drawable.pepsi, "Pepsi"));
        data.add(new Drink(R.drawable.heniken, "Heniken"));
        data.add(new Drink(R.drawable.aqufina, "Aquafina"));
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(DrinkActivity.this, MainActivity.class);
        MainActivity.drinkName = data.get(i).getNameDrink();
        startActivity(intent);
    }
}

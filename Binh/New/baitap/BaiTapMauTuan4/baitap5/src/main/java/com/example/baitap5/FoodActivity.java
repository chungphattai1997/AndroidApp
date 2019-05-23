package com.example.baitap5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private ArrayList<Food> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        setControll();
        setEvent();
    }
    void setControll(){
        listView = findViewById(R.id.listViewFood);
    }
    void setEvent(){
        createFood();
        FoodAdapter adapter = new FoodAdapter(this, data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }
    void createFood(){
        data.add(new Food(R.drawable.phohanoi, "Phở Hà Nội"));
        data.add(new Food(R.drawable.bunbohue, "Bún Bò Huế"));
        data.add(new Food(R.drawable.miquang, "Mì Quảng"));
        data.add(new Food(R.drawable.hutieu, "Hủ Tiếu Nam Vang"));
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(FoodActivity.this, MainActivity.class);
        MainActivity.foodName = data.get(i).getNameFood();
        startActivity(intent);
    }
}

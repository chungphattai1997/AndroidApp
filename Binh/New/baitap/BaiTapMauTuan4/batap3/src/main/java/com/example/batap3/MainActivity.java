package com.example.batap3;

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
    private ArrayList<FootballLegend> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControll();
        setEvent();
    }

    void setControll(){
        listView = findViewById(R.id.listView);
        data = new ArrayList<>();
    }
    void setEvent(){
        KhoiTao();
        FootballLegendAdapter adapter = new FootballLegendAdapter(this, data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }
    void KhoiTao(){
        data.add(new FootballLegend("Messi", "June 24, 1987 (Age: 31)", R.drawable.messi, R.drawable.argentina));
        data.add(new FootballLegend("Ronaldo", "February 5, 1987 (Age: 34)", R.drawable.ronaldo, R.drawable.portugal));
        data.add(new FootballLegend("Maradona", "October 30, 1960 (Age: 58)", R.drawable.maradona, R.drawable.argentina));
        data.add(new FootballLegend("Beckham", "May 2, 1975 (Age: 43)", R.drawable.beckham, R.drawable.phap));
        data.add(new FootballLegend("Zidane", "June 23, 1972 (Age: 46)", R.drawable.zidane, R.drawable.phap));
        data.add(new FootballLegend("Ronaldo", "September 22, 1976 (Age: 42)", R.drawable.ronaldo_brazil, R.drawable.brazil));
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Item " + (i + 1) + ": " + data.get(i).getName() + "\n" + data.get(i).getBorn(),
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }
}


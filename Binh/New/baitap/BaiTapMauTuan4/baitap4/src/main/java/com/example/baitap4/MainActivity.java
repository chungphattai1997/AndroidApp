package com.example.baitap4;

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
    private ArrayList<Music> data = new ArrayList<>();

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
        MusicAdapter adapter  = new MusicAdapter(this, data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }
    void KhoiTao(){
        data.add(new Music(R.drawable.lactroi,"Lạc trôi", "Sơn Tùng MTP", "4:32", R.drawable.arrow));
        data.add(new Music(R.drawable.nangamxadan,"Nắng ấm xa dần", "Sơn Tùng MTP", "3:23", R.drawable.arrow));
        data.add(new Music(R.drawable.noinaycoanh,"Nơi này có anh", "Sơn Tùng MTP", "4:39", R.drawable.arrow));
        data.add(new Music(R.drawable.phiasau1cogai,"Phía sau một cô gái", "Soobin Hoàng Sơn", "4:32", R.drawable.arrow));
        data.add(new Music(R.drawable.chungtakhongthuocvenhau,"Chúng ta không thuộc về nhau", "Sơn Tùng MTP", "4:39", R.drawable.arrow));
        data.add(new Music(R.drawable.conmuanganqua,"Cơn mưa ngang qua", "Sơn Tùng MTP", "4:39", R.drawable.arrow));
        data.add(new Music(R.drawable.emcuangayhomqua,"Em của ngày hôm qua", "Sơn Tùng MTP", "4:39", R.drawable.arrow));
        data.add(new Music(R.drawable.lactroi,"Nơi này có anh", "Sơn Tùng MTP", "4:39", R.drawable.arrow));

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast toast = Toast.makeText(getApplicationContext(),"Name: " + data.get(i).getName(), Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }
}

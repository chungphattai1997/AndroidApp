package com.example.baitapmau;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    ArrayList<SocialNetwork> data = new ArrayList<>();
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
        SocialNetworkAdapter adapter =  new SocialNetworkAdapter(this, R.layout.list_view_item_row, data);
        listView.setAdapter(adapter);
    }
    void KhoiTao(){
        data.add(new SocialNetwork(R.drawable.logofb, "Facebook"));
        data.add(new SocialNetwork(R.drawable.logo_gg, "Google"));
        data.add(new SocialNetwork(R.drawable.logo_msn, "MSN"));
        data.add(new SocialNetwork(R.drawable.logo_sky, "Skype"));
    }
}

package com.myour.tuan4_buoi2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Main extends AppCompatActivity {
    private ListView listView1;
    ArrayList<SocialNetwork> data=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actv_main);

        setControl();
        setEvent();
    }

    private void setEvent() {
        KhoiTao();
        SocialNetworkAdapter adapter=new SocialNetworkAdapter(this,R.layout.listview_item_row,data);
        listView1.setAdapter(adapter);
    }

    private void KhoiTao() {
        data.add(new SocialNetwork(R.drawable.chrome, "Chrome"));
        data.add(new SocialNetwork(R.drawable.youtube, "Youtube"));
        data.add(new SocialNetwork(R.drawable.spotify, "Spotify"));
        data.add(new SocialNetwork(R.drawable.steamblue, "Steam"));
        data.add(new SocialNetwork(R.drawable.twitter, "Twitter"));
    }

    private void setControl() {
        listView1=(ListView)findViewById(R.id.lv);
    }
}

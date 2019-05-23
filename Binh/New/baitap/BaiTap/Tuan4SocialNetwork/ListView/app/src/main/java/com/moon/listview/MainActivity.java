package com.moon.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ListView listView1;
    ArrayList<SocialNetwork> data=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }
    private void setControl(){

        listView1=(ListView)findViewById(R.id.listview1);
    }
    private  void setEvent(){
        KhoiTao();
        SocialNetworkAdapter adapter=new SocialNetworkAdapter(this,R.layout.listview_item,data);
        listView1.setAdapter(adapter);
    }
    void KhoiTao(){
       data.add(new SocialNetwork(R.drawable.facebook,"Facebook"));
        data.add(new SocialNetwork(R.drawable.twitter,"Twitter"));
        data.add(new SocialNetwork(R.drawable.instagram,"Instagram"));
        data.add(new SocialNetwork(R.drawable.zalo,"Zalo"));
    }
}

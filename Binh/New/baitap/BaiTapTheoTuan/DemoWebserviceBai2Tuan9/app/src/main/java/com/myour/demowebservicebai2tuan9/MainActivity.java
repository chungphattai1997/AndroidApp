package com.myour.demowebservicebai2tuan9;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    ArrayList<SanPham> data= new ArrayList<>();
    SanPhamAdapter Adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);


        Adapter = new SanPhamAdapter(this,R.layout.item_sanpham,data);
        lv.setAdapter(Adapter);

        new SanPhamAsync().execute("http://192.168.1.5/webservice/Select_SanPham.php");
    }

    class SanPhamAsync extends AsyncTask<String, Integer, SanPham> {



        @Override
        protected SanPham doInBackground(String... strings) {
            String UrlWebservice = strings[0];// lấy địa chỉ Webservice được truyền vào
            String JsonString = new ReadJson().getJSONStringFromURL(UrlWebservice);
            ArrayList<SanPham> datas   = new Gson().fromJson(JsonString, new TypeToken<ArrayList<SanPham>>() {
            }.getType());
            for (int i = 0 ; i< datas.size(); i++) {
                SanPham sanPham = datas.get(i);
                data.add(sanPham);
            }

            return null;
        }

        @Override
        protected void onPostExecute(SanPham sanPham) {
            super.onPostExecute(sanPham);
            Adapter.notifyDataSetChanged();
        }
    }

}

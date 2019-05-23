package com.example.gamelatbai;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class GameLatBai extends AppCompatActivity implements View.OnClickListener {

    Button btnPlay;
    TextView textViewScore;
    ImageView imageView1, imageView2, imageView3;
    String[] links = new String[52];
    int [] ids = new int[52];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_lat_bai);
        setControl();
    }
    private void setControl(){
        btnPlay = (Button) findViewById(R.id.btnPlay);
        textViewScore = (TextView) findViewById(R.id.textViewScore);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        btnPlay.setOnClickListener(this);

        for(int i = 1; i <= 52; i++){
            links[i-1] = "a" + String.valueOf(i);
        }
        for(int i = 0; i < 52; i++){
            ids[i] = getResources().getIdentifier(links[i],"drawable", this.getPackageName());
        }

    }

    @Override
    public void onClick(View view) {
        Random r = new Random();
        int max = 22;
        int min = 1;
        int a = r.nextInt(max - min + 1) + min;
        int b,c;
        while (true){
            b = r.nextInt(max - min + 1) + min;
            if(b != a) break;
        }
        while (true){
            c = r.nextInt(max - min + 1) + min;
            if(c != a && c != b) break;
        }

        imageView1.setImageResource(ids[a]);
        imageView2.setImageResource(ids[b]);
        imageView3.setImageResource(ids[c]);
    }
}

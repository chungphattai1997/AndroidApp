package com.example.changeimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class ChangeImage extends AppCompatActivity implements View.OnClickListener {

    private RadioButton radBird, radCat, radDog, radRabbit, radPig;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_image);
        setControl();


    }
    private  void setControl(){
        radBird = (RadioButton) findViewById(R.id.radBird);
        radCat = (RadioButton) findViewById(R.id.radCat);
        radDog = (RadioButton) findViewById(R.id.radDog);
        radRabbit = (RadioButton) findViewById(R.id.radRabbit);
        radPig = (RadioButton) findViewById(R.id.radPig);
        imageView = (ImageView) findViewById(R.id.imageView);

        radBird.setOnClickListener(this);
        radCat.setOnClickListener(this);
        radDog.setOnClickListener(this);
        radRabbit.setOnClickListener(this);
        radPig.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.radBird:
                imageView.setImageResource(R.drawable.bird);
                break;
            case R.id.radCat:
                imageView.setImageResource(R.drawable.cat);
                break;
            case R.id.radDog:
                imageView.setImageResource(R.drawable.dog);
                break;
            case R.id.radRabbit:
                imageView.setImageResource(R.drawable.rabbit);
                break;
            case R.id.radPig:
                imageView.setImageResource(R.drawable.pig);
                break;
        }
    }
}

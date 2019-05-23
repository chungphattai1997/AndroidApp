package com.myour.demofirebasetuan8;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private String TAG="Message";
    private DatabaseReference msg=null;
    private EditText edtMsg;
    private Button btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControl();
        setFirebase();
        setEvent();
    }

    private void setEvent() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg.setValue(edtMsg.getText().toString());
            }
        });
    }

    private void setControl() {
        edtMsg=findViewById(R.id.edittextMsg);
        btnSend=findViewById(R.id.buttonSend);
    }

    private void setFirebase() {
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        msg=database.getReference(TAG);
        msg.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                Toast.makeText(MainActivity.this, "Value is: "+value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(TAG,"Failed to read value.", databaseError.toException());
            }
        });
    }

}

package com.example.nhom1;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageButton imageButton;
    CheckBox checkBox;
    static RecyclerView recyclerView;
    static AdapterRecycleView adapterRecycleView;
    static TextView textViewNextAlarm;

    public static List<Session> sessionList = new ArrayList<Session>();
    public static List<Session> stringList = new ArrayList<>();
    public static int requestCode = 0;
    public static int alarmID = 0;
    private SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
    static AlarmManager alarmManager;
    static Intent alarmIntent;
    static PendingIntent pendingIntent;
    DataSQL dataSQL = new DataSQL(this);
    public MainActivity() {
    }

    public void delAlarm(Intent alarmIntent, int alarmID, int temp) {
        alarmIntent.setData(Uri.parse("custom://" + alarmID));
        alarmIntent.setAction(String.valueOf(0));
        PendingIntent displayIntent = PendingIntent.getBroadcast(getApplicationContext(), temp, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.cancel(displayIntent);
    }
    public void addNewAlarm(int temp, Intent alarmIntent, int alarmID, String time, AlarmManager alarmManager) {
        alarmIntent.setData(Uri.parse("custom://" + alarmID));//alarm.ID
        alarmIntent.setAction(String.valueOf(0));
        alarmIntent.putExtra("extra", "on");
        pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), temp, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        long timeML = 0;

        try {
            Date mDate = sdf.parse(time);
            timeML = mDate.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(timeML);
        alarmManager.set(AlarmManager.RTC_WAKEUP, timeML, pendingIntent);
    }

    public void load() {
        createData();
        for (int i = 0; i < sessionList.size(); i++) {
            if (sessionList.get(i).getSes_addSes() == 1) {
                addNewAlarm(requestCode, alarmIntent, sessionList.get(i).getSes_id(), sessionList.get(i).getSes_Time(), alarmManager);
                requestCode++;
            }
            String[] out = sessionList.get(i).getSes_Time().split(" ");
            sessionList.get(i).setSes_Time(out[3]);
        }
    }

    private void loadRecycleView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerVIew);
        adapterRecycleView = new AdapterRecycleView(sessionList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapterRecycleView);
        System.out.println("oke");
    }

    public void createData() {
        sessionList.clear();
        stringList.clear();
        sessionList.addAll(dataSQL.getAllSessions());
        stringList.addAll(dataSQL.getAllSessions());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("onCreate: ", "again");
        NotificationHelper notificationHelper = new NotificationHelper(this);
        if (pendingIntent != null) {
            pendingIntent.cancel();
        }
        alarmIntent = new Intent(getApplicationContext(), AlarmReceiver.class);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        requestCode = 0;
        alarmID = 0;
        AdapterRecycleView.selectedPos = -1;
        imageButton = (ImageButton) findViewById(R.id.btnAddAlarm);
        textViewNextAlarm = (TextView) findViewById(R.id.tvNextAL1);
        checkBox = (CheckBox) findViewById(R.id.cbAddSes);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerVIew);
        //dataSQL.deleteAllSession();
        createData();
        load();
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, AddAlarmActivity.class);
                startActivity(myIntent);
            }
        });
        this.loadRecycleView();
    }

    @Override
    public void onBackPressed() {

    }
}

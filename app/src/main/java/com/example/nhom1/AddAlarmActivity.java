package com.example.nhom1;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AddAlarmActivity extends AppCompatActivity {
    public static List<String> data = new ArrayList<>();
    private TimePicker timePicker;
    private ImageButton button;
    private ImageButton btnStop;
    private EditText editText;
    Calendar calendar;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    DataSQL dataSQL = new DataSQL(this);
    Session session = new Session();
    private static int notificationId = 0;
    private String[] times;
    private String ses;
    private Intent intent = new Intent();

    private void init() {
        timePicker = findViewById(R.id.timePick);
        editText = findViewById(R.id.edtTitle);
        button = findViewById(R.id.btnSet);
        btnStop = findViewById(R.id.btnStop);
        calendar = Calendar.getInstance();
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

    }

    public void addNewAlarm(int temp, Intent alarmIntent, int alarmID) {
        alarmIntent.putExtra("extra", "on");
        alarmIntent.setData(Uri.parse("custom://" + alarmID));//alarm.ID
        alarmIntent.setAction(String.valueOf(0));
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        PendingIntent displayIntent = PendingIntent.getBroadcast(getApplicationContext(), temp, alarmIntent, 0);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), displayIntent);
    }

    public void delAlarm(Intent alarmIntent, int alarmID) {
        alarmIntent.putExtra("extra", "off");
        sendBroadcast(alarmIntent);
        alarmIntent.setData(Uri.parse("custom://" + alarmID));
        alarmIntent.setAction(String.valueOf(0));
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        PendingIntent displayIntent = PendingIntent.getBroadcast(AddAlarmActivity.this, 0, alarmIntent, 0);
        alarmManager.cancel(displayIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alarm);
        init();
        if (!MainActivity.stringList.isEmpty() && AdapterRecycleView.selectedPos != -1) {
            times = MainActivity.sessionList.get(AdapterRecycleView.selectedPos).getSes_Time().split(":");
            timePicker.setCurrentHour(Integer.valueOf(times[0]));
            timePicker.setCurrentMinute(Integer.valueOf(times[1]));
            editText.setText(MainActivity.stringList.get(AdapterRecycleView.selectedPos).getSes_Title());
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
                calendar.set(Calendar.MINUTE, timePicker.getCurrentMinute());
                System.out.println(timePicker.getCurrentHour());
                if (AdapterRecycleView.selectedPos == -1) {
                    System.out.println(calendar.getTimeInMillis());
                    setTime();
                } else {
                    calendar.setTimeInMillis(convertDateToMilis(MainActivity.stringList.get(AdapterRecycleView.selectedPos).getSes_Time()));
                    setTime();
                }

                Intent intent1 = new Intent(AddAlarmActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent1);
            }
        });
    }

    public void setTime() {
        ses = String.valueOf(calendar.getTime());
        String text = editText.getText().toString();
        session.setSes_Title(text);
        session.setSes_Time(String.valueOf(ses));
        Log.e("setTime: ", String.valueOf(ses));
        session.setSes_addSes(1);
        if (AdapterRecycleView.selectedPos == -1) {
            dataSQL.addSession(session);
        } else {
            calendar.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
            calendar.set(Calendar.MINUTE, timePicker.getCurrentMinute());
            session.setSes_Time(String.valueOf(calendar.getTime()));
            session.setSes_id(MainActivity.stringList.get(AdapterRecycleView.selectedPos).getSes_id());
            System.out.println(session.getSes_id() + " " + session.getSes_Title() + " " + session.getSes_Time() + " " + session.getSes_addSes());
            dataSQL.updateSession(session);
        }
    }

    private Long convertDateToMilis(String stringTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
        long timeML = 0;
        try {
            Date mDate = sdf.parse(stringTime);
            timeML = mDate.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timeML;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(AddAlarmActivity.this, MainActivity.class));
        finish();
    }
}

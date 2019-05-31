package com.example.nhom1;

import android.app.Application;
import android.support.v4.content.ContextCompat;

public class LifeApp extends Application {
    @Override
    public void onTerminate() {
        super.onTerminate();
        ContextCompat.startForegroundService(AlarmReceiver.context, AlarmReceiver.serviceIntent);
    }
}

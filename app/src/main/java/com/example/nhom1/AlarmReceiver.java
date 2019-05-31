package com.example.nhom1;

import android.app.ActivityManager;
import android.app.PendingIntent;
import android.arch.lifecycle.LifecycleObserver;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class AlarmReceiver extends BroadcastReceiver implements LifecycleObserver {
    static Intent serviceIntent = null;
    public static List<Session> sessionList = new ArrayList<Session>();
    DataSQL dataSQL;
    static Context context;
    static String chuoiString = "";

    @Override
    public void onReceive(Context context, Intent intent) {
        this.context = context;
        dataSQL = new DataSQL(context);
        sessionList.clear();
        sessionList.addAll(dataSQL.getAllSessions());
        dataSQL.deleteSession(sessionList.get(0));
         if(AdapterRecycleView.data != null){
            AdapterRecycleView.data.remove(0);
            MainActivity.adapterRecycleView.notifyItemRemoved(0);
            MainActivity.adapterRecycleView.notifyDataSetChanged();
        }
        NotificationHelper notificationHelper = new NotificationHelper(context);
        Intent notifyIntent = new Intent(context, TurnOffAlarm.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 1, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder nb = notificationHelper.getChannelNotification();
        nb.setContentIntent(contentIntent);
        notificationHelper.getManager().notify(1, nb.build());

        Log.e("In receiver", "Hi");
        chuoiString = intent.getExtras().getString("extra");
        serviceIntent = new Intent(context, RingsTone.class);
        serviceIntent.putExtra("extra", chuoiString);
        //ContextCompat.startForegroundService(context, serviceIntent);
        LifeApp lifeApp = new LifeApp();
        lifeApp.onTerminate();
    }

    public static boolean isAppRunning(Context context) {
        ActivityManager activityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager
                .getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.processName.equals(context.getPackageName())) {
                if (appProcess.importance != ActivityManager.RunningAppProcessInfo.IMPORTANCE_PERCEPTIBLE) {
                    return true;
                }
            }
        }
        return false;
    }
}

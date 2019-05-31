package com.example.nhom1;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class RingsTone extends Service {
    MediaPlayer mediaPlayer;
    int id;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("onStartCommand: ", "tôi trong music");
        String key = intent.getExtras().getString("extra");
        if (key.equals("on")) {
            id = 1;
        } else if (key.equals("off")) id = 0;
        if (id == 1) {
            playMusic();
        } else {
            stopMusisc();
        }
        return START_NOT_STICKY;
    }


    public void playMusic(){
        if(mediaPlayer == null){
            mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.ringstone);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }
        else if (!mediaPlayer.isPlaying()){
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }
    }
    public void stopMusisc(){
        mediaPlayer.stop();
        mediaPlayer = null;
    }
}

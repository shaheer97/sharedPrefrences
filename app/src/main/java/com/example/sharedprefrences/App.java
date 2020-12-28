package com.example.sharedprefrences;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {

    public static final String CHANNEL_1_ID ="channel1";
    public static final String CHANNEL_2_ID="channel2";

    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannel();
    }

    private void createNotificationChannel() {

if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){

    NotificationChannel channel=new NotificationChannel( CHANNEL_1_ID,"channel 1", NotificationManager.IMPORTANCE_HIGH);
    channel.setDescription("This Is Channel 1");

    NotificationChannel channel1=new NotificationChannel( CHANNEL_2_ID,"channel 2", NotificationManager.IMPORTANCE_LOW);
    channel1.setDescription("This Is Channel 2");

    NotificationManager manager=getSystemService(NotificationManager.class);

    manager.createNotificationChannel(channel);
    manager.createNotificationChannel(channel1);

}
    }
}

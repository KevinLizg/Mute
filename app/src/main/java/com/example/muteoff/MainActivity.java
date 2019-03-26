package com.example.muteoff;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button muteoff= findViewById(R.id.muteoff);
       muteoff.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N
                        && !notificationManager.isNotificationPolicyAccessGranted())

                {
                    Intent intent = new Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);
                    getApplicationContext().startActivity(intent);
                }
                AudioManager audioManager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
                audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
            }
        });

       Button muteon=(Button)findViewById(R.id.muteon);
       muteon.setOnClickListener(new View.OnClickListener(){

           @Override
           public void onClick(View v) {
               NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
               if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N
                       && !notificationManager.isNotificationPolicyAccessGranted())

               {
                   Intent intent = new Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);
                   getApplicationContext().startActivity(intent);
               }
               AudioManager audioManager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
               audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
//               audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
           }
        });
    }
}

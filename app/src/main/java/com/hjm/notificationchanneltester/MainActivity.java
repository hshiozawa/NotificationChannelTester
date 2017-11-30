package com.hjm.notificationchanneltester;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String notificationTitle = getResources().getText(R.string.app_name).toString();

        Button button1 = (Button) findViewById(R.id.channel_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotification(notificationTitle, "Channel 1");
            }
        });

        Button button2 = (Button) findViewById(R.id.channel_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotification(notificationTitle, "Channel 2");
            }
        });

        Button button3 = (Button) findViewById(R.id.channel_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotification(notificationTitle, "Channel 3");
            }
        });
    }

    private void showNotification(String title, String message) {
        Context context = getApplicationContext();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setSmallIcon(R.drawable.icon)
                .setContentTitle(title)
                .setContentText(message);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = builder.build();
        manager.notify(1, notification);
    }

}


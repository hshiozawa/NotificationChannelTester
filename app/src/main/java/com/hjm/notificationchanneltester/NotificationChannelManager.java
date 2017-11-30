package com.hjm.notificationchanneltester;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

public class NotificationChannelManager {
    public static final String CHANNEL_ID_1 = "CHANNEL_ID_1";
    public static final String CHANNEL_ID_2 = "CHANNEL_ID_2";
    public static final String CHANNEL_ID_3 = "CHANNEL_ID_3";
    private static final String[] CHANNEL_ID_LIST = new String[]{CHANNEL_ID_1, CHANNEL_ID_2, CHANNEL_ID_3};
    private static final int[] CHANNEL_TITLE_LIST = new int[]{R.string.channel_1, R.string.channel_2, R.string.channel_3};

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void create(Context context) {

        List<NotificationChannel> channels = new ArrayList<>();
        for (int i = 0, size = CHANNEL_ID_LIST.length; i < size; i++) {
            String id = CHANNEL_ID_LIST[i];
            String title = context.getString(CHANNEL_TITLE_LIST[i]);
            NotificationChannel channel = new NotificationChannel(id, title, NotificationManager.IMPORTANCE_DEFAULT);
            channels.add(channel);
        }

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        for (NotificationChannel channel : channels) {
            notificationManager.createNotificationChannel(channel);
        }
    }
}


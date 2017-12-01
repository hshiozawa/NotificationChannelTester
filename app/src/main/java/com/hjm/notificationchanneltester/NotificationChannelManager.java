package com.hjm.notificationchanneltester;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.annotation.StringRes;

import java.util.ArrayList;
import java.util.List;

public class NotificationChannelManager {
    private static class ChannelSeed {
        final String id;
        @StringRes
        final int titleResId;
        @StringRes
        final int descriptionResId;

        ChannelSeed(String id, @StringRes int titleResId, @StringRes int descriptionResId) {
            this.id = id;
            this.titleResId = titleResId;
            this.descriptionResId = descriptionResId;
        }
    }

    public static final String CHANNEL_ID_1 = "CHANNEL_ID_1";
    public static final String CHANNEL_ID_2 = "CHANNEL_ID_2";
    public static final String CHANNEL_ID_3 = "CHANNEL_ID_3";

    public static final ChannelSeed[] DEFAULT = new ChannelSeed[]{
            new ChannelSeed(CHANNEL_ID_1, R.string.channel_1, R.string.channel_1_description),
            new ChannelSeed(CHANNEL_ID_2, R.string.channel_2, R.string.channel_2_description),
            new ChannelSeed(CHANNEL_ID_3, R.string.channel_3, R.string.channel_3_description)
    };

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void create(Context context, ChannelSeed[] seeds) {
        List<NotificationChannel> channels = new ArrayList<>();
        for (ChannelSeed seed : seeds) {
            String title = context.getString(seed.titleResId);
            String description = context.getString(seed.descriptionResId);

            NotificationChannel channel = new NotificationChannel(seed.id, title, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(description);
            channels.add(channel);
        }

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannels(channels);
    }
}


package com.hjm.notificationchanneltester;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

public class LocaleChangedReceiver extends BroadcastReceiver {
    private static final String TAG = LocaleChangedReceiver.class.getName();

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_LOCALE_CHANGED.equals(intent.getAction())) {
            Log.i(TAG, "ACTION_LOCALE_CHANGED is received");
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                // 言語が切り替わったのでチャンネル名などを更新する
                NotificationChannelManager.create(context, NotificationChannelManager.DEFAULT);
            }
        }
    }
}

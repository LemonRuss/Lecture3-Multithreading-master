package ru.mail.park.lesson3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BatteryReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("BatteryReceiver", String.valueOf(intent));
        Intent service = new Intent(context, BatteryLogger.class);
        service.putExtra(BatteryLogger.EXTRA_ORIGINAL_INTENT, intent);
        context.startService(service);
    }
}

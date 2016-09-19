package ru.mail.park.lesson3;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class BatteryLogger extends IntentService {

    public static final String EXTRA_ORIGINAL_INTENT = "extra.ORIGINAL_INTENT";

    private static final String REMOTE_LOGGER = "https://api.keen.io/dev/null";

    public BatteryLogger() {
        super("BatteryLogger");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("BatteryLogger", "onHandleIntent");

        RequestBody body = RequestBody.create(
                MediaType.parse("text/plain"),
                String.valueOf(intent)
        );

        Response response = null;
        try {
            response = Http.getClient().newCall(
                    new Request.Builder()
                            .url(REMOTE_LOGGER)
                            .post(body)
                            .build()
            ).execute();
            Log.d("BatteryLogger", "Response " + response);
        } catch (IOException e) {
            Log.e("BatteryLogger", "Error", e);
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }

}

package ru.mail.park.lesson3;

import okhttp3.OkHttpClient;

public class Http {

    private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient();

    public static OkHttpClient getClient() {
        return OK_HTTP_CLIENT;
    }

}

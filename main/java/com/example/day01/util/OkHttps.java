package com.example.day01.util;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttps {
    private OkHttpClient okHttpClient;

    private OkHttps() {
        okHttpClient=new OkHttpClient();
    }

    public static OkHttps getintent() {
        return OkHolder.https;
    }

    static class OkHolder{
        private static final OkHttps https = new OkHttps();
    }
    //同步get
    public String get(String mUrl,int i) throws IOException {
        Request request = new Request.Builder().url(mUrl+i).build();
        Response execute = okHttpClient.newCall(request).execute();
        return execute.body().string();
    }
}

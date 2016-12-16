package com.ihavecar.carmock.utils;

import okhttp3.*;

import java.io.IOException;
import java.util.Map;

/**
 * Created by lsz on 2016/12/8.
 */
public class HttpUtils {
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static OkHttpClient client = new OkHttpClient();
    public static String post(String url, String json, Map<String,String> headerMap) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request.Builder build = new Request.Builder()
                .url(url)
                .post(body);
        if(headerMap != null){
            for (Map.Entry<String,String> entry:headerMap.entrySet()){
                  build.addHeader(entry.getKey(),entry.getValue());
            }
        }

        Request request = build.build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()){
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }
    public static String post(String url,String json) throws IOException {
        return post(url,json,null);
    }
    public static String get(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }
}

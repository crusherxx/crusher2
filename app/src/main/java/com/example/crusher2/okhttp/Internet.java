package com.example.crusher2.okhttp;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Internet {
    private Response response;

    public Response getResponse(int pagesize){
        OkHttpClient okHttpClient = new OkHttpClient ();
        HttpUrl.Builder builder = HttpUrl.parse ("https://v.juhe.cn/joke/content/list.php").newBuilder ();
        builder.addQueryParameter ("sort","desc");
        builder.addQueryParameter ("page","1");
        builder.addQueryParameter ("pagesize", "1");
        builder.addQueryParameter ("time",""+System.currentTimeMillis ()/1000);
        builder.addQueryParameter ("key","952eec0125454eb3e74ffa47676f49e0");
        final Request request = new Request.Builder ().url (builder.build ()).get ().build ();
        Call call = okHttpClient.newCall (request);

        try {
            response = call.execute ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
        return response;
    }
}

package com.example.crusher2.task;

import android.util.Log;

import com.example.crusher2.okhttp.Internet;
import com.example.task.LfTask;

import java.io.IOException;

import okhttp3.Response;

public class InternetTask extends XiaohuaTask  {
    String string;
    public String getData(){
        submit (new LfTask () {
            @Override
            public Object onBackground() {
                Response response = new Internet ().getResponse (2);
                String s = null;
                try {
                    s = response.body ().string ();
                } catch (IOException e) {
                    e.printStackTrace ();
                }

                return s;
            }

            @Override
            public void onSuccess(Object o) {
                string = (String)o;
                Log.e ("internet",string);
            }

            @Override
            public void onException(Throwable throwable) {

            }
        });
//        Log.e ("internet",string);
        return string;
    }
}

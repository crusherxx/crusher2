package com.example.crusher2.task;

import android.os.Handler;
import android.os.Looper;

public class ThreadUtil {
    private final static Handler MAIN = new Handler (Looper.getMainLooper ());

    public static int CPU_NUM = Runtime.getRuntime ().availableProcessors ();
    public static void postMainThread(final Runnable runnable){
        MAIN.post (new Runnable () {
            @Override
            public void run() {
                runnable.run ();
            }
        });
    }
}

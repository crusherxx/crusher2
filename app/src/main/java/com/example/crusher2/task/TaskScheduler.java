package com.example.crusher2.task;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

import androidx.annotation.NonNull;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class TaskScheduler {
    private PriorityThreadPoolExecutor executor;
    private static TaskScheduler instance;
    private Handler handler;
    private int COREPOOLSIZE = ThreadUtil.CPU_NUM+1;
    private int MAXIMUMPOOLSIZE = COREPOOLSIZE * 3;
    private int KEEPALIVETIME = 1;

    interface ITaskSchedulerType{
        int SUBMIT_TASK =0;
    }

    public TaskScheduler() {
        HandlerThread handlerThread = new HandlerThread ("task-thread");
        handlerThread.start ();
        this.handler =new Handler (handlerThread.getLooper (), new Handler.Callback () {
            @Override
            public boolean handleMessage(@NonNull Message msg) {
                switch (msg.what){
                    case ITaskSchedulerType.SUBMIT_TASK:
                        doSubmitTask((TaskInstance)msg.obj);
                        break;
                }
                return false;
            }
        });
        BlockingDeque<Runnable> poolQueue = new LinkedBlockingDeque<> ();
        this.executor = new PriorityThreadPoolExecutor (
                COREPOOLSIZE,
                MAXIMUMPOOLSIZE,
                KEEPALIVETIME,
                TimeUnit.MINUTES,
                poolQueue,
                new TaskThreadFactory ()
        );
    }

    private void doSubmitTask(TaskInstance obj) {
        executor.submit (obj);
    }

    public static TaskScheduler getInstance(){
        if (instance == null){
            instance = new TaskScheduler ();
        }
        return instance;
    }

    public void submit(TaskInstance instance){
        handler.sendMessage (handler.obtainMessage (ITaskSchedulerType.SUBMIT_TASK,instance));
    }
}

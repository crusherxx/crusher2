package com.example.crusher2.task;

import android.util.Log;


import com.example.task.LfTask;
import com.example.task.TaskHelper;

import java.io.IOException;

import okhttp3.Response;

public abstract class XiaohuaTask  {
    public void submit(LfTask task){
        TaskHelper.submitTask (task,task);
    }
}

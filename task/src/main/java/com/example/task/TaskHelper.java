package com.example.task;

public class TaskHelper {
    public static void submitTask(ITaskBackground iTaskBackground,ITaskCallback iTaskCallback){
        AsyncTaskInstance instance = new AsyncTaskInstance (iTaskBackground, iTaskCallback);
        TaskScheduler.getInstance ().submit(instance);
    }
}

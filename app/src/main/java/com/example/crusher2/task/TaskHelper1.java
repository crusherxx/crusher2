package com.example.crusher2.task;

public class TaskHelper1 {
    public static void submit(IBackground iBackground,ICallback iCallback){
        TaskInstance taskInstance = new TaskInstance (iBackground, iCallback);
        TaskScheduler.getInstance ().submit (taskInstance);
    }
}

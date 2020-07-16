package com.example.task;

interface ITaskCallback {

    void onSuccess(Object o);
    void onException(Throwable throwable);
}

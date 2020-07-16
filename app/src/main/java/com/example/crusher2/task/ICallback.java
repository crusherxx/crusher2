package com.example.crusher2.task;

public interface ICallback {
    void onComplete(Object o);
    void onException(Throwable throwable);
}

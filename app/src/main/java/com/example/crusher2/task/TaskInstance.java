package com.example.crusher2.task;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class TaskInstance extends FutureTask {
    private IBackground iBackground;
    private ICallback iCallback;
    public TaskInstance(final IBackground iBackground, ICallback iCallback) {
        super (new Callable () {
            @Override
            public Object call() throws Exception {
                return iBackground.onBackground ();
            }
        });
        this.iBackground = iBackground;
        this.iCallback = iCallback;
    }

    @Override
    protected void done() {
        if (iCallback != null){
            onSuccess();
        }
    }

    private void onSuccess() {
        try {
            final Object o = get ();
            if (o !=null){
                ThreadUtil.postMainThread (new Runnable () {
                    @Override
                    public void run() {
                        iCallback.onComplete (o);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }

    @Override
    protected void setException(final Throwable t) {
        super.setException (t);
        if (iCallback!=null){
            ThreadUtil.postMainThread (new Runnable () {
                @Override
                public void run() {
                    iCallback.onException (t);
                }
            });
        }
    }

    public static TaskInstance getInstance(IBackground iBackground, ICallback iCallback){
        return new TaskInstance (iBackground,iCallback);
    }

}

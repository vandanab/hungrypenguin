package com.ama.hungrypenguin.util;

import android.os.Looper;
import android.os.Handler;
/**
 * Created by akshay on 2/21/16.
 */
public class MainThreadImpl implements MainThread {

    private Handler handler;

    public MainThreadImpl() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override public void post(Runnable runnable) {
        handler.post(runnable);
    }
}

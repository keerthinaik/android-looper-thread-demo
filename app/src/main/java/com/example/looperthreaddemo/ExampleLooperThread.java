package com.example.looperthreaddemo;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class ExampleLooperThread extends Thread {

    private static final String TAG = "ExampleLooperThread";

    public Handler looperThreadHandler;

    public Looper looper;

    @Override
    public void run() {
        Log.d(TAG, "start of run: ");
        Looper.prepare();
        looper = Looper.myLooper();
        looperThreadHandler =  new ExampleHandler();
        Looper.loop();
        Log.d(TAG, "end of run: ");
    }
}

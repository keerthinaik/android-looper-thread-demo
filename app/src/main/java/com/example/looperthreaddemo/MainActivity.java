package com.example.looperthreaddemo;

import static com.example.looperthreaddemo.ExampleHandler.TASK_A;
import static com.example.looperthreaddemo.ExampleHandler.TASK_B;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ExampleLooperThread exampleLooperThread = new ExampleLooperThread();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startThread(View view) {
        exampleLooperThread.start();
    }

    public void stopThread(View view) {
        exampleLooperThread.looper.quit();

        // alternate way
        // exampleLooperThread.looperThreadHandler.getLooper().quit();
    }

    public void taskA(View view) {
        Message msg = Message.obtain();
        msg.what = TASK_A;
        exampleLooperThread.looperThreadHandler.sendMessage(msg);

        /*exampleLooperThread.looperThreadHandler.post(() -> {
            for (int i = 0; i < 5; i++) {
                SystemClock.sleep(1000);
                Log.v(TAG, "taskA run: " + i);
            }
        });*/
    }

    public void taskB(View view) {
        Message msg = Message.obtain();
        msg.what = TASK_B;
        exampleLooperThread.looperThreadHandler.sendMessage(msg);
        /*exampleLooperThread.looperThreadHandler.post(() -> {
            for (int i = 0; i < 5; i++) {
                SystemClock.sleep(1000);
                Log.v(TAG, "taskB run: " + i);
            }
        });*/
    }
}
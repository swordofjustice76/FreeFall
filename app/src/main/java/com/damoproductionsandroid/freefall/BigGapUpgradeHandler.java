package com.damoproductionsandroid.freefall;

import android.app.AppComponentFactory;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

import static android.content.ContentValues.TAG;

public class BigGapUpgradeHandler extends Thread {

    TimerTask scanTask;
    Timer timer = new Timer();

    @Override
    public void run() {
        Looper.prepare();
        scanTask = new TimerTask() {
            public void run() {

            }
        };

        timer.schedule(scanTask, 0, 4000);


        CountDownTimer countDownTimer = new CountDownTimer(4000, 1000) {
            @Override
            public void onTick(long l) {
                Log.i(TAG, "onTick: ");
            }

            @Override
            public void onFinish() {
                timer.cancel();
                Log.i(TAG, "onFinish: ");
            }
        }.start();

        Looper.loop();
    }
}

package com.damoproductionsandroid.freefall;

import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

import static android.content.ContentValues.TAG;

public class ItemSpawner extends ItemManager {




    public ItemSpawner(int playerGap, int obstacleGap,  int obstacleHeight, int colour) {

        super(playerGap, obstacleGap, obstacleHeight, colour);
        //this.playerGap = playerGap;


    }

    public void bigUpgradeTimer() {
        Timer timer = new Timer();
        TimerTask powerUpTimerTask = new TimerTask() {
            @Override
            public void run() {
               // playerGap = Constants.PLAYER_GAP;
                //Log.d(TAG, "YAY: " + obstacleManager.obstacleGap);
            }
        };
        timer.schedule(powerUpTimerTask, 5000);
    }
}

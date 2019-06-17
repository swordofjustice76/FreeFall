package com.damoproductionsandroid.freefall;


import android.app.Activity;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;



public class ObjectLogic extends AppCompatActivity {

    private static final String TAG = "";
    public float speed;
    public float speedBuffer;

    public int spawnPoint = -250;

    public long initTime;
    public long startTime;
    public float metres;
    public float mps;
    public int mpsMultiplier = 1;

    public static int SPAWN_REFERENCE_POINT;


    public ArrayList<Obstacle> obstacles;
    public ArrayList<Coin> coins;
    public ArrayList<BigGapUpgrade> bigGapUpgrades;
    public ArrayList<ObstacleDistanceUpgrade> obstacleDistanceUpgrades;
    public ArrayList<ShrinkPlayerUpgrade> shrinkPlayerUpgrades;
    public ArrayList<DoubleCoinsUpgrade> doubleCoinsUpgrades;
    public ArrayList<DoubleScoreUpgrade> doubleScoreUpgrades;



    public int playerGap;
    public int obstacleGap;
    public int obstacleHeight;
    public int colour;



    public ObjectLogic(int playerGap, int obstacleGap, int obstacleHeight, int colour) {
        this.playerGap = playerGap;
        this.obstacleGap = obstacleGap;
        this.obstacleHeight = obstacleHeight;
        this.colour = colour;

        SPAWN_REFERENCE_POINT = 0 - obstacleHeight;

        obstacles = new ArrayList<>();
        coins = new ArrayList<>();
        bigGapUpgrades = new ArrayList<>();
        obstacleDistanceUpgrades = new ArrayList<>();
        shrinkPlayerUpgrades = new ArrayList<>();
        doubleCoinsUpgrades = new ArrayList<>();
        doubleScoreUpgrades = new ArrayList<>();



        startTime = initTime = System.currentTimeMillis();

    }

    public ObjectLogic() {

    }

    public int getSpawnPoint() {
        return spawnPoint;
    }

    public void setSpawnPoint(int spawnPoint) {
        this.spawnPoint = spawnPoint;
    }

    public void update() {


        int elapsedTime = (int) (System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();
        setSpawnPoint(obstacles.get(0).getRectangle().top);
        speed = (float) (Math.sqrt(1 + (startTime - initTime) / 2000.0)) * Constants.SCREEN_HEIGHT / 10000.0f;

        for (Obstacle ob : obstacles) {
            ob.incrementY(speed * elapsedTime);

        }


        if (obstacles.get(obstacles.size() - 1).getRectangle().top >= Constants.SCREEN_HEIGHT) {
            int xStart = (int) (Math.random() * (Constants.SCREEN_WIDTH - playerGap));
            obstacles.add(0, new Obstacle(obstacleHeight, colour, xStart, obstacles.get(0).getRectangle().top - Constants.OBSTACLE_HEIGHT - Constants.OBSTACLE_GAP, (int)Constants.PLAYER_GAP));
            obstacles.remove(obstacles.size() - 1);


            Log.i(TAG, "update: " + getSpawnPoint());


        }


    }

}
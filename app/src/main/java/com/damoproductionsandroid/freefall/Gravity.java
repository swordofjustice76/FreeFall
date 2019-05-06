package com.damoproductionsandroid.freefall;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.util.Log;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class Gravity {


    private long initTime;
    private long startTime;


    public ArrayList<Obstacle> obstacles;
    public ArrayList<Coin> coins;
    public ArrayList<BigGapUpgrade> bigGapUpgrades;
    public ArrayList<ObstacleDistanceUpgrade> obstacleDistanceUpgrades;
    public ArrayList<ShrinkPlayerUpgrade> shrinkPlayerUpgrades;
    //Player player;
    public int playerGap;
    public int obstacleGap;
    public int obstacleHeight;
    public int colour;


    public Gravity(int playerGap, int obstacleGap, int obstacleHeight, int colour) {
        this.playerGap = playerGap;
        this.obstacleGap = obstacleGap;
        this.obstacleHeight = obstacleHeight;
        this.colour = colour;


        obstacles = new ArrayList<>();
        coins = new ArrayList<>();
        bigGapUpgrades = new ArrayList<>();
        obstacleDistanceUpgrades = new ArrayList<>();
        shrinkPlayerUpgrades = new ArrayList<>();

        startTime = initTime = System.currentTimeMillis();

    }


    public void update() {

        int elapsedTime = (int) (System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();

        float speed = (float) (Math.sqrt(1 + (startTime - initTime) / 2000.0)) * Constants.SCREEN_HEIGHT / 10000.0f;

        for (Obstacle ob : obstacles) {
            ob.incrementY(speed * elapsedTime);
        }


        if (obstacles.get(obstacles.size() - 1).getRectangle().top >= Constants.SCREEN_HEIGHT) {
            int xStart = (int) (Math.random() * (Constants.SCREEN_WIDTH - playerGap));
            obstacles.add(0, new Obstacle(obstacleHeight, colour, xStart, obstacles.get(0).getRectangle().top - obstacleHeight - obstacleGap, playerGap));
            obstacles.remove(obstacles.size() - 1);

        }
    }

}
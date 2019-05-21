package com.damoproductionsandroid.freefall;


import android.app.Application;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.util.DisplayMetrics;
import android.util.Log;


import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import static android.content.ContentValues.TAG;


public class ItemManager extends ObjectLogic {

    private long startTime;
    private long initTime;
    private int elapsedTime;



    private int highScore;
    private ObjectLogic objectLogic;

    private Rect metersText = new Rect();

    public boolean updateScore = false;


    HighScore highScoreActivity;


    public ItemManager(int obstacleGap, int playerGap, int obstacleHeight, int colour) {
        super(obstacleGap, playerGap, obstacleHeight, colour);
        this.obstacleGap = obstacleGap;
        this.playerGap = playerGap;
        this.obstacleHeight = obstacleHeight;
        this.colour = colour;

        highScoreActivity = new HighScore();
        objectLogic = new ObjectLogic();


        startTime = initTime = System.currentTimeMillis();


        populateCoins();
        populateBigGapUpgrade();

        //populateObstacleDistanceUpgrade();
        populateShrinkPlayerUpgrade();
        populateDoubleCoinsUpgrade();
        populateDoubleScoreUpgrade();

    }


    private void populateCoins() {

        int currY = (-5 * Constants.SCREEN_HEIGHT / 4) - (obstacleGap / 2) + (obstacleHeight / 2);
        while (currY < 0) {
            int xStart = (int) (Math.random() * (Constants.SCREEN_WIDTH - obstacleHeight));
            coins.add(new Coin(obstacleHeight, colour, xStart, currY));
            currY += obstacleHeight + obstacleGap;
        }

    }

    private void populateBigGapUpgrade() {
        Timer spawnTimer = new Timer();
        TimerTask spawnTimerTask = new TimerTask() {
            @Override
            public void run() {
                spawnGapUpgrade();
            }
        };
        spawnTimer.scheduleAtFixedRate(spawnTimerTask, 3000, 15000);
    }

    private void populateObstacleDistanceUpgrade() {
        Timer spawnTimer = new Timer();
        TimerTask spawnTimerTask = new TimerTask() {
            @Override
            public void run() {
                spawnDistanceUpgrade();
            }
        };
        spawnTimer.scheduleAtFixedRate(spawnTimerTask, 5000, 12500);
    }

    private void populateShrinkPlayerUpgrade() {
        Timer spawnTimer = new Timer();
        TimerTask spawnTimerTask = new TimerTask() {
            @Override
            public void run() {
                spawnShrinkPayerUpgrade();
            }
        };
        spawnTimer.scheduleAtFixedRate(spawnTimerTask, 7500, 20000);
    }

    private void populateDoubleCoinsUpgrade() {
        Timer spawnTimer = new Timer();
        TimerTask spawnTimerTask = new TimerTask() {
            @Override
            public void run() {
                spawnDoubleCoinsUpgrade();
            }
        };
        spawnTimer.scheduleAtFixedRate(spawnTimerTask, 10000, 25000);
    }

    private void populateDoubleScoreUpgrade() {
        Timer spawnTimer = new Timer();
        TimerTask spawnTimerTask = new TimerTask() {
            @Override
            public void run() {
                spawnDoubleScoreUpgrade();
            }
        };
        spawnTimer.scheduleAtFixedRate(spawnTimerTask, 12500, 20000);
    }


    public boolean playerCollect(Player player) {

        for (Coin coin : coins) {

            if (coin.playerCollect(player)) {
                int xStart = (int) (Math.random() * (Constants.SCREEN_WIDTH - obstacleHeight));
                coins.add(0, new Coin(obstacleHeight, colour, xStart, coins.get(0).getRectangle().top - obstacleHeight - obstacleGap));
                coins.remove(coin);
            }
            if (coin.playerCollect(player))

                return true;
        }
        return false;
    }

    public boolean playerCollectPlayerGapUpgrade(Player player) {
        for (BigGapUpgrade bigGapUpgrade : bigGapUpgrades) {

            if (bigGapUpgrade.playerCollectUpgrade(player)) {
                bigGapUpgrades.remove(bigGapUpgrade);


            }
            if (bigGapUpgrade.playerCollectUpgrade(player))

                return true;
        }
        return false;
    }

    public boolean playerCollectDistanceUpgrade(Player player) {
        for (ObstacleDistanceUpgrade obstacleDistanceUpgrade : obstacleDistanceUpgrades) {

            if (obstacleDistanceUpgrade.playerCollectUpgrade(player)) {
                obstacleDistanceUpgrades.remove(obstacleDistanceUpgrade);

            }
            if (obstacleDistanceUpgrade.playerCollectUpgrade(player))

                return true;
        }
        return false;
    }

    public boolean playerCollectShrinkPlayerUpgrade(Player player) {
        for (ShrinkPlayerUpgrade shrinkPlayerUpgrade : shrinkPlayerUpgrades) {

            if (shrinkPlayerUpgrade.playerCollectUpgrade(player)) {
                shrinkPlayerUpgrades.remove(shrinkPlayerUpgrade);

            }
            if (shrinkPlayerUpgrade.playerCollectUpgrade(player))

                return true;
        }
        return false;
    }

    public boolean playerCollectDoubleCoinsUpgrade(Player player) {
        for (DoubleCoinsUpgrade doubleCoinsUpgrade : doubleCoinsUpgrades) {

            if (doubleCoinsUpgrade.playerCollectUpgrade(player)) {
                doubleCoinsUpgrades.remove(doubleCoinsUpgrade);

            }
            if (doubleCoinsUpgrade.playerCollectUpgrade(player))

                return true;
        }
        return false;
    }

    public boolean playerCollectDoubleScoreUpgrade(Player player) {
        for (DoubleScoreUpgrade doubleScoreUpgrade : doubleScoreUpgrades) {

            if (doubleScoreUpgrade.playerCollectUpgrade(player)) {
                doubleScoreUpgrades.remove(doubleScoreUpgrade);

            }
            if (doubleScoreUpgrade.playerCollectUpgrade(player))

                return true;
        }
        return false;
    }


    public void update() {

        elapsedTime = (int) (System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();

        speed = (float) (Math.sqrt(1 + (startTime - initTime) / 2000.0)) * Constants.SCREEN_HEIGHT / 10000.0f;
        mps = (((float) elapsedTime / 50) * speed * (mpsMultiplier));
        metres += (mps);

        updateScore = true;


        for (Coin coin : coins) {
            coin.incrementY(speed * elapsedTime);

            if (coins.get(coins.size() - 1).getRectangle().top >= Constants.SCREEN_HEIGHT) {
                spawnNewCoin();
            }
        }

        for (BigGapUpgrade bigGapUpgrade : bigGapUpgrades) {
            bigGapUpgrade.incrementY(speed * elapsedTime);

            if (bigGapUpgrades.get(bigGapUpgrades.size() - 1).getRectangle().top >= Constants.SCREEN_HEIGHT) {

                bigGapUpgrades.remove(bigGapUpgrades.size() - 1);
            }
        }

        for (ObstacleDistanceUpgrade obstacleDistanceUpgrade : obstacleDistanceUpgrades) {
            obstacleDistanceUpgrade.incrementY(speed * elapsedTime);

            if (obstacleDistanceUpgrades.get(obstacleDistanceUpgrades.size() - 1).getRectangle().top >= Constants.SCREEN_HEIGHT) {

                obstacleDistanceUpgrades.remove(obstacleDistanceUpgrades.size() - 1);
            }
        }

        for (ShrinkPlayerUpgrade shrinkPlayerUpgrade : shrinkPlayerUpgrades) {
            shrinkPlayerUpgrade.incrementY(speed * elapsedTime);

            if (shrinkPlayerUpgrades.get(shrinkPlayerUpgrades.size() - 1).getRectangle().top >= Constants.SCREEN_HEIGHT) {

                shrinkPlayerUpgrades.remove(shrinkPlayerUpgrades.size() - 1);
            }
        }

        for (DoubleCoinsUpgrade doubleCoinsUpgrade : doubleCoinsUpgrades) {
            doubleCoinsUpgrade.incrementY(speed * elapsedTime);

            if (doubleCoinsUpgrades.get(doubleCoinsUpgrades.size() - 1).getRectangle().top >= Constants.SCREEN_HEIGHT) {

                doubleCoinsUpgrades.remove(doubleCoinsUpgrades.size() - 1);
            }
        }

        for (DoubleScoreUpgrade doubleScoreUpgrade : doubleScoreUpgrades) {
            doubleScoreUpgrade.incrementY(speed * elapsedTime);

            if (doubleScoreUpgrades.get(doubleScoreUpgrades.size() - 1).getRectangle().top >= Constants.SCREEN_HEIGHT) {

                doubleScoreUpgrades.remove(doubleScoreUpgrades.size() - 1);
            }
        }

    }


    public void spawnNewCoin() {

        int xStart = (int) (Math.random() * (Constants.SCREEN_WIDTH - obstacleHeight));
        coins.add(0, new Coin(obstacleHeight, colour, xStart, coins.get(0).getRectangle().top - obstacleHeight - obstacleGap));
        coins.remove(coins.size() - 1);

    }


    public void spawnGapUpgrade() {
        //int currY = (-5 * Constants.SCREEN_HEIGHT / 4) - (obstacleGap / 2) + (obstacleHeight + 25);
        int xStart = (int) (Math.random() * (Constants.SCREEN_WIDTH - obstacleHeight));
        bigGapUpgrades.add(new BigGapUpgrade(obstacleHeight, colour, xStart, coins.get(0).getRectangle().top - obstacleHeight));

    }

    private void spawnDistanceUpgrade() {
        //int currY = (-5 * Constants.SCREEN_HEIGHT / 4) - (obstacleGap / 2) + (obstacleHeight + 25);  //FIX LATER
        int xStart = (int) (Math.random() * (Constants.SCREEN_WIDTH - obstacleHeight));
        obstacleDistanceUpgrades.add(new ObstacleDistanceUpgrade(obstacleHeight, xStart, coins.get(0).getRectangle().top - obstacleHeight, colour));
    }

    private void spawnShrinkPayerUpgrade() {
        // int currY = (-5 * Constants.SCREEN_HEIGHT / 4) - (obstacleGap / 2) + (obstacleHeight + 25);  //FIX LATER
        int xStart = (int) (Math.random() * (Constants.SCREEN_WIDTH - obstacleHeight));
        shrinkPlayerUpgrades.add(new ShrinkPlayerUpgrade(obstacleHeight, colour, xStart, coins.get(0).getRectangle().top - obstacleHeight));
    }

    private void spawnDoubleCoinsUpgrade() {
        int xStart = (int) (Math.random() * (Constants.SCREEN_WIDTH - obstacleHeight));
        doubleCoinsUpgrades.add(new DoubleCoinsUpgrade(obstacleHeight, xStart, coins.get(0).getRectangle().top - obstacleHeight, colour));

    }

    private void spawnDoubleScoreUpgrade() {
        int xStart = (int) (Math.random() * (Constants.SCREEN_WIDTH - obstacleHeight));
        doubleScoreUpgrades.add(new DoubleScoreUpgrade(obstacleHeight, xStart, coins.get(0).getRectangle().top - obstacleHeight, colour));
    }

    public void draw(Canvas canvas) {


        for (Coin coin : coins)
            coin.draw(canvas);

        for (BigGapUpgrade bigGapUpgrade : bigGapUpgrades)
            bigGapUpgrade.draw(canvas);

        for (ObstacleDistanceUpgrade obstacleDistanceUpgrade : obstacleDistanceUpgrades)
            obstacleDistanceUpgrade.draw(canvas);

        for (ShrinkPlayerUpgrade shrinkPlayerUpgrade : shrinkPlayerUpgrades)
            shrinkPlayerUpgrade.draw(canvas);


        for (DoubleCoinsUpgrade doubleCoinsUpgrade : doubleCoinsUpgrades)
            doubleCoinsUpgrade.draw(canvas);

        for (DoubleScoreUpgrade doubleScoreUpgrade : doubleScoreUpgrades)
            doubleScoreUpgrade.draw(canvas);

        if (updateScore) {

            Paint paint = new Paint();
            paint.setTextSize(75);
            paint.setColor(Color.WHITE);
            //paint.setTypeface(typeface);
            drawMetersText(canvas, paint, String.valueOf((int) metres));
            setHighScore((int) metres);

        }

    }

    public void drawMetersText(Canvas canvas, Paint paint, String text) {
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.getClipBounds(metersText);
        paint.getTextBounds(text, 0, text.length(), metersText);
        float x = ((float) Constants.SCREEN_WIDTH / 2) - ((float) metersText.width() / 2);// - metersText.width() - 50;
        float y = 50 + metersText.height();
        canvas.drawText(text, x, y, paint);
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

}

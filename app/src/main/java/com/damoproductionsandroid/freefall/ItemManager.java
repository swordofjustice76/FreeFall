package com.damoproductionsandroid.freefall;

import android.graphics.Canvas;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

import static android.content.ContentValues.TAG;

public class ItemManager extends Gravity {
    //  private ArrayList<Coin>coins;
    // private int obstacleGap;
    // private int obstacleHeight;
    //private int playerGap;
    // private  int colour;

    private long startTime;
    private long initTime;


    ObstacleManager obstacleManager;
    MainActivity mainActivity;



    public ItemManager(int obstacleGap, int playerGap, int obstacleHeight, int colour) {
        super(obstacleGap, playerGap, obstacleHeight, colour);
        this.obstacleGap = obstacleGap;
        this.playerGap = playerGap;
        this.obstacleHeight = obstacleHeight;
        this.colour = colour;



        startTime = initTime = System.currentTimeMillis();


        populateCoins();
        populateBigGapUpgrade();
        populateObstacleDistanceUpgrade();
        populateShrinkPlayerUpgrade();


    }


    private void populateCoins() {
        int currY = (-5 * Constants.SCREEN_HEIGHT / 4) - (obstacleGap / 2) + (obstacleHeight + 25);
        while (currY < 0) {
            int xStart = (int) (Math.random() * (Constants.SCREEN_WIDTH - playerGap));
            coins.add(new Coin(obstacleHeight, colour, xStart, currY - obstacleHeight));
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
        spawnTimer.schedule(spawnTimerTask, 2000);
    }

    private void populateObstacleDistanceUpgrade() {
        Timer spawnTimer = new Timer();
        TimerTask spawnTimerTask = new TimerTask() {
            @Override
            public void run() {
                spawnDistanceUpgrade();
            }
        };
        spawnTimer.schedule(spawnTimerTask, 3000);
    }

    private void populateShrinkPlayerUpgrade() {
        Timer spawnTimer = new Timer();
        TimerTask spawnTimerTask = new TimerTask() {
            @Override
            public void run() {
                spawnShrinkPayerUpgrade();
            }
        };
        spawnTimer.schedule(spawnTimerTask, 3000);
    }


    public boolean playerCollect(Player player) {
        for (Coin coin : coins) {

            if (coin.playerCollect(player)) {
                int xStart = (int) (Math.random() * (Constants.SCREEN_WIDTH - obstacleHeight));
                coins.add(0, new Coin(obstacleHeight, colour, xStart, coins.get(0).getRectangle().top - obstacleGap - obstacleHeight));
                coins.remove(coin);
            }
            if (coin.playerCollect(player))

                return true;
        }
        return false;
    }

    public boolean playerCollectUpgrade(Player player) {
        for (BigGapUpgrade bigGapUpgrade : bigGapUpgrades) {

            if (bigGapUpgrade.playerCollectUpgrade(player)) {
                bigGapUpgrades.remove(bigGapUpgrade);
                bigUpgradeTimer();

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
                //bigUpgradeTimer();

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
                //bigUpgradeTimer();

            }
            if (shrinkPlayerUpgrade.playerCollectUpgrade(player))

                return true;
        }
        return false;
    }

    private void bigUpgradeTimer() {
            Timer timer = new Timer();
            TimerTask powerUpTimerTask = new TimerTask() {
                @Override
                public void run() {
                    //ObstacleManager obstacleManager = new ObstacleManager(Constants.PLAYER_GAP, Constants.OBSTACLE_GAP, Constants.OBSTACLE_HEIGHT, colour);
                    Log.i(TAG, "YAY: " + playerGap);
                }
            };
            timer.schedule(powerUpTimerTask, 5000);
        }



    public void update() {

        int elapsedTime = (int) (System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();

        float speed = (float) (Math.sqrt(1 + (startTime - initTime) / 2000.0)) * Constants.SCREEN_HEIGHT / 10000.0f;

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

            if (obstacleDistanceUpgrades.get(obstacleDistanceUpgrades.size() - 1).getRect().top >= Constants.SCREEN_HEIGHT) {

                obstacleDistanceUpgrades.remove(obstacleDistanceUpgrades.size() - 1);
            }
        }

        for (ShrinkPlayerUpgrade shrinkPlayerUpgrade : shrinkPlayerUpgrades) {
            shrinkPlayerUpgrade.incrementY(speed * elapsedTime);

            if (shrinkPlayerUpgrades.get(shrinkPlayerUpgrades.size() - 1).getRectangle().top >= Constants.SCREEN_HEIGHT) {

                shrinkPlayerUpgrades.remove(shrinkPlayerUpgrades.size() - 1);
            }
        }

    }

    private void spawnNewCoin() {
        int xStart = (int) (Math.random() * (Constants.SCREEN_WIDTH - obstacleHeight));
        coins.add(0, new Coin(obstacleHeight, colour, xStart, coins.get(0).getRectangle().top - obstacleGap - obstacleHeight));
        coins.remove(coins.size() - 1);
    }

    private void spawnGapUpgrade() {
        int currY = (-5 * Constants.SCREEN_HEIGHT / 4) - (obstacleGap / 2) + (obstacleHeight + 25);
        int xStart = (int) (Math.random() * (Constants.SCREEN_WIDTH - obstacleHeight));
        bigGapUpgrades.add(new BigGapUpgrade(obstacleHeight, colour, xStart, currY - (obstacleHeight * 2)));
    }

    private void spawnDistanceUpgrade(){
        int currY = (-5 * Constants.SCREEN_HEIGHT / 4) - (obstacleGap / 2) + (obstacleHeight + 25);  //FIX LATER
        int xStart = (int) (Math.random() * (Constants.SCREEN_WIDTH - obstacleHeight));
        obstacleDistanceUpgrades.add(new ObstacleDistanceUpgrade(obstacleHeight,xStart, currY, colour));
    }

    private void spawnShrinkPayerUpgrade(){
        int currY = (-5 * Constants.SCREEN_HEIGHT / 4) - (obstacleGap / 2) + (obstacleHeight + 25);  //FIX LATER
        int xStart = (int) (Math.random() * (Constants.SCREEN_WIDTH - obstacleHeight));
        shrinkPlayerUpgrades.add(new ShrinkPlayerUpgrade(obstacleHeight,colour, xStart, currY));
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
    }



}

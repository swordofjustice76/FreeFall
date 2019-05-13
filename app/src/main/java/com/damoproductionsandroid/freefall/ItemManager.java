package com.damoproductionsandroid.freefall;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;


import java.util.Timer;
import java.util.TimerTask;


public class ItemManager extends ObjectLogic {

    private long startTime;
    private long initTime;

    private int highScore;

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



        startTime = initTime = System.currentTimeMillis();


        populateCoins();
        populateBigGapUpgrade();

        populateObstacleDistanceUpgrade();
        populateShrinkPlayerUpgrade();


    }


    private void populateCoins() {

        int currY = (-5 * Constants.SCREEN_HEIGHT / 4) - (obstacleGap / 2) + (obstacleHeight + 25);
        while (currY < 0) {
            int xStart = (int) (Math.random() * (Constants.SCREEN_WIDTH - obstacleHeight));
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
        spawnTimer.scheduleAtFixedRate(spawnTimerTask, 5000, 15000);
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
        spawnTimer.scheduleAtFixedRate(spawnTimerTask, 5000, 20000);
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


    public void update() {

        int elapsedTime = (int) (System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();

        float speed = (float) (Math.sqrt(1 + (startTime - initTime) / 2000.0)) * Constants.SCREEN_HEIGHT / 10000.0f;
        metres += (((float) elapsedTime / 50) * speed);

        updateScore = true;


        for (Coin coin : coins) {
            coin.incrementY(speed * elapsedTime);

            if (coins.get(coins.size() - 1).getRectangle().top >= Constants.SCREEN_HEIGHT)
            {
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

    }


    public void spawnNewCoin() {

        int xStart = (int) (Math.random() * (Constants.SCREEN_WIDTH - obstacleHeight));
        coins.add(0, new Coin(obstacleHeight, colour, xStart, coins.get(0).getRectangle().top - obstacleGap - obstacleHeight));
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


    public void draw(Canvas canvas) {
        for (Coin coin : coins)
            coin.draw(canvas);

        for (BigGapUpgrade bigGapUpgrade : bigGapUpgrades)
            bigGapUpgrade.draw(canvas);

        for (ObstacleDistanceUpgrade obstacleDistanceUpgrade : obstacleDistanceUpgrades)
            obstacleDistanceUpgrade.draw(canvas);

        for (ShrinkPlayerUpgrade shrinkPlayerUpgrade : shrinkPlayerUpgrades)
            shrinkPlayerUpgrade.draw(canvas);

        if (updateScore) {
            Paint paint = new Paint();
            paint.setTextSize(75);
            paint.setColor(Color.WHITE);
            drawMetersText(canvas, paint, (int) metres + "m");
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

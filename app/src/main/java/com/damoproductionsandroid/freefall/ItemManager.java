package com.damoproductionsandroid.freefall;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class ItemManager extends Gravity{
  //  private ArrayList<Coin>coins;
   // private int obstacleGap;
   // private int obstacleHeight;
    //private int playerGap;
   // private  int colour;

    private long startTime;
    private long initTime;



    public ItemManager (int obstacleGap, int playerGap, int obstacleHeight, int colour){
        super(obstacleGap, playerGap, obstacleHeight, colour);
    this.obstacleGap = obstacleGap;
    this.playerGap = playerGap;
    this.obstacleHeight = obstacleHeight;
    this.colour = colour;



        startTime = initTime = System.currentTimeMillis();




    populateCoins();
    populateBigGapUpgrade();
    }
    private void populateCoins() {
        int currY = (-5*Constants.SCREEN_HEIGHT/4) - (obstacleGap/2) + (obstacleHeight + 25);
        while (currY < 0){
            int xStart = (int)(Math.random()*(Constants.SCREEN_WIDTH - playerGap));
            coins.add(new Coin(obstacleHeight, colour, xStart, currY - obstacleHeight));
            currY += obstacleHeight + obstacleGap;
        }
    }

    private void populateBigGapUpgrade() {
        int currY = (-5*Constants.SCREEN_HEIGHT/4) - (obstacleGap/2) + (obstacleHeight + 25);
       // while (currY < 0){
            int xStart = (int)(Math.random()*(Constants.SCREEN_WIDTH - playerGap));
            bigGapUpgrades.add(new BigGapUpgrade(obstacleHeight, colour, xStart, currY - (obstacleHeight*2)));
            currY += obstacleHeight + obstacleGap;
       // }
    }



    public boolean playerCollect(Player player){
        for (Coin coin : coins){

            if(coin.playerCollect(player)){
                spawnNew();
                coins.remove(coin);
            }
                if(coin.playerCollect(player))

                return true;
            } return false;
        }

    public boolean playerCollectUpgrade(Player player){
        for (BigGapUpgrade bigGapUpgrade : bigGapUpgrades){

            if(bigGapUpgrade.playerCollectUpgrade(player)){

                bigGapUpgrades.remove(bigGapUpgrade);
            }
            if(bigGapUpgrade.playerCollectUpgrade(player))

                return true;
        } return false;
    }


    public void draw(Canvas canvas){
        for (Coin coin : coins)
            coin.draw(canvas);

        for (BigGapUpgrade bigGapUpgrade : bigGapUpgrades)
            bigGapUpgrade.draw(canvas);
    }

    public void update(){


        int elapsedTime = (int) (System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();



        float speed = (float) (Math.sqrt(1 + (startTime - initTime) / 2000.0)) * Constants.SCREEN_HEIGHT / 10000.0f;
        for (Coin coin : coins) {
            coin.incrementY(speed * elapsedTime);

            if (coins.get(coins.size() - 1).getRectangle().top >= Constants.SCREEN_HEIGHT) {
                spawnNew();

          }
        }

        for (BigGapUpgrade bigGapUpgrade : bigGapUpgrades) {
            bigGapUpgrade.incrementY(speed * elapsedTime);

            if (bigGapUpgrades.get(bigGapUpgrades.size() - 1).getRectangle().top >= Constants.SCREEN_HEIGHT) {
               // int xStart = (int) (Math.random() * (Constants.SCREEN_WIDTH - obstacleHeight));
               // coins.add(0, new Coin(obstacleHeight, colour, xStart, coins.get(0).getRectangle().top - obstacleGap - obstacleHeight));
               // coins.remove(coins.size() - 1);

            }
        }

    }

    private void spawnNew() {
        int xStart = (int) (Math.random() * (Constants.SCREEN_WIDTH - obstacleHeight));
        coins.add(0, new Coin(obstacleHeight, colour, xStart, coins.get(0).getRectangle().top - obstacleGap - obstacleHeight));
        coins.remove(coins.size() - 1);
    }

}

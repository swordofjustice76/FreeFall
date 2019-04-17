package com.damoproductionsandroid.freefall;

import android.graphics.Paint;
import android.graphics.Rect;

import java.util.ArrayList;

public class ItemManager extends Gravity{
  //  private ArrayList<Coin>coins;
   // private int obstacleGap;
   // private int obstacleHeight;
    //private int playerGap;
   // private  int colour;

    public ItemManager (int obstacleGap, int playerGap, int obstacleHeight, int colour){
        super(obstacleGap, playerGap, obstacleHeight, colour);
    this.obstacleGap = obstacleGap;
    this.playerGap = playerGap;
    this.obstacleHeight = obstacleHeight;
    this.colour = colour;

    coins = new ArrayList<>();

    spawnCoins();
    }

    private void spawnCoins() {


    }

    public boolean playerCollect(Player player){
        for (Coin coin : coins){
            if(coin.playerCollect(player))
                return true;
            } return false;
        }

}

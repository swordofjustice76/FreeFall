package com.damoproductionsandroid.freefall;

import android.graphics.Paint;

import java.util.ArrayList;

public class ItemManager {
    private ArrayList<Coin>coins;
    private int obstacleGap;
    private  int colour;

    public ItemManager (int obstacleGap, int colour){
    this.obstacleGap = obstacleGap;
    this.colour = colour;

    coins = new ArrayList<>();

    spawnCoins();
    }

    private void spawnCoins() {
        int coinsOnScreen = 5;


    }

    public boolean playerCollect(Player player){
        for (Coin coin : coins){
            if(coin.playerCollect(player))
                return true;
            } return false;
        }

}

package com.damoproductionsandroid.freefall;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Bundle;

public class Preferences extends Activity {

    ItemManager itemManager;
    public static final String HIGH_SCORE = "MyPrefsFile";
    public int highscore;
    public int coins;
    public int currentScore;
    public int currentCoin;


    public boolean UNLOCK_ITEM_1;
    public boolean UNLOCK_ITEM_2;
    public  boolean UNLOCK_ITEM_3;
    public boolean UNLOCK_ITEM_4;
    public boolean UNLOCK_ITEM_5;

    public Rect highScore = new Rect();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHighScore(getApplicationContext());
        setCoinAmount(getApplicationContext());
    }

    public int setCoinAmount(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(HIGH_SCORE, MODE_PRIVATE);

        coins = prefs.getInt("coins", 0); //0 is the default value.
        //Log.i(TAG, "setHighScore: " + highscore);
      return coins;
    }

    public int getCoinAmount(Context context, int currentCoin) {

        SharedPreferences pref = context.getSharedPreferences(HIGH_SCORE, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();


        editor.putInt("coins", currentCoin);
        editor.apply();
        return coins;
    }


    public int setHighScore(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(HIGH_SCORE, MODE_PRIVATE);

        highscore = prefs.getInt("highscore", 0); //0 is the default value.
        //Log.i(TAG, "setHighScore: " + highscore);

        return highscore;
    }

    public void getCurrentScore(Context context, int currentScore) {

        SharedPreferences pref = context.getSharedPreferences(HIGH_SCORE, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        if (currentScore > highscore) {
            editor.putInt("highscore", currentScore);
            editor.apply();
        }
       // Log.i(TAG, "getCurrentScore: " + currentScore);

        if (currentScore > highscore) {
            //Log.d(TAG, "YOU BEAT YOUR HIGHSCORE");
        }
    }

    public boolean isUNLOCK_ITEM_1() {
        return UNLOCK_ITEM_1;
    }

    public void setUNLOCK_ITEM_1(boolean UNLOCK_ITEM_1) {
        this.UNLOCK_ITEM_1 = UNLOCK_ITEM_1;
    }

    public boolean isUNLOCK_ITEM_2() {
        return UNLOCK_ITEM_2;
    }

    public void setUNLOCK_ITEM_2(boolean UNLOCK_ITEM_2) {
        this.UNLOCK_ITEM_2 = UNLOCK_ITEM_2;
    }

    public boolean isUNLOCK_ITEM_3() {
        return UNLOCK_ITEM_3;
    }

    public void setUNLOCK_ITEM_3(boolean UNLOCK_ITEM_3) {
        this.UNLOCK_ITEM_3 = UNLOCK_ITEM_3;
    }

    public boolean isUNLOCK_ITEM_4() {
        return UNLOCK_ITEM_4;
    }

    public void setUNLOCK_ITEM_4(boolean UNLOCK_ITEM_4) {
        this.UNLOCK_ITEM_4 = UNLOCK_ITEM_4;
    }

    public boolean isUNLOCK_ITEM_5() {
        return UNLOCK_ITEM_5;
    }

    public void setUNLOCK_ITEM_5(boolean UNLOCK_ITEM_5) {
        this.UNLOCK_ITEM_5 = UNLOCK_ITEM_5;
    }

}

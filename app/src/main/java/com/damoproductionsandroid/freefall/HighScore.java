package com.damoproductionsandroid.freefall;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class HighScore extends Activity {

    ItemManager itemManager;
    public static final String HIGH_SCORE = "MyPrefsFile";
    public int highscore;
    public int currentScore;
    public Rect highScore = new Rect();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHighScore(getApplicationContext());

    }

    public void setHighScore(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(HIGH_SCORE, MODE_PRIVATE);

        highscore = prefs.getInt("highscore", 0); //0 is the default value.
        Log.i(TAG, "setHighScore: " + highscore);

    }

    public void getCurrentScore(Context context,int currentScore) {

        SharedPreferences pref = context.getSharedPreferences(HIGH_SCORE, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        if (currentScore > highscore) {
            editor.putInt("highscore", currentScore);
            editor.apply();
        }

        Log.i(TAG, "getCurrentScore: " + currentScore);

        if (currentScore > highscore) {
            Log.d(TAG, "YOU BEAT YOUR HIGHSCORE");
        }


    }



}

package com.damoproductionsandroid.freefall;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class HighScore extends Activity {

    ItemManager itemManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        itemManager = new ItemManager();


        getHighScore();
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

    }

    public void getHighScore() {

        //int score = itemManager.getHighScore();

    }
}

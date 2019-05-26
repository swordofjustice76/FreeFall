package com.damoproductionsandroid.freefall;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

public class Shop extends Activity {

    Preferences highScore;

    TextView shopTextView;
    TextView coinsTextView;
    TextView upgradeTextView;
    TextView costTextView;
    TextView levelTextView;

    TextView upgrade1TextView;
    TextView upgrade1CostTextView;
    Button upgrade1LevelBtn;
    TextView upgrade1DescTextView;

    TextView upgrade2TextView;
    TextView upgrade2CostTextView;
    Button upgrade2LevelBtn;
    TextView upgrade2DescTextView;

    TextView upgrade3TextView;
    TextView upgrade3CostTextView;
    TextView upgrade3LevelTextView;
    TextView upgrade3DescTextView;

    ImageButton backBtn;

    GamePanel gamePanel;
    ItemManager itemManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.shop_screen);

        gamePanel = new GamePanel(getApplicationContext());


        inializeView();

        highScore = new Preferences();
        final int coins = highScore.setCoinAmount(getApplicationContext());
        coinsTextView.setText("Coins: " + String.valueOf(coins));

        backBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //highScore.getCoinAmount(getApplicationContext(), coins);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                Log.i(TAG, "onClick: " + coins);

                //Log.d(TAG, "onClick: ");
            }
        });


    }

    private void inializeView() {


        Typeface typeface = ResourcesCompat.getFont(getApplicationContext(), R.font.pixel_font);

        shopTextView = findViewById(R.id.shop_txt);
        coinsTextView = findViewById(R.id.coins_txt);
        upgradeTextView = findViewById(R.id.upgrade_txt);
        costTextView = findViewById(R.id.cost_txt);
        levelTextView = findViewById(R.id.level_txt);

        upgrade1TextView = findViewById(R.id.upgrade1_txt);

        upgrade1CostTextView = findViewById(R.id.upgrade1_cost_txt);
        upgrade1CostTextView.setText(String.valueOf(Constants.PERK_1_COST));
        upgrade1LevelBtn = findViewById(R.id.upgrade1_level_btn);
        upgrade1LevelBtn.setText(String.valueOf(Constants.PERK_1_LVL+ "/" + Constants.PERK_1_MAX_LVL));
        upgrade1DescTextView = findViewById(R.id.upgrade1_desc_txt);

        upgrade2TextView = findViewById(R.id.upgrade2_txt);
        upgrade2CostTextView = findViewById(R.id.upgrade2_cost_txt);
        upgrade2CostTextView.setText(String.valueOf(Constants.PERK_2_COST));
        upgrade2LevelBtn = findViewById(R.id.upgrade2_level_btn);
        upgrade2LevelBtn.setText(String.valueOf(Constants.PERK_2_LVL+ "/" + Constants.PERK_2_MAX_LVL));
        upgrade2DescTextView = findViewById(R.id.upgrade2_desc_txt);

        upgrade3TextView = findViewById(R.id.upgrade3_txt);
        upgrade3CostTextView = findViewById(R.id.upgrade3_cost_txt);
        upgrade3LevelTextView = findViewById(R.id.upgrade3_level_btn);
        upgrade3DescTextView = findViewById(R.id.upgrade3_desc_txt);

        backBtn = (ImageButton) findViewById(R.id.back_btn);

        shopTextView.setTypeface(typeface);
        coinsTextView.setTypeface(typeface);
        upgradeTextView.setTypeface(typeface);
        costTextView.setTypeface(typeface);
        levelTextView.setTypeface(typeface);

        upgrade1TextView.setTypeface(typeface);
        upgrade1CostTextView.setTypeface(typeface);
        upgrade1LevelBtn.setTypeface(typeface);
        upgrade1DescTextView.setTypeface(typeface);

        upgrade2TextView.setTypeface(typeface);
        upgrade2CostTextView.setTypeface(typeface);
        upgrade2LevelBtn.setTypeface(typeface);
        upgrade2DescTextView.setTypeface(typeface);

        upgrade3TextView.setTypeface(typeface);
        upgrade3CostTextView.setTypeface(typeface);
        upgrade3LevelTextView.setTypeface(typeface);
        upgrade3DescTextView.setTypeface(typeface);

        initialiseOnClick();

    }

    private void initialiseOnClick() {
        upgrade1LevelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (highScore.setCoinAmount(getApplicationContext()) > Constants.PERK_1_COST && Constants.PERK_1_LVL < Constants.PERK_1_MAX_LVL){
                    Constants.PLAYER_SIZE -= (Constants.PLAYER_SIZE/100)*2.5;
                    Constants.PERK_1_COST *= 1.5;
                    Constants.PERK_1_LVL ++;
                    upgrade1CostTextView.setText(String.valueOf(Constants.PERK_1_COST));
                    upgrade1LevelBtn.setText(String.valueOf(Constants.PERK_1_LVL+ "/" + Constants.PERK_1_MAX_LVL));
                    Log.i(TAG, "onClick: " + Constants.PLAYER_SIZE);
                }


            }
        });

        upgrade2LevelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (highScore.setCoinAmount(getApplicationContext()) > Constants.PERK_2_COST && Constants.PERK_2_LVL < Constants.PERK_2_MAX_LVL){
                    Constants.MPS_MULTIPLIER *= 1.1;
                    Constants.PERK_2_COST *= 1.5;
                    Constants.PERK_2_LVL ++;
                    upgrade2CostTextView.setText(String.valueOf(Constants.PERK_2_COST));
                    upgrade2LevelBtn.setText(String.valueOf(Constants.PERK_2_LVL+ "/" + Constants.PERK_2_MAX_LVL));
                    Log.i(TAG, "onClick: " + Constants.MPS_MULTIPLIER);

                }
            }
        });
    }


}
    





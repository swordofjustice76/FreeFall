package com.damoproductionsandroid.freefall;

import android.app.Activity;
import android.content.Context;
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

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

import static android.content.ContentValues.TAG;
import static android.os.Parcelable.CONTENTS_FILE_DESCRIPTOR;

public class Shop extends Activity {

    Preferences highScore;
    PassivePerkManager perkManager;

    TextView shopTextView;
    TextView coinsTextView;
    TextView upgradeTextView;
    TextView costTextView;
    TextView levelTextView;

    TextView upgrade1TextView;
    TextView upgrade1CostTextView;
    Button upgrade1LevelBtn;
    TextView upgrade1DescTextView;
    TextView upgrade1StackTextView;


    TextView upgrade2TextView;
    TextView upgrade2CostTextView;
    Button upgrade2LevelBtn;
    TextView upgrade2DescTextView;
    TextView upgrade2StackTextView;

    TextView upgrade3TextView;
    TextView upgrade3CostTextView;
    Button upgrade3LevelBtn;
    TextView upgrade3DescTextView;
    TextView upgrade3StackTextView;

    TextView upgrade4TextView;
    TextView upgrade4CostTextView;
    Button upgrade4LevelBtn;
    TextView upgrade4DescTextView;
    TextView upgrade4StackTextView;

    TextView upgrade5TextView;
    TextView upgrade5CostTextView;
    Button upgrade5LevelBtn;
    TextView upgrade5DescTextView;
    TextView upgrade5StackTextView;

    TextView upgrade6TextView;
    TextView upgrade6CostTextView;
    Button upgrade6LevelBtn;
    TextView upgrade6DescTextView;
    TextView upgrade6StackTextView;

    ImageButton backBtn;

    GamePanel gamePanel;

    int coins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.shop_screen);

        gamePanel = new GamePanel(getApplicationContext());
        highScore = new Preferences();
        perkManager = new PassivePerkManager();

        inializeView();
        setView();
        loadSave();


        backBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                highScore.getCoinAmount(getApplicationContext(), coins);

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });


    }

    private void loadSave() {
        Log.i(TAG, "onClick: " + perkManager.setPerk_5_player_gap(getApplicationContext()));
       // perkManager.getPerk_2_stack(getApplicationContext(), 0);
        //perkManager.getPerk_2_lvl(getApplicationContext(), 0);
        //perkManager.getPerk_2_cost(getApplicationContext(), 0);
        //perkManager.getPerk_2_mps(getApplicationContext(), 0);

       // perkManager.getPerk_5_stack(getApplicationContext(), 0);
        //perkManager.getPerk_5_lvl(getApplicationContext(), 0);
        //perkManager.getPerk_5_cost(getApplicationContext(), 0);


        coins = highScore.setCoinAmount(getApplicationContext());
        coinsTextView.setText(String.valueOf("Coins: " + highScore.setCoinAmount(getApplicationContext())));


        if (perkManager.setPerk_1_lvl(getApplicationContext()) != Constants.PERK_1_MAX_LVL) {
            upgrade1LevelBtn.setText(String.valueOf(perkManager.setPerk_1_lvl(getApplicationContext()) + "/" + Constants.PERK_1_MAX_LVL));
            upgrade1StackTextView.setText(String.valueOf("Stack: +" + perkManager.setPerk_1_stack(getApplicationContext()) + "%"));
            upgrade1CostTextView.setText(String.valueOf(perkManager.setPerk_1_cost(getApplicationContext())));
        } else {
            upgrade1LevelBtn.setEnabled(false);
            upgrade1CostTextView.setText("MAX");
            upgrade1LevelBtn.setText("MAX");
            upgrade1StackTextView.setText(String.valueOf("Stack: +" + perkManager.setPerk_1_stack(getApplicationContext()) + "%"));
        }

        if (perkManager.setPerk_2_lvl(getApplicationContext()) != Constants.PERK_2_MAX_LVL) {
            upgrade2LevelBtn.setText(String.valueOf(perkManager.setPerk_2_lvl(getApplicationContext()) + "/" + Constants.PERK_2_MAX_LVL));
            upgrade2StackTextView.setText(String.valueOf("Stack: +" + perkManager.setPerk_2_stack(getApplicationContext()) + "%"));
            upgrade2CostTextView.setText(String.valueOf(perkManager.setPerk_2_cost(getApplicationContext())));
        } else {
            upgrade2LevelBtn.setEnabled(false);
            upgrade2CostTextView.setText("MAX");
            upgrade2LevelBtn.setText("MAX");
            upgrade2StackTextView.setText(String.valueOf("Stack: +" + perkManager.setPerk_2_stack(getApplicationContext()) + "%"));
        }

        if (perkManager.setPerk_3_lvl(getApplicationContext()) != Constants.PERK_3_MAX_LVL) {
            upgrade3LevelBtn.setText(String.valueOf(perkManager.setPerk_3_lvl(getApplicationContext()) + "/" + Constants.PERK_3_MAX_LVL));
            upgrade3StackTextView.setText(String.valueOf("Stack: +" + perkManager.setPerk_3_stack(getApplicationContext()) + " coins"));
            upgrade3CostTextView.setText(String.valueOf(format((long) perkManager.setPerk_3_cost(getApplicationContext()))));
        } else {
            upgrade3LevelBtn.setEnabled(false);
            upgrade3CostTextView.setText("MAX");
            upgrade3LevelBtn.setText("MAX");
            upgrade3StackTextView.setText(String.valueOf("Stack: +" + perkManager.setPerk_3_stack(getApplicationContext()) + " coins"));
        }

        if (perkManager.setPerk_4_lvl(getApplicationContext()) != Constants.PERK_4_MAX_LVL) {
            upgrade4LevelBtn.setText(String.valueOf(perkManager.setPerk_4_lvl(getApplicationContext()) + "/" + Constants.PERK_4_MAX_LVL));
            upgrade4StackTextView.setText(String.valueOf("Stack: +" + perkManager.setPerk_4_stack(getApplicationContext()) + "%"));
            upgrade4CostTextView.setText(String.valueOf(format((long) perkManager.setPerk_4_cost(getApplicationContext()))));
        } else {
            upgrade4LevelBtn.setEnabled(false);
            upgrade4CostTextView.setText("MAX");
            upgrade4LevelBtn.setText("MAX");
            upgrade4StackTextView.setText(String.valueOf("Stack: +" + perkManager.setPerk_4_stack(getApplicationContext()) + "%"));
        }

        if (perkManager.setPerk_5_lvl(getApplicationContext()) != Constants.PERK_5_MAX_LVL) {
            upgrade5LevelBtn.setText(String.valueOf(perkManager.setPerk_5_lvl(getApplicationContext()) + "/" + Constants.PERK_5_MAX_LVL));
            upgrade5StackTextView.setText(String.valueOf("Stack: +" + perkManager.setPerk_5_stack(getApplicationContext()) + "%"));
            upgrade5CostTextView.setText(String.valueOf(format((long) perkManager.setPerk_5_cost(getApplicationContext()))));
        } else {
            upgrade5LevelBtn.setEnabled(false);
            upgrade5CostTextView.setText("MAX");
            upgrade5LevelBtn.setText("MAX");
            upgrade5StackTextView.setText(String.valueOf("Stack: +" + perkManager.setPerk_5_stack(getApplicationContext()) + "%"));
        }

        if (perkManager.setPerk_6_lvl(getApplicationContext()) != Constants.PERK_6_MAX_LVL) {
            upgrade6LevelBtn.setText(String.valueOf(perkManager.setPerk_6_lvl(getApplicationContext()) + "/" + Constants.PERK_6_MAX_LVL));
            upgrade6StackTextView.setText(String.valueOf("Stack: +" + perkManager.setPerk_6_stack(getApplicationContext()) + " coins"));
            upgrade6CostTextView.setText(String.valueOf(format((long) perkManager.setPerk_6_cost(getApplicationContext()))));
        } else {
            upgrade6LevelBtn.setEnabled(false);
            upgrade6CostTextView.setText("MAX");
            upgrade6LevelBtn.setText("MAX");
            upgrade6StackTextView.setText(String.valueOf("Stack: +" + perkManager.setPerk_6_stack(getApplicationContext()) + " coins"));
        }
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
        upgrade1LevelBtn = findViewById(R.id.upgrade1_level_btn);
        upgrade1DescTextView = findViewById(R.id.upgrade1_desc_txt);
        upgrade1StackTextView = findViewById(R.id.upgrade1_stack_txt);


        upgrade2TextView = findViewById(R.id.upgrade2_txt);
        upgrade2CostTextView = findViewById(R.id.upgrade2_cost_txt);
        upgrade2LevelBtn = findViewById(R.id.upgrade2_level_btn);
        upgrade2DescTextView = findViewById(R.id.upgrade2_desc_txt);
        upgrade2StackTextView = findViewById(R.id.upgrade2_stack_txt);

        upgrade3TextView = findViewById(R.id.upgrade3_txt);
        upgrade3CostTextView = findViewById(R.id.upgrade3_cost_txt);
        upgrade3LevelBtn = findViewById(R.id.upgrade3_level_btn);
        upgrade3DescTextView = findViewById(R.id.upgrade3_desc_txt);
        upgrade3StackTextView = findViewById(R.id.upgrade3_stack_txt);

        upgrade4TextView = findViewById(R.id.upgrade4_txt);
        upgrade4CostTextView = findViewById(R.id.upgrade4_cost_txt);
        upgrade4LevelBtn = findViewById(R.id.upgrade4_level_btn);
        upgrade4DescTextView = findViewById(R.id.upgrade4_desc_txt);
        upgrade4StackTextView = findViewById(R.id.upgrade4_stack_txt);

        upgrade5TextView = findViewById(R.id.upgrade5_txt);
        upgrade5CostTextView = findViewById(R.id.upgrade5_cost_txt);
        upgrade5LevelBtn = findViewById(R.id.upgrade5_level_btn);
        upgrade5DescTextView = findViewById(R.id.upgrade5_desc_txt);
        upgrade5StackTextView = findViewById(R.id.upgrade5_stack_txt);

        upgrade6TextView = findViewById(R.id.upgrade6_txt);
        upgrade6CostTextView = findViewById(R.id.upgrade6_cost_txt);
        upgrade6LevelBtn = findViewById(R.id.upgrade6_level_btn);
        upgrade6DescTextView = findViewById(R.id.upgrade6_desc_txt);
        upgrade6StackTextView = findViewById(R.id.upgrade6_stack_txt);

        backBtn = findViewById(R.id.back_btn);

        shopTextView.setTypeface(typeface);
        coinsTextView.setTypeface(typeface);
        upgradeTextView.setTypeface(typeface);
        costTextView.setTypeface(typeface);
        levelTextView.setTypeface(typeface);

        upgrade1TextView.setTypeface(typeface);
        upgrade1CostTextView.setTypeface(typeface);
        upgrade1LevelBtn.setTypeface(typeface);
        upgrade1DescTextView.setTypeface(typeface);
        upgrade1StackTextView.setTypeface(typeface);

        upgrade2TextView.setTypeface(typeface);
        upgrade2CostTextView.setTypeface(typeface);
        upgrade2LevelBtn.setTypeface(typeface);
        upgrade2DescTextView.setTypeface(typeface);
        upgrade2StackTextView.setTypeface(typeface);


        upgrade3TextView.setTypeface(typeface);
        upgrade3CostTextView.setTypeface(typeface);
        upgrade3LevelBtn.setTypeface(typeface);
        upgrade3DescTextView.setTypeface(typeface);
        upgrade3StackTextView.setTypeface(typeface);


        upgrade4TextView.setTypeface(typeface);
        upgrade4CostTextView.setTypeface(typeface);
        upgrade4LevelBtn.setTypeface(typeface);
        upgrade4DescTextView.setTypeface(typeface);
        upgrade4StackTextView.setTypeface(typeface);


        upgrade5TextView.setTypeface(typeface);
        upgrade5CostTextView.setTypeface(typeface);
        upgrade5LevelBtn.setTypeface(typeface);
        upgrade5DescTextView.setTypeface(typeface);
        upgrade5StackTextView.setTypeface(typeface);


        upgrade6TextView.setTypeface(typeface);
        upgrade6CostTextView.setTypeface(typeface);
        upgrade6LevelBtn.setTypeface(typeface);
        upgrade6DescTextView.setTypeface(typeface);
        upgrade6StackTextView.setTypeface(typeface);


        initialiseOnClick();


    }

    private void setView() {



        //upgrade1LevelBtn.setText(String.valueOf(perkManager.setPerk_1_lvl(getApplicationContext()) + "/" + Constants.PERK_1_MAX_LVL));





        if (Constants.PERK_4_LVL != Constants.PERK_4_MAX_LVL) {
            String formatted = format(Constants.PERK_4_COST);
            upgrade4CostTextView.setText(String.valueOf(formatted));
            upgrade4LevelBtn.setText(Constants.PERK_4_LVL + "/" + Constants.PERK_4_MAX_LVL);
        } else {
            upgrade4CostTextView.setText("MAX");
            upgrade4LevelBtn.setText("MAX");
        }

        if (Constants.PERK_5_LVL != Constants.PERK_5_MAX_LVL) {
            String formatted = format(Constants.PERK_5_COST);
            upgrade5CostTextView.setText(String.valueOf(formatted));
            upgrade5LevelBtn.setText(Constants.PERK_5_LVL + "/" + Constants.PERK_5_MAX_LVL);
        } else {
            upgrade5CostTextView.setText("MAX");
            upgrade5LevelBtn.setText("MAX");
        }

        if (Constants.PERK_6_LVL != Constants.PERK_6_MAX_LVL) {
            String formatted = format(Constants.PERK_6_COST);
            upgrade6CostTextView.setText(String.valueOf(formatted));
            upgrade6LevelBtn.setText(Constants.PERK_6_LVL + "/" + Constants.PERK_6_MAX_LVL);
        } else {
            upgrade6CostTextView.setText("MAX");
            upgrade6LevelBtn.setText("MAX");
        }

    }

    private void initialiseOnClick() {
        upgrade1LevelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (highScore.setCoinAmount(getApplicationContext()) >= Constants.PERK_1_COST && Constants.PERK_1_LVL < Constants.PERK_1_MAX_LVL) {

                    coins -= Constants.PERK_1_COST;
                    coinsTextView.setText("Coins: " + coins);
                    highScore.getCoinAmount(getApplicationContext(), coins);
                    Constants.PLAYER_SIZE -= (Constants.PLAYER_ORIGINAL_SIZE / 100) * 2.5;

                    Constants.PERK_1_LVL = (perkManager.setPerk_1_lvl(getApplicationContext()) + 1);
                    Constants.PERK_1_STACK = (perkManager.setPerk_1_stack(getApplicationContext()) + 2.5f);
                    Constants.PERK_1_COST = (int) (perkManager.setPerk_1_cost(getApplicationContext()) * 1.5f);
                    Constants.PLAYER_SIZE = Constants.PLAYER_SIZE + (int)((Constants.PLAYER_SIZE/100) * 2.5f);

                    perkManager.getPerk_1_lvl(getApplicationContext(), Constants.PERK_1_LVL);
                    perkManager.getPerk_1_stack(getApplicationContext(), Constants.PERK_1_STACK);
                    perkManager.getPerk_1_cost(getApplicationContext(), Constants.PERK_1_COST);
                    perkManager.getPerk_1_player_size(getApplicationContext(), Constants.PLAYER_SIZE);

                    upgrade1CostTextView.setText(String.valueOf(perkManager.setPerk_1_cost(getApplicationContext())));
                    upgrade1LevelBtn.setText(perkManager.setPerk_1_lvl(getApplicationContext()) + "/" + Constants.PERK_1_MAX_LVL);
                    upgrade1StackTextView.setText("Stack: +" + perkManager.setPerk_1_stack(getApplicationContext()) + "%");

                }
                if (Constants.PERK_1_LVL == Constants.PERK_1_MAX_LVL) {
                    upgrade1LevelBtn.setText("MAX");
                    upgrade1CostTextView.setText("MAX");
                }

            }
        });

        upgrade2LevelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (highScore.setCoinAmount(getApplicationContext()) >= Constants.PERK_2_COST && Constants.PERK_2_LVL < Constants.PERK_2_MAX_LVL) {

                    coins -= Constants.PERK_2_COST;
                    coinsTextView.setText("Coins: " + coins);
                    highScore.getCoinAmount(getApplicationContext(), coins);

                    //Constants.MPS_MULTIPLIER *= 1.1;
                    Constants.PERK_2_COST *= 1.5;
                    Constants.PERK_2_LVL++;
                    Constants.PERK_2_STACK += 1;

                    String formattedCost = format(Constants.PERK_2_COST);

                    Constants.PERK_2_LVL = (perkManager.setPerk_2_lvl(getApplicationContext()) + 1);
                    Constants.PERK_2_STACK = (perkManager.setPerk_2_stack(getApplicationContext()) + 1);
                    Constants.PERK_2_COST = (int) (perkManager.setPerk_2_cost(getApplicationContext()) * 1.5f);
                    Constants.MPS_MULTIPLIER = Constants.MPS_MULTIPLIER + ((Constants.MPS_MULTIPLIER/100) * 1.1f);

                    perkManager.getPerk_2_lvl(getApplicationContext(), Constants.PERK_2_LVL);
                    perkManager.getPerk_2_stack(getApplicationContext(), Constants.PERK_2_STACK);
                    perkManager.getPerk_2_cost(getApplicationContext(), Constants.PERK_2_COST);
                    perkManager.getPerk_2_mps(getApplicationContext(), Constants.MPS_MULTIPLIER);

                    upgrade2CostTextView.setText(String.valueOf(perkManager.setPerk_2_cost(getApplicationContext())));
                    upgrade2LevelBtn.setText(perkManager.setPerk_2_lvl(getApplicationContext()) + "/" + Constants.PERK_2_MAX_LVL);
                    upgrade2StackTextView.setText("Stack: +" + perkManager.setPerk_2_stack(getApplicationContext()) + "%");

                }
                if (Constants.PERK_2_LVL == Constants.PERK_2_MAX_LVL) {
                    upgrade2LevelBtn.setText("MAX");
                    upgrade2CostTextView.setText("MAX");
                }
            }
        });

        upgrade3LevelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (highScore.setCoinAmount(getApplicationContext()) >= Constants.PERK_3_COST && Constants.PERK_3_LVL < Constants.PERK_3_MAX_LVL) {

                    coins -= Constants.PERK_3_COST;
                    coinsTextView.setText("Coins: " + coins);
                    highScore.getCoinAmount(getApplicationContext(), coins);

                    Constants.PERK_3_COST *= 1.5;
                    Constants.PERK_3_LVL++;
                    Constants.PERK_3_STACK += 10;

                    Constants.PERK_3_LVL = (perkManager.setPerk_3_lvl(getApplicationContext()) + 1);
                    Constants.PERK_3_STACK = (perkManager.setPerk_3_stack(getApplicationContext()) + 10);
                    Constants.PERK_3_COST =  (int)(perkManager.setPerk_3_cost(getApplicationContext()) * 1.5f);

                    //long formattedCost = Integer.valueOf(format((long)Constants.PERK_3_COST));

                    perkManager.getPerk_3_lvl(getApplicationContext(), Constants.PERK_3_LVL);
                    perkManager.getPerk_3_stack(getApplicationContext(), Constants.PERK_3_STACK);
                    perkManager.getPerk_3_cost(getApplicationContext(), Constants.PERK_3_COST);

                    upgrade3CostTextView.setText(String.valueOf(format((long)perkManager.setPerk_3_cost(getApplicationContext()))));
                    upgrade3LevelBtn.setText(perkManager.setPerk_3_lvl(getApplicationContext()) + "/" + Constants.PERK_3_MAX_LVL);
                    upgrade3StackTextView.setText("Stack: +" + perkManager.setPerk_3_stack(getApplicationContext()) + " coins");
                }
                if (Constants.PERK_3_LVL == Constants.PERK_3_MAX_LVL) {
                    upgrade3LevelBtn.setText("MAX");
                    upgrade3CostTextView.setText("MAX");
                }

            }
        });

        upgrade4LevelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (highScore.setCoinAmount(getApplicationContext()) >= Constants.PERK_4_COST && Constants.PERK_4_LVL < Constants.PERK_4_MAX_LVL) {

                    coins -= Constants.PERK_4_COST;
                    coinsTextView.setText("Coins: " + coins);
                    highScore.getCoinAmount(getApplicationContext(), coins);

                    Constants.PERK_4_COST *= 1.5;
                    Constants.PERK_4_LVL++;
                    Constants.PERK_4_STACK += 1;

                    Constants.PERK_4_LVL = (perkManager.setPerk_4_lvl(getApplicationContext()) + 1);
                    Constants.PERK_4_STACK = (perkManager.setPerk_4_stack(getApplicationContext()) + 1);
                    Constants.PERK_4_COST =  (int)(perkManager.setPerk_4_cost(getApplicationContext()) * 1.5f);

                    //long formattedCost = Integer.valueOf(format((long)Constants.PERK_3_COST));

                    perkManager.getPerk_4_lvl(getApplicationContext(), Constants.PERK_4_LVL);
                    perkManager.getPerk_4_stack(getApplicationContext(), Constants.PERK_4_STACK);
                    perkManager.getPerk_4_cost(getApplicationContext(), Constants.PERK_4_COST);

                    upgrade4CostTextView.setText(String.valueOf(format((long)perkManager.setPerk_4_cost(getApplicationContext()))));
                    upgrade4LevelBtn.setText(perkManager.setPerk_4_lvl(getApplicationContext()) + "/" + Constants.PERK_4_MAX_LVL);
                    upgrade4StackTextView.setText("Stack: +" + perkManager.setPerk_4_stack(getApplicationContext()) + "%");
                }
                if (Constants.PERK_4_LVL == Constants.PERK_4_MAX_LVL) {
                    upgrade4LevelBtn.setText("MAX");
                    upgrade4CostTextView.setText("MAX");
                }

            }
        });

        upgrade5LevelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (highScore.setCoinAmount(getApplicationContext()) >= Constants.PERK_5_COST && Constants.PERK_5_LVL < Constants.PERK_5_MAX_LVL) {

                    coins -= Constants.PERK_5_COST;
                    coinsTextView.setText("Coins: " + coins);
                    highScore.getCoinAmount(getApplicationContext(), coins);

                    Constants.PERK_5_COST *= 1.5;
                    String formattedCost = format(Constants.PERK_5_COST);
                    Constants.PERK_5_LVL++;
                    Constants.PERK_5_STACK += 2.5;
                    //Constants.PLAYER_GAP += (Constants.PLAYER_ORIGINAL_GAP / 100) * 2.5;

                    Constants.PERK_5_LVL = (perkManager.setPerk_5_lvl(getApplicationContext()) + 1);
                    Constants.PERK_5_STACK = (perkManager.setPerk_5_stack(getApplicationContext()) + 2.5f);
                    Constants.PERK_5_COST =  (int)(perkManager.setPerk_5_cost(getApplicationContext()) * 1.5f);
                    Constants.PLAYER_GAP =  (int)(Constants.PLAYER_GAP += ((Constants.PLAYER_ORIGINAL_GAP / 100) * 2.5));

                    //long formattedCost = Integer.valueOf(format((long)Constants.PERK_3_COST));

                    perkManager.getPerk_5_lvl(getApplicationContext(), Constants.PERK_5_LVL);
                    perkManager.getPerk_5_stack(getApplicationContext(), Constants.PERK_5_STACK);
                    perkManager.getPerk_5_cost(getApplicationContext(), Constants.PERK_5_COST);
                    perkManager.getPerk_5_player_gap(getApplicationContext(), Constants.PLAYER_GAP);



                    upgrade5CostTextView.setText(String.valueOf(format((long)perkManager.setPerk_5_cost(getApplicationContext()))));
                    upgrade5LevelBtn.setText(perkManager.setPerk_5_lvl(getApplicationContext()) + "/" + Constants.PERK_5_MAX_LVL);
                    upgrade5StackTextView.setText("Stack: +" + perkManager.setPerk_5_stack(getApplicationContext()) + "%");
                    //Log.d(TAG, "onClick: " + Constants.OBSTACLE_GAP);
                }
                if (Constants.PERK_5_LVL == Constants.PERK_5_MAX_LVL) {
                    upgrade5LevelBtn.setText("MAX");
                    upgrade5CostTextView.setText("MAX");
                }

            }
        });

        upgrade6LevelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (highScore.setCoinAmount(getApplicationContext()) >= Constants.PERK_6_COST && Constants.PERK_6_LVL < Constants.PERK_6_MAX_LVL) {

                    coins -= Constants.PERK_6_COST;
                    coinsTextView.setText("Coins: " + coins);
                    highScore.getCoinAmount(getApplicationContext(), coins);

                    Constants.PERK_6_COST *= 1.5;
                    Constants.PERK_6_LVL++;
                    Constants.PERK_6_STACK += 1;
                    //Constants.COLLECT_AMOUNT++;

                    String formattedCost = format(Constants.PERK_6_COST);

                    Constants.PERK_6_LVL = (perkManager.setPerk_6_lvl(getApplicationContext()) + 1);
                    Constants.PERK_6_STACK = (perkManager.setPerk_6_stack(getApplicationContext()) + 1);
                    Constants.PERK_6_COST =  (int)(perkManager.setPerk_6_cost(getApplicationContext()) * 1.5f);
                    Constants.COLLECT_AMOUNT =  (perkManager.setPerk_6_collect_amount(getApplicationContext()) + 1);

                    //long formattedCost = Integer.valueOf(format((long)Constants.PERK_3_COST));

                    perkManager.getPerk_6_lvl(getApplicationContext(), Constants.PERK_6_LVL);
                    perkManager.getPerk_6_stack(getApplicationContext(), Constants.PERK_6_STACK);
                    perkManager.getPerk_6_cost(getApplicationContext(), Constants.PERK_6_COST);
                    perkManager.getPerk_6_collect_amount(getApplicationContext(), Constants.COLLECT_AMOUNT);

                    upgrade6CostTextView.setText(String.valueOf(format((long)perkManager.setPerk_6_cost(getApplicationContext()))));
                    upgrade6LevelBtn.setText(perkManager.setPerk_6_lvl(getApplicationContext()) + "/" + Constants.PERK_6_MAX_LVL);
                    upgrade6StackTextView.setText("Stack: +" + perkManager.setPerk_6_stack(getApplicationContext()) + " coins");
                    Log.d(TAG, "onClick: " + Constants.OBSTACLE_GAP);
                }
                if (Constants.PERK_6_LVL == Constants.PERK_6_MAX_LVL) {
                    upgrade6LevelBtn.setText("MAX");
                    upgrade6CostTextView.setText("MAX");
                }

            }
        });
    }


    private static final NavigableMap<Long, String> suffixes = new TreeMap<>();

    static {
        suffixes.put(1_000L, "k");
        suffixes.put(1_000_000L, "M");
        suffixes.put(1_000_000_000L, "G");
        suffixes.put(1_000_000_000_000L, "T");
        suffixes.put(1_000_000_000_000_000L, "P");
        suffixes.put(1_000_000_000_000_000_000L, "E");
    }

    public static String format(long value) {
        //Long.MIN_VALUE == -Long.MIN_VALUE so we need an adjustment here
        if (value == Long.MIN_VALUE) return format(Long.MIN_VALUE + 1);
        if (value < 0) return "-" + format(-value);
        if (value < 1000) return Long.toString(value); //deal with easy case

        Map.Entry<Long, String> e = suffixes.floorEntry(value);
        Long divideBy = e.getKey();
        String suffix = e.getValue();

        long truncated = value / (divideBy / 10); //the number part of the output times 10
        boolean hasDecimal = truncated < 100 && (truncated / 10d) != (truncated / 10);
        return hasDecimal ? (truncated / 10d) + suffix : (truncated / 10) + suffix;
    }


}
    





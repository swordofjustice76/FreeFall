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

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

import static android.content.ContentValues.TAG;
import static android.os.Parcelable.CONTENTS_FILE_DESCRIPTOR;

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
    ItemManager itemManager;

    int coins;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.shop_screen);

        gamePanel = new GamePanel(getApplicationContext());


        inializeView();
        setView();

        highScore = new Preferences();
        coins = highScore.setCoinAmount(getApplicationContext());
        coinsTextView.setText("Coins: " + String.valueOf(coins));

        backBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                highScore.getCoinAmount(getApplicationContext(), coins);
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

        upgrade1StackTextView.setText(String.valueOf("Stack: +" + Constants.PERK_1_STACK + "%"));
        upgrade2StackTextView.setText(String.valueOf("Stack: +" + Constants.PERK_2_STACK + "%"));
        upgrade3StackTextView.setText(String.valueOf("Stack: +" + Constants.PERK_3_STACK + " Coins"));
        upgrade4StackTextView.setText(String.valueOf("Stack: +" + Constants.PERK_4_STACK + "%"));
        upgrade5StackTextView.setText(String.valueOf("Stack: +" + Constants.PERK_5_STACK + "%"));
        upgrade6StackTextView.setText(String.valueOf("Stack: +" + Constants.PERK_6_STACK ));



        if (Constants.PERK_1_LVL != Constants.PERK_1_MAX_LVL) {
            upgrade1CostTextView.setText(String.valueOf(Constants.PERK_1_COST));
            upgrade1LevelBtn.setText(String.valueOf(Constants.PERK_1_LVL + "/" + Constants.PERK_1_MAX_LVL));
        } else {
            upgrade1CostTextView.setText(String.valueOf("MAX"));
            upgrade1LevelBtn.setText(String.valueOf("MAX"));
        }

        if (Constants.PERK_2_LVL != Constants.PERK_2_MAX_LVL) {
            upgrade2CostTextView.setText(String.valueOf(Constants.PERK_2_COST));
            upgrade2LevelBtn.setText(String.valueOf(Constants.PERK_2_LVL + "/" + Constants.PERK_2_MAX_LVL));
        } else {
            upgrade2CostTextView.setText(String.valueOf("MAX"));
            upgrade2LevelBtn.setText(String.valueOf("MAX"));
        }

        if (Constants.PERK_3_LVL != Constants.PERK_3_MAX_LVL) {
            String formatted = format(Constants.PERK_3_COST);
            upgrade3CostTextView.setText(String.valueOf(formatted));
            upgrade3LevelBtn.setText(String.valueOf(Constants.PERK_3_LVL + "/" + Constants.PERK_3_MAX_LVL));
        } else {
            upgrade3CostTextView.setText(String.valueOf("MAX"));
            upgrade3LevelBtn.setText(String.valueOf("MAX"));
        }

        if (Constants.PERK_4_LVL != Constants.PERK_4_MAX_LVL) {
            String formatted = format(Constants.PERK_4_COST);
            upgrade4CostTextView.setText(String.valueOf(formatted));
            upgrade4LevelBtn.setText(String.valueOf(Constants.PERK_4_LVL + "/" + Constants.PERK_4_MAX_LVL));
        } else {
            upgrade4CostTextView.setText(String.valueOf("MAX"));
            upgrade4LevelBtn.setText(String.valueOf("MAX"));
        }

        if (Constants.PERK_5_LVL != Constants.PERK_5_MAX_LVL) {
            String formatted = format(Constants.PERK_5_COST);
            upgrade5CostTextView.setText(String.valueOf(formatted));
            upgrade5LevelBtn.setText(String.valueOf(Constants.PERK_5_LVL + "/" + Constants.PERK_5_MAX_LVL));
        } else {
            upgrade5CostTextView.setText(String.valueOf("MAX"));
            upgrade5LevelBtn.setText(String.valueOf("MAX"));
        }

        if (Constants.PERK_6_LVL != Constants.PERK_6_MAX_LVL) {
            String formatted = format(Constants.PERK_6_COST);
            upgrade6CostTextView.setText(String.valueOf(formatted));
            upgrade6LevelBtn.setText(String.valueOf(Constants.PERK_6_LVL + "/" + Constants.PERK_6_MAX_LVL));
        } else {
            upgrade6CostTextView.setText(String.valueOf("MAX"));
            upgrade6LevelBtn.setText(String.valueOf("MAX"));
        }

    }

    private void initialiseOnClick() {
        upgrade1LevelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (highScore.setCoinAmount(getApplicationContext()) >= Constants.PERK_1_COST && Constants.PERK_1_LVL < Constants.PERK_1_MAX_LVL) {

                    coins -= Constants.PERK_1_COST;
                    coinsTextView.setText(String.valueOf("Coins: " + coins));
                    highScore.getCoinAmount(getApplicationContext(), coins);

                    Constants.PLAYER_SIZE -= (Constants.PLAYER_ORIGINAL_SIZE / 100) * 2.5;
                    Constants.PERK_1_COST *= 1.5;
                    Constants.PERK_1_LVL++;
                    Constants.PERK_1_STACK += 2.5;
                    upgrade1CostTextView.setText(String.valueOf(Constants.PERK_1_COST));
                    upgrade1LevelBtn.setText(String.valueOf(Constants.PERK_1_LVL + "/" + Constants.PERK_1_MAX_LVL));
                    upgrade1StackTextView.setText(String.valueOf("Stack: +" + Constants.PERK_1_STACK + "%"));
                    Log.i(TAG, "onClick: " + Constants.PLAYER_SIZE);
                }
                if (Constants.PERK_1_LVL == Constants.PERK_1_MAX_LVL) {
                    upgrade1LevelBtn.setText(String.valueOf("MAX"));
                    upgrade1CostTextView.setText(String.valueOf("MAX"));
                }


            }
        });

        upgrade2LevelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (highScore.setCoinAmount(getApplicationContext()) >= Constants.PERK_2_COST && Constants.PERK_2_LVL < Constants.PERK_2_MAX_LVL) {

                    coins -= Constants.PERK_2_COST;
                    coinsTextView.setText(String.valueOf("Coins: " + coins));
                    highScore.getCoinAmount(getApplicationContext(), coins);

                    Constants.MPS_MULTIPLIER *= 1.1;
                    Constants.PERK_2_COST *= 1.5;
                    String formattedCost = format(Constants.PERK_2_COST);
                    Constants.PERK_2_LVL++;
                    Constants.PERK_2_STACK += 1;
                    upgrade2CostTextView.setText(String.valueOf(formattedCost));
                    upgrade2LevelBtn.setText(String.valueOf(Constants.PERK_2_LVL + "/" + Constants.PERK_2_MAX_LVL));
                    upgrade2StackTextView.setText(String.valueOf("Stack: +" + Constants.PERK_2_STACK + "%"));
                    Log.i(TAG, "onClick: " + Constants.MPS_MULTIPLIER);
                }
                if (Constants.PERK_2_LVL == Constants.PERK_2_MAX_LVL) {
                    upgrade2LevelBtn.setText(String.valueOf("MAX"));
                    upgrade2CostTextView.setText(String.valueOf("MAX"));
                }
            }
        });

        upgrade3LevelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (highScore.setCoinAmount(getApplicationContext()) >= Constants.PERK_3_COST && Constants.PERK_3_LVL < Constants.PERK_3_MAX_LVL) {

                    coins -= Constants.PERK_3_COST;
                    coinsTextView.setText(String.valueOf("Coins: " + coins));
                    highScore.getCoinAmount(getApplicationContext(), coins);

                    Constants.PERK_3_COST *= 1.5;
                    String formattedCost = format(Constants.PERK_3_COST);
                    Constants.PERK_3_LVL++;
                    Constants.PERK_3_STACK += 10;
                    upgrade3CostTextView.setText(String.valueOf(formattedCost));
                    upgrade3LevelBtn.setText(String.valueOf(Constants.PERK_3_LVL + "/" + Constants.PERK_3_MAX_LVL));
                    upgrade3StackTextView.setText(String.valueOf("Stack: +" + Constants.PERK_3_STACK + " Coins"));
                }
                if (Constants.PERK_3_LVL == Constants.PERK_3_MAX_LVL) {
                    upgrade3LevelBtn.setText(String.valueOf("MAX"));
                    upgrade3CostTextView.setText(String.valueOf("MAX"));
                }

            }
        });

        upgrade4LevelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (highScore.setCoinAmount(getApplicationContext()) >= Constants.PERK_4_COST && Constants.PERK_4_LVL < Constants.PERK_4_MAX_LVL) {

                    coins -= Constants.PERK_4_COST;
                    coinsTextView.setText(String.valueOf("Coins: " + coins));
                    highScore.getCoinAmount(getApplicationContext(), coins);

                    Constants.PERK_4_COST *= 1.5;
                    String formattedCost = format(Constants.PERK_4_COST);
                    Constants.PERK_4_LVL++;
                    Constants.PERK_4_STACK += 1;
                    upgrade4CostTextView.setText(String.valueOf(formattedCost));
                    upgrade4LevelBtn.setText(String.valueOf(Constants.PERK_4_LVL + "/" + Constants.PERK_4_MAX_LVL));
                    upgrade4StackTextView.setText(String.valueOf("Stack: +" + Constants.PERK_4_STACK + "%"));
                }
                if (Constants.PERK_4_LVL == Constants.PERK_4_MAX_LVL) {
                    upgrade4LevelBtn.setText(String.valueOf("MAX"));
                    upgrade4CostTextView.setText(String.valueOf("MAX"));
                }

            }
        });

        upgrade5LevelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (highScore.setCoinAmount(getApplicationContext()) >= Constants.PERK_5_COST && Constants.PERK_5_LVL < Constants.PERK_5_MAX_LVL) {

                    coins -= Constants.PERK_5_COST;
                    coinsTextView.setText(String.valueOf("Coins: " + coins));
                    highScore.getCoinAmount(getApplicationContext(), coins);

                    Constants.PERK_5_COST *= 1.5;
                    String formattedCost = format(Constants.PERK_5_COST);
                    Constants.PERK_5_LVL++;
                    Constants.PERK_5_STACK += 2.5;
                    Constants.PLAYER_GAP += (Constants.PLAYER_ORIGINAL_GAP/100) * 2.5;
                    upgrade5CostTextView.setText(String.valueOf(formattedCost));
                    upgrade5LevelBtn.setText(String.valueOf(Constants.PERK_5_LVL + "/" + Constants.PERK_5_MAX_LVL));
                    upgrade5StackTextView.setText(String.valueOf("Stack: +" + Constants.PERK_5_STACK + "%"));
                    Log.d(TAG, "onClick: " + Constants.OBSTACLE_GAP);
                }
                if (Constants.PERK_5_LVL == Constants.PERK_5_MAX_LVL) {
                    upgrade5LevelBtn.setText(String.valueOf("MAX"));
                    upgrade5CostTextView.setText(String.valueOf("MAX"));
                }

            }
        });

        upgrade6LevelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (highScore.setCoinAmount(getApplicationContext()) >= Constants.PERK_6_COST && Constants.PERK_6_LVL < Constants.PERK_6_MAX_LVL) {

                    coins -= Constants.PERK_6_COST;
                    coinsTextView.setText(String.valueOf("Coins: " + coins));
                    highScore.getCoinAmount(getApplicationContext(), coins);

                    Constants.PERK_6_COST *= 1.5;
                    String formattedCost = format(Constants.PERK_6_COST);
                    Constants.PERK_6_LVL++;
                    Constants.PERK_6_STACK += 1;
                    Constants.COLLECT_AMOUNT ++;
                    upgrade6CostTextView.setText(String.valueOf(formattedCost));
                    upgrade6LevelBtn.setText(String.valueOf(Constants.PERK_6_LVL + "/" + Constants.PERK_6_MAX_LVL));
                    upgrade6StackTextView.setText(String.valueOf("Stack: +" + Constants.PERK_6_STACK));
                    Log.d(TAG, "onClick: " + Constants.OBSTACLE_GAP);
                }
                if (Constants.PERK_6_LVL == Constants.PERK_6_MAX_LVL) {
                    upgrade6LevelBtn.setText(String.valueOf("MAX"));
                    upgrade6CostTextView.setText(String.valueOf("MAX"));
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
    





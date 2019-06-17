package com.damoproductionsandroid.freefall;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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


public class Shop extends FragmentActivity {

    Preferences highScore;
    PassivePerkManager perkManager;


    TextView shopTextView;
    Button itemsTabBtn;
    Button perksTabBtn;
    TextView coinsTextView;
    ImageButton backBtn;

    GamePanel gamePanel;

    int coins;
    int highscore;

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
       // setView();
        loadSave();


        backBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                highScore.getCoinAmount(getApplicationContext(), coins);

                finish();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });

        perksTabBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                highScore.getCoinAmount(getApplicationContext(), coins);

                ShopUpgradesFragment shopUpgradesFragment = new ShopUpgradesFragment();
                shopUpgradesFragment.setArguments(getIntent().getExtras());

                // Add the fragment to the 'fragment_container' FrameLayout
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_container, shopUpgradesFragment).commit();


            }
        });

        itemsTabBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                highScore.getCoinAmount(getApplicationContext(), coins);

                ShopItemsFragment shopItemsFragment = new ShopItemsFragment();
                shopItemsFragment.setArguments(getIntent().getExtras());

                // Add the fragment to the 'fragment_container' FrameLayout
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_container, shopItemsFragment).commit();


            }
        });

    }

    public void setCoinsTextView(int coins) {
        this.coins = coins;
        coinsTextView.setText(String.valueOf("Coins: " + coins));
    }



    private void loadSave() {
        highscore = highScore.setHighScore(getApplicationContext());
        coins = highScore.setCoinAmount(getApplicationContext());
        coinsTextView.setText(String.valueOf("Coins: " + highScore.setCoinAmount(getApplicationContext())));
       ;
    }


    private void inializeView() {


        Typeface typeface = ResourcesCompat.getFont(getApplicationContext(), R.font.pixel_font);

        shopTextView = findViewById(R.id.shop_txt);
        itemsTabBtn = findViewById(R.id.items_btn);
        perksTabBtn = findViewById(R.id.perks_btn);
        coinsTextView = findViewById(R.id.coins_txt);

        backBtn = findViewById(R.id.back_btn);

        shopTextView.setTypeface(typeface);
        coinsTextView.setTypeface(typeface);
        itemsTabBtn.setTypeface(typeface);
        perksTabBtn.setTypeface(typeface);

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
    





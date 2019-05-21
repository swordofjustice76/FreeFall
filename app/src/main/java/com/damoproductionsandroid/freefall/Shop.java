package com.damoproductionsandroid.freefall;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.widget.TextView;

public class Shop extends Activity {

    TextView shopTextView;
    TextView coinsTextView;
    TextView upgradeTextView;
    TextView costTextView;
    TextView levelTextView;

    TextView upgrade1TextView;
    TextView upgrade1CostTextView;
    TextView upgrade1LevelTextView;
    TextView upgrade1DescTextView;

    TextView upgrade2TextView;
    TextView upgrade2CostTextView;
    TextView upgrade2LevelTextView;
    TextView upgrade2DescTextView;

    TextView upgrade3TextView;
    TextView upgrade3CostTextView;
    TextView upgrade3LevelTextView;
    TextView upgrade3DescTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_screen);

        inializeView();


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
        upgrade1LevelTextView = findViewById(R.id.upgrade1_level_txt);
        upgrade1DescTextView = findViewById(R.id.upgrade1_desc_txt);

        upgrade2TextView = findViewById(R.id.upgrade2_txt);
        upgrade2CostTextView = findViewById(R.id.upgrade2_cost_txt);
        upgrade2LevelTextView = findViewById(R.id.upgrade2_level_txt);
        upgrade2DescTextView = findViewById(R.id.upgrade2_desc_txt);

        upgrade3TextView = findViewById(R.id.upgrade3_txt);
        upgrade3CostTextView = findViewById(R.id.upgrade3_cost_txt);
        upgrade3LevelTextView = findViewById(R.id.upgrade3_level_txt);
        upgrade3DescTextView = findViewById(R.id.upgrade3_desc_txt);

        shopTextView.setTypeface(typeface);
        coinsTextView.setTypeface(typeface);
        upgradeTextView.setTypeface(typeface);
        costTextView.setTypeface(typeface);
        levelTextView.setTypeface(typeface);

        upgrade1TextView.setTypeface(typeface);
        upgrade1CostTextView.setTypeface(typeface);
        upgrade1LevelTextView.setTypeface(typeface);
        upgrade1DescTextView.setTypeface(typeface);

        upgrade2TextView.setTypeface(typeface);
        upgrade2CostTextView.setTypeface(typeface);
        upgrade2LevelTextView.setTypeface(typeface);
        upgrade2DescTextView.setTypeface(typeface);

        upgrade3TextView.setTypeface(typeface);
        upgrade3CostTextView.setTypeface(typeface);
        upgrade3LevelTextView.setTypeface(typeface);
        upgrade3DescTextView.setTypeface(typeface);

    }
}

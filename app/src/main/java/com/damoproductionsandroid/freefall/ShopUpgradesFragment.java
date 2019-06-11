package com.damoproductionsandroid.freefall;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ShopUpgradesFragment extends Fragment {

    //Preferences highScore;
    //PassivePerkManager perkManager;

    //TextView shopTextView;
    //Button itemsTabBtn;

    //TextView coinsTextView;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.shop_upgrades_fragment, container, false);

        Typeface typeface = ResourcesCompat.getFont(getActivity(), R.font.pixel_font);
        
        upgradeTextView = view.findViewById(R.id.upgrade_txt);
        costTextView = view.findViewById(R.id.cost_txt);
        levelTextView = view.findViewById(R.id.level_txt);

        upgrade1TextView = view.findViewById(R.id.upgrade1_txt);
        upgrade1CostTextView = view.findViewById(R.id.upgrade1_cost_txt);
        upgrade1LevelBtn = view.findViewById(R.id.upgrade1_level_btn);
        upgrade1DescTextView = view.findViewById(R.id.upgrade1_desc_txt);
        upgrade1StackTextView = view.findViewById(R.id.upgrade1_stack_txt);


        upgrade2TextView = view.findViewById(R.id.upgrade2_txt);
        upgrade2CostTextView = view.findViewById(R.id.upgrade2_cost_txt);
        upgrade2LevelBtn = view.findViewById(R.id.upgrade2_level_btn);
        upgrade2DescTextView = view.findViewById(R.id.upgrade2_desc_txt);
        upgrade2StackTextView = view.findViewById(R.id.upgrade2_stack_txt);

        upgrade3TextView = view.findViewById(R.id.upgrade3_txt);
        upgrade3CostTextView = view.findViewById(R.id.upgrade3_cost_txt);
        upgrade3LevelBtn = view.findViewById(R.id.upgrade3_level_btn);
        upgrade3DescTextView = view.findViewById(R.id.upgrade3_desc_txt);
        upgrade3StackTextView = view.findViewById(R.id.upgrade3_stack_txt);

        upgrade4TextView = view.findViewById(R.id.upgrade4_txt);
        upgrade4CostTextView = view.findViewById(R.id.upgrade4_cost_txt);
        upgrade4LevelBtn = view.findViewById(R.id.upgrade4_level_btn);
        upgrade4DescTextView = view.findViewById(R.id.upgrade4_desc_txt);
        upgrade4StackTextView = view.findViewById(R.id.upgrade4_stack_txt);

        upgrade5TextView = view.findViewById(R.id.upgrade5_txt);
        upgrade5CostTextView = view.findViewById(R.id.upgrade5_cost_txt);
        upgrade5LevelBtn = view.findViewById(R.id.upgrade5_level_btn);
        upgrade5DescTextView = view.findViewById(R.id.upgrade5_desc_txt);
        upgrade5StackTextView = view.findViewById(R.id.upgrade5_stack_txt);

        upgrade6TextView = view.findViewById(R.id.upgrade6_txt);
        upgrade6CostTextView = view.findViewById(R.id.upgrade6_cost_txt);
        upgrade6LevelBtn = view.findViewById(R.id.upgrade6_level_btn);
        upgrade6DescTextView = view.findViewById(R.id.upgrade6_desc_txt);
        upgrade6StackTextView = view.findViewById(R.id.upgrade6_stack_txt);

        initialiseView(typeface);
        
        return view;
    }

    private void initialiseView(Typeface typeface) {
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
    }
}

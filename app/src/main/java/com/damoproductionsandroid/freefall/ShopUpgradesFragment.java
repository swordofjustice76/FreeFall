package com.damoproductionsandroid.freefall;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

import static android.content.ContentValues.TAG;

public class ShopUpgradesFragment extends Fragment {
    PassivePerkManager perkManager;
    Preferences highScore;
    Shop shop;

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

    int coins;

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
        loadSave();

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

        initialiseOnClick();
    }

    private void loadSave() {

        coins = highScore.setCoinAmount(getContext());
        ((Shop) getActivity()).setCoinsTextView(coins);

        PassivePerkManager perkManager = new PassivePerkManager();

        perkManager.getPerk_1_lvl(getContext(), 0);
        perkManager.getPerk_1_cost(getContext(), 0);
        perkManager.getPerk_1_player_size(getContext(), 0);
        perkManager.getPerk_1_stack(getContext(), 0);


        if (perkManager.setPerk_1_lvl(getContext()) != Constants.PERK_1_MAX_LVL) {
            upgrade1LevelBtn.setText(String.valueOf(perkManager.setPerk_1_lvl(getContext()) + "/" + Constants.PERK_1_MAX_LVL));
            upgrade1StackTextView.setText(String.valueOf("Stack: +" + perkManager.setPerk_1_stack(getContext()) + "%"));
            upgrade1CostTextView.setText(String.valueOf(perkManager.setPerk_1_cost(getContext())));
        } else {
            upgrade1LevelBtn.setEnabled(false);
            upgrade1CostTextView.setText("MAX");
            upgrade1LevelBtn.setText("MAX");
            upgrade1StackTextView.setText(String.valueOf("Stack: +" + perkManager.setPerk_1_stack(getContext()) + "%"));
        }

        if (perkManager.setPerk_2_lvl(Constants.CURRENT_CONTEXT) != Constants.PERK_2_MAX_LVL) {
            upgrade2LevelBtn.setText(String.valueOf(perkManager.setPerk_2_lvl(Constants.CURRENT_CONTEXT) + "/" + Constants.PERK_2_MAX_LVL));
            upgrade2StackTextView.setText(String.valueOf("Stack: +" + perkManager.setPerk_2_stack(Constants.CURRENT_CONTEXT) + "%"));
            upgrade2CostTextView.setText(String.valueOf(perkManager.setPerk_2_cost(Constants.CURRENT_CONTEXT)));
        } else {
            upgrade2LevelBtn.setEnabled(false);
            upgrade2CostTextView.setText("MAX");
            upgrade2LevelBtn.setText("MAX");
            upgrade2StackTextView.setText(String.valueOf("Stack: +" + perkManager.setPerk_2_stack(Constants.CURRENT_CONTEXT) + "%"));
        }

        if (perkManager.setPerk_3_lvl(Constants.CURRENT_CONTEXT) != Constants.PERK_3_MAX_LVL) {
            upgrade3LevelBtn.setText(String.valueOf(perkManager.setPerk_3_lvl(Constants.CURRENT_CONTEXT) + "/" + Constants.PERK_3_MAX_LVL));
            upgrade3StackTextView.setText(String.valueOf("Stack: +" + perkManager.setPerk_3_stack(Constants.CURRENT_CONTEXT) + " coins"));
            upgrade3CostTextView.setText(String.valueOf(format((long) perkManager.setPerk_3_cost(Constants.CURRENT_CONTEXT))));
        } else {
            upgrade3LevelBtn.setEnabled(false);
            upgrade3CostTextView.setText("MAX");
            upgrade3LevelBtn.setText("MAX");
            upgrade3StackTextView.setText(String.valueOf("Stack: +" + perkManager.setPerk_3_stack(Constants.CURRENT_CONTEXT) + " coins"));
        }

        if (perkManager.setPerk_4_lvl(Constants.CURRENT_CONTEXT) != Constants.PERK_4_MAX_LVL) {
            upgrade4LevelBtn.setText(String.valueOf(perkManager.setPerk_4_lvl(Constants.CURRENT_CONTEXT) + "/" + Constants.PERK_4_MAX_LVL));
            upgrade4StackTextView.setText(String.valueOf("Stack: +" + perkManager.setPerk_4_stack(Constants.CURRENT_CONTEXT) + "%"));
            upgrade4CostTextView.setText(String.valueOf(format((long) perkManager.setPerk_4_cost(Constants.CURRENT_CONTEXT))));
        } else {
            upgrade4LevelBtn.setEnabled(false);
            upgrade4CostTextView.setText("MAX");
            upgrade4LevelBtn.setText("MAX");
            upgrade4StackTextView.setText(String.valueOf("Stack: +" + perkManager.setPerk_4_stack(Constants.CURRENT_CONTEXT) + "%"));
        }

        if (perkManager.setPerk_5_lvl(Constants.CURRENT_CONTEXT) != Constants.PERK_5_MAX_LVL) {
            upgrade5LevelBtn.setText(String.valueOf(perkManager.setPerk_5_lvl(Constants.CURRENT_CONTEXT) + "/" + Constants.PERK_5_MAX_LVL));
            upgrade5StackTextView.setText(String.valueOf("Stack: +" + perkManager.setPerk_5_stack(Constants.CURRENT_CONTEXT) + "%"));
            upgrade5CostTextView.setText(String.valueOf(format((long) perkManager.setPerk_5_cost(Constants.CURRENT_CONTEXT))));
        } else {
            upgrade5LevelBtn.setEnabled(false);
            upgrade5CostTextView.setText("MAX");
            upgrade5LevelBtn.setText("MAX");
            upgrade5StackTextView.setText(String.valueOf("Stack: +" + perkManager.setPerk_5_stack(Constants.CURRENT_CONTEXT) + "%"));
        }

        if (perkManager.setPerk_6_lvl(Constants.CURRENT_CONTEXT) != Constants.PERK_6_MAX_LVL) {
            upgrade6LevelBtn.setText(String.valueOf(perkManager.setPerk_6_lvl(Constants.CURRENT_CONTEXT) + "/" + Constants.PERK_6_MAX_LVL));
            upgrade6StackTextView.setText(String.valueOf("Stack: +" + perkManager.setPerk_6_stack(Constants.CURRENT_CONTEXT) + " coins"));
            upgrade6CostTextView.setText(String.valueOf(format((long) perkManager.setPerk_6_cost(Constants.CURRENT_CONTEXT))));
        } else {
            upgrade6LevelBtn.setEnabled(false);
            upgrade6CostTextView.setText("MAX");
            upgrade6LevelBtn.setText("MAX");
            upgrade6StackTextView.setText(String.valueOf("Stack: +" + perkManager.setPerk_6_stack(Constants.CURRENT_CONTEXT) + " coins"));
        }
    }

    private void initialiseOnClick() {
        perkManager = new PassivePerkManager();
        highScore = new Preferences();
        shop = new Shop();
        coins = highScore.setCoinAmount(getContext());


        upgrade1LevelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (highScore.setCoinAmount(Constants.CURRENT_CONTEXT) >= Constants.PERK_1_COST && Constants.PERK_1_LVL < Constants.PERK_1_MAX_LVL) {

                    coins -= Constants.PERK_1_COST;

                    ((Shop) getActivity()).setCoinsTextView(coins);
                    //coinsTextView.setText("Coins: " + coins);
                    highScore.getCoinAmount(Constants.CURRENT_CONTEXT, coins);
                    Log.i(TAG, "onClick: " + coins);

                    Constants.PLAYER_SIZE -= (Constants.PLAYER_ORIGINAL_SIZE / 100) * 2.5;

                    Constants.PERK_1_LVL = (perkManager.setPerk_1_lvl(Constants.CURRENT_CONTEXT) + 1);
                    Constants.PERK_1_STACK = (perkManager.setPerk_1_stack(Constants.CURRENT_CONTEXT) + 2.5f);
                    Constants.PERK_1_COST = (int) (perkManager.setPerk_1_cost(Constants.CURRENT_CONTEXT) * 1.5f);
                    Constants.PLAYER_SIZE = Constants.PLAYER_SIZE + (int) ((Constants.PLAYER_SIZE / 100) * 2.5f);

                    perkManager.getPerk_1_lvl(Constants.CURRENT_CONTEXT, Constants.PERK_1_LVL);
                    perkManager.getPerk_1_stack(Constants.CURRENT_CONTEXT, Constants.PERK_1_STACK);
                    perkManager.getPerk_1_cost(Constants.CURRENT_CONTEXT, Constants.PERK_1_COST);
                    perkManager.getPerk_1_player_size(Constants.CURRENT_CONTEXT, Constants.PLAYER_SIZE);

                    upgrade1CostTextView.setText(String.valueOf(perkManager.setPerk_1_cost(Constants.CURRENT_CONTEXT)));
                    upgrade1LevelBtn.setText(perkManager.setPerk_1_lvl(Constants.CURRENT_CONTEXT) + "/" + Constants.PERK_1_MAX_LVL);
                    upgrade1StackTextView.setText("Stack: +" + perkManager.setPerk_1_stack(Constants.CURRENT_CONTEXT) + "%");

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
                if (highScore.setCoinAmount(Constants.CURRENT_CONTEXT) >= Constants.PERK_2_COST && Constants.PERK_2_LVL < Constants.PERK_2_MAX_LVL) {

                    coins -= Constants.PERK_2_COST;
                    ((Shop) getActivity()).setCoinsTextView(coins);
                    highScore.getCoinAmount(Constants.CURRENT_CONTEXT, coins);

                    //Constants.MPS_MULTIPLIER *= 1.1;
                    Constants.PERK_2_COST *= 1.5;
                    Constants.PERK_2_LVL++;
                    Constants.PERK_2_STACK += 1;

                    String formattedCost = format(Constants.PERK_2_COST);

                    Constants.PERK_2_LVL = (perkManager.setPerk_2_lvl(Constants.CURRENT_CONTEXT) + 1);
                    Constants.PERK_2_STACK = (perkManager.setPerk_2_stack(Constants.CURRENT_CONTEXT) + 1);
                    Constants.PERK_2_COST = (int) (perkManager.setPerk_2_cost(Constants.CURRENT_CONTEXT) * 1.5f);
                    Constants.MPS_MULTIPLIER = Constants.MPS_MULTIPLIER + ((Constants.MPS_MULTIPLIER / 100) * 1.1f);

                    perkManager.getPerk_2_lvl(Constants.CURRENT_CONTEXT, Constants.PERK_2_LVL);
                    perkManager.getPerk_2_stack(Constants.CURRENT_CONTEXT, Constants.PERK_2_STACK);
                    perkManager.getPerk_2_cost(Constants.CURRENT_CONTEXT, Constants.PERK_2_COST);
                    perkManager.getPerk_2_mps(Constants.CURRENT_CONTEXT, Constants.MPS_MULTIPLIER);

                    upgrade2CostTextView.setText(String.valueOf(perkManager.setPerk_2_cost(Constants.CURRENT_CONTEXT)));
                    upgrade2LevelBtn.setText(perkManager.setPerk_2_lvl(Constants.CURRENT_CONTEXT) + "/" + Constants.PERK_2_MAX_LVL);
                    upgrade2StackTextView.setText("Stack: +" + perkManager.setPerk_2_stack(Constants.CURRENT_CONTEXT) + "%");

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
                if (highScore.setCoinAmount(Constants.CURRENT_CONTEXT) >= Constants.PERK_3_COST && Constants.PERK_3_LVL < Constants.PERK_3_MAX_LVL) {

                    coins -= Constants.PERK_3_COST;
                    ((Shop) getActivity()).setCoinsTextView(coins);
                    highScore.getCoinAmount(Constants.CURRENT_CONTEXT, coins);

                    Constants.PERK_3_COST *= 1.5;
                    Constants.PERK_3_LVL++;
                    Constants.PERK_3_STACK += 10;

                    Constants.PERK_3_LVL = (perkManager.setPerk_3_lvl(Constants.CURRENT_CONTEXT) + 1);
                    Constants.PERK_3_STACK = (perkManager.setPerk_3_stack(Constants.CURRENT_CONTEXT) + 10);
                    Constants.PERK_3_COST = (int) (perkManager.setPerk_3_cost(Constants.CURRENT_CONTEXT) * 1.5f);

                    //long formattedCost = Integer.valueOf(format((long)Constants.PERK_3_COST));

                    perkManager.getPerk_3_lvl(Constants.CURRENT_CONTEXT, Constants.PERK_3_LVL);
                    perkManager.getPerk_3_stack(Constants.CURRENT_CONTEXT, Constants.PERK_3_STACK);
                    perkManager.getPerk_3_cost(Constants.CURRENT_CONTEXT, Constants.PERK_3_COST);

                    upgrade3CostTextView.setText(String.valueOf(format((long) perkManager.setPerk_3_cost(Constants.CURRENT_CONTEXT))));
                    upgrade3LevelBtn.setText(perkManager.setPerk_3_lvl(Constants.CURRENT_CONTEXT) + "/" + Constants.PERK_3_MAX_LVL);
                    upgrade3StackTextView.setText("Stack: +" + perkManager.setPerk_3_stack(Constants.CURRENT_CONTEXT) + " coins");
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
                if (highScore.setCoinAmount(Constants.CURRENT_CONTEXT) >= Constants.PERK_4_COST && Constants.PERK_4_LVL < Constants.PERK_4_MAX_LVL) {

                    coins -= Constants.PERK_4_COST;
                    ((Shop) getActivity()).setCoinsTextView(coins);
                    highScore.getCoinAmount(Constants.CURRENT_CONTEXT, coins);

                    Constants.PERK_4_COST *= 1.5;
                    Constants.PERK_4_LVL++;
                    Constants.PERK_4_STACK += 1;

                    Constants.PERK_4_LVL = (perkManager.setPerk_4_lvl(Constants.CURRENT_CONTEXT) + 1);
                    Constants.PERK_4_STACK = (perkManager.setPerk_4_stack(Constants.CURRENT_CONTEXT) + 1);
                    Constants.PERK_4_COST = (int) (perkManager.setPerk_4_cost(Constants.CURRENT_CONTEXT) * 1.5f);

                    //long formattedCost = Integer.valueOf(format((long)Constants.PERK_3_COST));

                    perkManager.getPerk_4_lvl(Constants.CURRENT_CONTEXT, Constants.PERK_4_LVL);
                    perkManager.getPerk_4_stack(Constants.CURRENT_CONTEXT, Constants.PERK_4_STACK);
                    perkManager.getPerk_4_cost(Constants.CURRENT_CONTEXT, Constants.PERK_4_COST);

                    upgrade4CostTextView.setText(String.valueOf(format((long) perkManager.setPerk_4_cost(Constants.CURRENT_CONTEXT))));
                    upgrade4LevelBtn.setText(perkManager.setPerk_4_lvl(Constants.CURRENT_CONTEXT) + "/" + Constants.PERK_4_MAX_LVL);
                    upgrade4StackTextView.setText("Stack: +" + perkManager.setPerk_4_stack(Constants.CURRENT_CONTEXT) + "%");
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
                if (highScore.setCoinAmount(Constants.CURRENT_CONTEXT) >= Constants.PERK_5_COST && Constants.PERK_5_LVL < Constants.PERK_5_MAX_LVL) {

                    coins -= Constants.PERK_5_COST;
                    ((Shop) getActivity()).setCoinsTextView(coins);
                    highScore.getCoinAmount(Constants.CURRENT_CONTEXT, coins);

                    Constants.PERK_5_COST *= 1.5;
                    String formattedCost = format(Constants.PERK_5_COST);
                    Constants.PERK_5_LVL++;
                    Constants.PERK_5_STACK += 2.5;
                    //Constants.PLAYER_GAP += (Constants.PLAYER_ORIGINAL_GAP / 100) * 2.5;

                    Constants.PERK_5_LVL = (perkManager.setPerk_5_lvl(Constants.CURRENT_CONTEXT) + 1);
                    Constants.PERK_5_STACK = (perkManager.setPerk_5_stack(Constants.CURRENT_CONTEXT) + 2.5f);
                    Constants.PERK_5_COST = (int) (perkManager.setPerk_5_cost(Constants.CURRENT_CONTEXT) * 1.5f);
                    Constants.PLAYER_GAP = (int) (Constants.PLAYER_GAP += ((Constants.PLAYER_ORIGINAL_GAP / 100) * 2.5));

                    //long formattedCost = Integer.valueOf(format((long)Constants.PERK_3_COST));

                    perkManager.getPerk_5_lvl(Constants.CURRENT_CONTEXT, Constants.PERK_5_LVL);
                    perkManager.getPerk_5_stack(Constants.CURRENT_CONTEXT, Constants.PERK_5_STACK);
                    perkManager.getPerk_5_cost(Constants.CURRENT_CONTEXT, Constants.PERK_5_COST);
                    perkManager.getPerk_5_player_gap(Constants.CURRENT_CONTEXT, Constants.PLAYER_GAP);


                    upgrade5CostTextView.setText(String.valueOf(format((long) perkManager.setPerk_5_cost(Constants.CURRENT_CONTEXT))));
                    upgrade5LevelBtn.setText(perkManager.setPerk_5_lvl(Constants.CURRENT_CONTEXT) + "/" + Constants.PERK_5_MAX_LVL);
                    upgrade5StackTextView.setText("Stack: +" + perkManager.setPerk_5_stack(Constants.CURRENT_CONTEXT) + "%");
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
                if (highScore.setCoinAmount(Constants.CURRENT_CONTEXT) >= Constants.PERK_6_COST && Constants.PERK_6_LVL < Constants.PERK_6_MAX_LVL) {

                    coins -= Constants.PERK_6_COST;
                    ((Shop) getActivity()).setCoinsTextView(coins);
                    highScore.getCoinAmount(Constants.CURRENT_CONTEXT, coins);

                    Constants.PERK_6_COST *= 1.5;
                    Constants.PERK_6_LVL++;
                    Constants.PERK_6_STACK += 1;
                    //Constants.COLLECT_AMOUNT++;

                    String formattedCost = format(Constants.PERK_6_COST);

                    Constants.PERK_6_LVL = (perkManager.setPerk_6_lvl(Constants.CURRENT_CONTEXT) + 1);
                    Constants.PERK_6_STACK = (perkManager.setPerk_6_stack(Constants.CURRENT_CONTEXT) + 1);
                    Constants.PERK_6_COST = (int) (perkManager.setPerk_6_cost(Constants.CURRENT_CONTEXT) * 1.5f);
                    Constants.COLLECT_AMOUNT = (perkManager.setPerk_6_collect_amount(Constants.CURRENT_CONTEXT) + 1);

                    //long formattedCost = Integer.valueOf(format((long)Constants.PERK_3_COST));

                    perkManager.getPerk_6_lvl(Constants.CURRENT_CONTEXT, Constants.PERK_6_LVL);
                    perkManager.getPerk_6_stack(Constants.CURRENT_CONTEXT, Constants.PERK_6_STACK);
                    perkManager.getPerk_6_cost(Constants.CURRENT_CONTEXT, Constants.PERK_6_COST);
                    perkManager.getPerk_6_collect_amount(Constants.CURRENT_CONTEXT, Constants.COLLECT_AMOUNT);

                    upgrade6CostTextView.setText(String.valueOf(format((long) perkManager.setPerk_6_cost(Constants.CURRENT_CONTEXT))));
                    upgrade6LevelBtn.setText(perkManager.setPerk_6_lvl(Constants.CURRENT_CONTEXT) + "/" + Constants.PERK_6_MAX_LVL);
                    upgrade6StackTextView.setText("Stack: +" + perkManager.setPerk_6_stack(Constants.CURRENT_CONTEXT) + " coins");
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
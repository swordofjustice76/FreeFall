package com.damoproductionsandroid.freefall;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static android.content.ContentValues.TAG;
import static android.os.Parcelable.CONTENTS_FILE_DESCRIPTOR;

public class ShopItemsFragment extends Fragment {

    Shop shop;

    TextView highScoreTextView;

    ImageView pickup1Img;
    Button pickup1Btn;
    TextView pickup1Duration;
    TextView pickup1Desc;

    ImageView pickup2Img;
    Button pickup2Btn;
    TextView pickup2Duration;
    TextView pickup2Desc;

    ImageView pickup3Img;
    Button pickup3Btn;
    TextView pickup3Duration;
    TextView pickup3Desc;

    ImageView pickup4Img;
    Button pickup4Btn;
    TextView pickup4Duration;
    TextView pickup4Desc;

    public boolean unlockedPerk1;
    public boolean unlockedPerk2;
    public boolean unlockedPerk3;
    public boolean unlockedPerk4;
    public boolean unlockedPerk5;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.shop_items_fragment, container, false);

        Typeface typeface = ResourcesCompat.getFont(getActivity(), R.font.pixel_font);

        highScoreTextView = view.findViewById(R.id.highscore_txt);

        pickup1Img = view.findViewById(R.id.pickup1_img);
        pickup1Btn = view.findViewById(R.id.pickup1_btn);
        pickup1Duration = view.findViewById(R.id.pickup1_duration_txt);
        pickup1Desc = view.findViewById(R.id.pickup1_desc_txt);

        pickup2Img = view.findViewById(R.id.pickup2_img);
        pickup2Btn = view.findViewById(R.id.pickup2_btn);
        pickup2Duration = view.findViewById(R.id.pickup2_duration_txt);
        pickup2Desc = view.findViewById(R.id.pickup2_desc_txt);

        pickup3Img = view.findViewById(R.id.pickup3_img);
        pickup3Btn = view.findViewById(R.id.pickup3_btn);
        pickup3Duration = view.findViewById(R.id.pickup3_duration_txt);
        pickup3Desc = view.findViewById(R.id.pickup3_desc_txt);

        pickup4Img = view.findViewById(R.id.pickup4_img);
        pickup4Btn = view.findViewById(R.id.pickup4_btn);
        pickup4Duration = view.findViewById(R.id.pickup4_duration_txt);
        pickup4Desc = view.findViewById(R.id.pickup4_desc_txt);

        initialiseView(typeface);

        return view;

    }


    private void initialiseView(Typeface typeface) {
        highScoreTextView.setTypeface(typeface);

        pickup1Btn.setTypeface(typeface);
        pickup1Duration.setTypeface(typeface);
        pickup1Desc.setTypeface(typeface);

        pickup2Btn.setTypeface(typeface);
        pickup2Duration.setTypeface(typeface);
        pickup2Desc.setTypeface(typeface);

        pickup3Btn.setTypeface(typeface);
        pickup3Duration.setTypeface(typeface);
        pickup3Desc.setTypeface(typeface);

        pickup4Btn.setTypeface(typeface);
        pickup4Duration.setTypeface(typeface);
        pickup4Desc.setTypeface(typeface);


        checkUnlockedPerk();
    }

    private void checkUnlockedPerk(){
        Preferences preferences = new Preferences();

        highScoreTextView.setText(String.valueOf("HighScore: " + preferences.setHighScore(getContext())));

        if (Constants.ITEM_1_UNLOCK_SCORE <= preferences.setHighScore(getContext())){
            pickup1Btn.setText("UNLOCKED");
            //Log.i(TAG, "YES");
        } else {
            pickup1Btn.setText("LOCKED: " + Constants.ITEM_1_UNLOCK_SCORE);
            pickup1Btn.setAlpha(0.4f);
        }

        if (Constants.ITEM_2_UNLOCK_SCORE <= preferences.setHighScore(getContext())){
            pickup2Btn.setText("UNLOCKED");
            //Log.i(TAG, "YES");
        } else {
            pickup2Btn.setText("LOCKED: " + Constants.ITEM_2_UNLOCK_SCORE);
            pickup2Btn.setAlpha(0.4f);
        }

        if (Constants.ITEM_3_UNLOCK_SCORE <= preferences.setHighScore(getContext())){
            pickup3Btn.setText("UNLOCKED");
            //Log.i(TAG, "YES");
        } else {
            pickup3Btn.setText("LOCKED: " + Constants.ITEM_3_UNLOCK_SCORE);
            pickup3Btn.setAlpha(0.4f);
        }

        if (Constants.ITEM_4_UNLOCK_SCORE <= preferences.setHighScore(getContext())){
            pickup4Btn.setText("UNLOCKED");
            //Log.i(TAG, "YES");
        } else {
            pickup4Btn.setText("LOCKED: " + Constants.ITEM_4_UNLOCK_SCORE);
            pickup4Btn.setAlpha(0.4f);
        }


    }
}



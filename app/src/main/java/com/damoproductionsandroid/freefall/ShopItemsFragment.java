package com.damoproductionsandroid.freefall;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.support.v4.content.res.ResourcesCompat;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ShopItemsFragment extends Activity {

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




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.shop_items_fragment);

        initialiseView();
    }

    private void initialiseView() {
        Typeface typeface = ResourcesCompat.getFont(getApplicationContext(), R.font.pixel_font);

        pickup1Img = findViewById(R.id.pickup1_img);
        pickup1Btn = findViewById(R.id.pickup1_btn);
        pickup1Duration = findViewById(R.id.pickup1_duration_txt);
        pickup1Desc = findViewById(R.id.pickup1_desc_txt);

        pickup2Img = findViewById(R.id.pickup2_img);
        pickup2Btn = findViewById(R.id.pickup2_btn);
        pickup2Duration = findViewById(R.id.pickup2_duration_txt);
        pickup2Desc = findViewById(R.id.pickup2_desc_txt);

        pickup3Img = findViewById(R.id.pickup3_img);
        pickup3Btn = findViewById(R.id.pickup3_btn);
        pickup3Duration = findViewById(R.id.pickup3_duration_txt);
        pickup3Desc = findViewById(R.id.pickup3_desc_txt);

        pickup4Img = findViewById(R.id.pickup4_img);
        pickup4Btn = findViewById(R.id.pickup4_btn);
        pickup4Duration = findViewById(R.id.pickup4_duration_txt);
        pickup4Desc = findViewById(R.id.pickup4_desc_txt);

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
    }
}

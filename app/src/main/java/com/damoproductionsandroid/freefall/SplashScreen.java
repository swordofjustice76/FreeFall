package com.damoproductionsandroid.freefall;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.TextView;

public class SplashScreen extends Activity {

    Button playBtn;
    Button shopBtn;
    TextView playTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.splash_screen);

        playBtn = findViewById(R.id.play_btn);
        shopBtn = findViewById(R.id.shop_btn);

        Typeface typeface = ResourcesCompat.getFont(getApplicationContext(), R.font.pixel_font);
        playBtn.setTypeface(typeface);
        shopBtn.setTypeface(typeface);


        final ScaleAnimation growAnim = new ScaleAnimation(1.0f, 1.15f, 1.0f, 1.15f, Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F);
        final ScaleAnimation shrinkAnim = new ScaleAnimation(1.15f, 1.0f, 1.15f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F);

        growAnim.setDuration(250);
        shrinkAnim.setDuration(250);

       // playBtn.setAnimation(growAnim);
        //shopBtn.setAnimation(growAnim);
        growAnim.start();

        growAnim.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation){}

            @Override
            public void onAnimationRepeat(Animation animation){}

            @Override
            public void onAnimationEnd(Animation animation)
            {
                playBtn.setAnimation(shrinkAnim);
                //shopBtn.setAnimation(shrinkAnim);
                shrinkAnim.start();
            }
        });
        shrinkAnim.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation){}

            @Override
            public void onAnimationRepeat(Animation animation){}

            @Override
            public void onAnimationEnd(Animation animation)
            {
                playBtn.setAnimation(growAnim);
                //shopBtn.setAnimation(growAnim);
                growAnim.start();
            }
        });

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);

            }
        });

        shopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Shop.class);
                startActivity(intent);
            }
        });
    }


}

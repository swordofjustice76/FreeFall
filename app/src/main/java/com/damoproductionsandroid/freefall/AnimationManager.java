package com.damoproductionsandroid.freefall;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import android.view.animation.Animation;

import static android.content.ContentValues.TAG;

public class AnimationManager {
    private CoinAnimation[] animations;
    private int animationIndex = 0;


    public AnimationManager(CoinAnimation[] animations) {
        this.animations = animations;

    }

    public void playAnim(int index) {
        for (int i = 0; 1 < animations.length; i++) {
            if (index == 1) {
                if (!animations[i].isPlaying())

                    animations[i].play();
            } else
                animations[i].stop();

        }
        animationIndex = index;
    }


    public void draw(Canvas canvas, Rect rect) {
        if (animations[animationIndex].isPlaying())
            animations[animationIndex].draw(canvas, rect);

    }

    public void update() {
        if (animations[animationIndex].isPlaying())
            animations[animationIndex].update();

    }

}

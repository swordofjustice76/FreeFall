package com.damoproductionsandroid.freefall;

import android.graphics.Canvas;
import android.graphics.Rect;

public class AnimationManager {
    private CoinAnimation[] animations;
    private Upgrade1Animation[] animationsUpgrade1;
    private int animationIndex = 0;
    private int animationIndexUpgrade1 = 0;


    public AnimationManager(CoinAnimation[] animations, Upgrade1Animation[] animationsUpgrade1) {
        this.animations = animations;
        this.animationsUpgrade1 = animationsUpgrade1;

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

        for (int d = 0; 1 < animationsUpgrade1.length; d++) {
            if (index == 1) {
                if (!animationsUpgrade1[d].isPlaying())

                    animationsUpgrade1[d].play();
            } else
                animationsUpgrade1[d].stop();
        }
        animationIndexUpgrade1 = index;
    }


    public void draw(Canvas canvas, Rect rect) {

        if (animationsUpgrade1[animationIndexUpgrade1].isPlaying())
            animationsUpgrade1[animationIndexUpgrade1].draw(canvas, rect);

        // if (animations[animationIndex].isPlaying())
       //      animations[animationIndex].draw(canvas, rect);

    }

    public void draw2(Canvas canvas, Rect rect) {


        // if (animations[animationIndex].isPlaying())
            animations[animationIndex].draw(canvas, rect);

    }

    public void update() {
        if (animations[animationIndex].isPlaying()) {
            animations[animationIndex].update();
        }
        if (animationsUpgrade1[animationIndexUpgrade1].isPlaying()) {
            animationsUpgrade1[animationIndexUpgrade1].update();
        }
    }

}

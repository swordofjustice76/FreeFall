package com.damoproductionsandroid.freefall;

import android.graphics.Canvas;
import android.graphics.Rect;

public class AnimationManager {
    private CoinAnimation[] animations;
    private BigGapAnimation[] animationsUpgrade1;
    private ShrinkPlayerAnimation[] shrinkPlayerAnimation;
    private DoubleCoinsAnimation[] doubleCoinsAnimation;
    private DoubleScoreAnimation[] doubleScoreAnimation;
    private int animationIndex = 0;
    private int animationIndexUpgrade1 = 0;
    private int shrinkPlayerAnimationIndex = 0;
    private int doubleCoinAnimationIndex = 0;
    private int doubleScoreAnimationIndex = 0;


    public AnimationManager(CoinAnimation[] animations, BigGapAnimation[] animationsUpgrade1,
                            ShrinkPlayerAnimation[] shrinkPlayerAnimation, DoubleCoinsAnimation[] doubleCoinsAnimation, DoubleScoreAnimation[] doubleScoreAnimation) {

        this.animations = animations;
        this.animationsUpgrade1 = animationsUpgrade1;
        this.shrinkPlayerAnimation = shrinkPlayerAnimation;
        this.doubleCoinsAnimation = doubleCoinsAnimation;
        this.doubleScoreAnimation = doubleScoreAnimation;

    }

    public void playAnim(int index) {
        for (int i = 0; i < animations.length; i++) {
            if (i == index) {
                if (!animations[i].isPlaying())

                    animations[i].play();
            } else
                animations[i].stop();
        }
        animationIndex = index;

        for (int d = 0; d < animationsUpgrade1.length; d++) {
            if (index == d) {
                if (!animationsUpgrade1[d].isPlaying())

                    animationsUpgrade1[d].play();
            } else
                animationsUpgrade1[d].stop();
        }
        animationIndexUpgrade1 = index;

        for (int e = 0; e < shrinkPlayerAnimation.length; e++) {
            if (index == e) {
                if (!shrinkPlayerAnimation[index].isPlaying())

                    shrinkPlayerAnimation[e].play();
            } else
                shrinkPlayerAnimation[e].stop();
        }
        shrinkPlayerAnimationIndex = index;

        for (int r = 0; r < doubleCoinsAnimation.length; r++) {
            if (index == r) {
                if (!doubleCoinsAnimation[index].isPlaying())

                    doubleCoinsAnimation[r].play();
            } else
                doubleCoinsAnimation[r].stop();
        }
        doubleCoinAnimationIndex = index;

        for (int g = 0; g < doubleScoreAnimation.length; g++) {
            if (index == g) {
                if (!doubleScoreAnimation[index].isPlaying())

                    doubleScoreAnimation[g].play();
            } else
                doubleScoreAnimation[g].stop();
        }
        doubleScoreAnimationIndex = index;
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

    public void draw3(Canvas canvas, Rect rect) {


        // if (animations[animationIndex].isPlaying())
        shrinkPlayerAnimation[shrinkPlayerAnimationIndex].draw(canvas, rect);

    }

    public void drawDoubleCoins(Canvas canvas, Rect rect) {


        // if (animations[animationIndex].isPlaying())
        doubleCoinsAnimation[doubleCoinAnimationIndex].draw(canvas, rect);
    }

    public void drawDoubleScore(Canvas canvas, Rect rect) {


        // if (animations[animationIndex].isPlaying())
        doubleScoreAnimation[doubleScoreAnimationIndex].draw(canvas, rect);

    }

    public void update() {
        if (animations[animationIndex].isPlaying()) {
            animations[animationIndex].update();
        }
        if (animationsUpgrade1[animationIndexUpgrade1].isPlaying()) {
            animationsUpgrade1[animationIndexUpgrade1].update();
        }
        if (shrinkPlayerAnimation[shrinkPlayerAnimationIndex].isPlaying()) {
            shrinkPlayerAnimation[shrinkPlayerAnimationIndex].update();
        }

        if (doubleCoinsAnimation[doubleCoinAnimationIndex].isPlaying()) {
            doubleCoinsAnimation[doubleCoinAnimationIndex].update();
        }
        if (doubleScoreAnimation[doubleScoreAnimationIndex].isPlaying()) {
            doubleScoreAnimation[doubleScoreAnimationIndex].update();
        }
    }

}

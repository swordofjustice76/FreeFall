package com.damoproductionsandroid.freefall;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.CountDownTimer;
import android.os.Looper;

public class BigGapUpgrade implements GameObject {

    private Rect rectangle;
    private int colour;
    public BigGapAnimation animation;
    private AnimationManager animManager;


    public Rect getRectangle() {
        return rectangle;
    }

    public BigGapUpgrade (int rectHeight, int colour, int startX, int startY){

        this.colour = colour;
        rectangle = new Rect(startX, startY, startX + rectHeight, startY + rectHeight);

        BitmapFactory bf = new BitmapFactory();
        Bitmap frame1 = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.upgrade_frame_1);

        animation = new BigGapAnimation(new Bitmap[]{frame1}, 0.2f);
        animManager = new AnimationManager(new CoinAnimation[]{}, new BigGapAnimation[]{animation}, new ShrinkPlayerAnimation[]{}, new DoubleCoinsAnimation[]{}, new DoubleScoreAnimation[]{});
    }

   public boolean playerCollectUpgrade(Player player){
       if(Rect.intersects(rectangle, player.getRectangle())){
       }

        return Rect.intersects(rectangle, player.getRectangle());
   }

    public  void incrementY (float y){
        rectangle.top += y;
        rectangle.bottom += y;
    }

    @Override
    public void draw(Canvas canvas) {
       animManager.draw(canvas, rectangle);
    }


    @Override
    public void update() {
       int state = 1;
       animManager.playAnim(state);
       animManager.update();
    }
}

package com.damoproductionsandroid.freefall;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Coin implements GameObject {

    private Rect rectangle;
    private int colour;
     private CoinAnimation animation;
     private AnimationManager animManager;
     //private BigGapUpgrade bigGapUpgrade;


     public Rect getRectangle() {
        return rectangle;
    }


    public Coin(int rectHeight, int colour, int startX, int startY) {
        this.colour = colour;
        //l, t, r, b
        rectangle = new Rect(startX, startY, startX + rectHeight, startY - rectHeight);
        BitmapFactory bf = new BitmapFactory();
        Bitmap frame1 = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.coin_frame_1);
        Bitmap frame2 = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.coin_frame_2);
        Bitmap frame3 = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.coin_frame_3);
        Bitmap frame4 = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.coin_frame_4);
        Bitmap frame5 = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.coin_frame_5);
        Bitmap frame6 = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.coin_frame_6);
        Bitmap frame7 = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.coin_frame_7);
        Bitmap frame8 = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.coin_frame_8);


        animation = new CoinAnimation(new Bitmap[]{frame1, frame2, frame3, frame4, frame5, frame6, frame7, frame8}, 0.2f);

        animManager = new AnimationManager(new CoinAnimation[]{animation}, new BigGapAnimation[]{}, new ShrinkPlayerAnimation[]{}, new DoubleCoinsAnimation[]{});

    }

    public  void incrementY (float y){
        rectangle.top += y;
        rectangle.bottom += y;
    }



    public boolean playerCollect(Player player) {

        return Rect.intersects(rectangle, player.getRectangle());
    }

    @Override
    public void draw(Canvas canvas) {
       // Paint paint = new Paint();
       // paint.setColor(colour);
       // canvas.drawRect(rectangle, paint);
        animManager.draw2(canvas, rectangle);
    }


    @Override
    public void update() {

         int state = 1;
        animManager.playAnim(state);
        animManager.update();
    }
}

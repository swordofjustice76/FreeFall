package com.damoproductionsandroid.freefall;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class DoubleCoinsUpgrade implements GameObject {

    private Rect rectangle;
    private int colour;
    public DoubleCoinsAnimation animation;
    private AnimationManager animManager;

    public Rect getRectangle() {
        return rectangle;
    }

    public DoubleCoinsUpgrade(int rectSize, int startX, int startY, int colour) {

        this.colour = colour;
        rectangle = new Rect(startX, startY, startX + rectSize, startY + rectSize);
        BitmapFactory bf = new BitmapFactory();
        Bitmap frame1 = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.double_coins_frame_1);

        animation = new DoubleCoinsAnimation(new Bitmap[]{frame1}, 0.2f);

        animManager = new AnimationManager(new CoinAnimation[]{}, new BigGapAnimation[]{}, new ShrinkPlayerAnimation[]{}, new DoubleCoinsAnimation[]{animation});
    }


    public boolean playerCollectUpgrade(Player player) {
        return Rect.intersects(rectangle, player.getRectangle());
    }


    public void incrementY(float y) {
        rectangle.top += y;
        rectangle.bottom += y;
    }


    @Override
    public void draw(Canvas canvas) {
       // Paint paint = new Paint();
       // paint.setColor(Color.LTGRAY);
        //canvas.drawRect(rectangle, paint);
        animManager.drawDoubleCoins(canvas, rectangle);

    }


    @Override
    public void update() {
        int state = 1;
        animManager.playAnim(state);
        animManager.update();
    }
}

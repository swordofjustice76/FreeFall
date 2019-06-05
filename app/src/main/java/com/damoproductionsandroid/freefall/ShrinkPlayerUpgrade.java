package com.damoproductionsandroid.freefall;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class ShrinkPlayerUpgrade implements GameObject {

    private Rect rectangle;
    public ShrinkPlayerAnimation animation;
    private AnimationManager animManager;


    public Rect getRectangle() {
        return rectangle;
    }

    public ShrinkPlayerUpgrade(int rectHeight, int colour, int startX, int startY) {

        int colour1 = colour;
        rectangle = new Rect(startX, startY, startX + rectHeight, startY + rectHeight);

        BitmapFactory bf = new BitmapFactory();
        Bitmap frame1 = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.shrink_player_frame_1);

        animation = new ShrinkPlayerAnimation(new Bitmap[]{frame1}, 0.2f);

        animManager = new AnimationManager(new CoinAnimation[]{}, new BigGapAnimation[]{}, new ShrinkPlayerAnimation[]{animation}, new DoubleCoinsAnimation[]{});
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
        //Paint paint = new Paint();
       // paint.setColor(Color.MAGENTA);
        //canvas.drawRect(rectangle, paint);
        animManager.draw3(canvas, rectangle);

    }

    @Override
    public void update() {
        int state = 1;
        animManager.playAnim(state);
        animManager.update();
    }


}

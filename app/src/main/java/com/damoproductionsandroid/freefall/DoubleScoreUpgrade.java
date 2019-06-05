package com.damoproductionsandroid.freefall;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class DoubleScoreUpgrade implements GameObject {

    private Rect rectangle;
    private int colour;
    public DoubleScoreAnimation animation;
    private AnimationManager animManager;

    public DoubleScoreUpgrade(int rectSize, int startX, int startY, int colour) {
        rectangle = new Rect(startX, startY, startX + rectSize, startY + rectSize);
        this.colour = colour;
        BitmapFactory bf = new BitmapFactory();
        Bitmap frame1 = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.double_score_frame_1);

        animation = new DoubleScoreAnimation(new Bitmap[]{frame1}, 0.2f);

        animManager = new AnimationManager(new CoinAnimation[]{}, new BigGapAnimation[]{}, new ShrinkPlayerAnimation[]{}, new DoubleCoinsAnimation[]{}, new DoubleScoreAnimation[]{animation});
    }

    public boolean playerCollectUpgrade(Player player){
        return Rect.intersects(rectangle, player.getRectangle());
    }

    public void incrementY(float y) {
        rectangle.top += y;
        rectangle.bottom += y;
    }

    public Rect getRectangle() {
        return rectangle;
    }

    @Override
    public void draw(Canvas canvas) {
       // Paint paint = new Paint();
       // paint.setColor(Color.CYAN);
        //canvas.drawRect(rectangle, paint);
        animManager.drawDoubleScore(canvas, rectangle);
    }

    @Override
    public void update() {
        int state = 1;
        animManager.playAnim(state);
        animManager.update();
    }
}

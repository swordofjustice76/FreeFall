package com.damoproductionsandroid.freefall;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class DoubleScoreUpgrade implements GameObject {

    private Rect rectangle;
    private int colour;

    public DoubleScoreUpgrade(int rectSize, int startX, int startY, int colour) {
        rectangle = new Rect(startX, startY, startX + rectSize, startY + rectSize);
        this.colour = colour;
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
        Paint paint = new Paint();
        paint.setColor(Color.CYAN);
        canvas.drawRect(rectangle, paint);
    }

    @Override
    public void update() {

    }
}

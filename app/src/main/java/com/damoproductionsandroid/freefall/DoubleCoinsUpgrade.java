package com.damoproductionsandroid.freefall;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class DoubleCoinsUpgrade implements GameObject {

    private Rect rectangle;
    private int colour;

    public Rect getRectangle() {
        return rectangle;
    }

    public DoubleCoinsUpgrade(int rectSize, int startX, int startY, int colour) {

        this.colour = colour;
        rectangle = new Rect(startX, startY, startX + rectSize, startY + rectSize);

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
        Paint paint = new Paint();
        paint.setColor(Color.LTGRAY);
        canvas.drawRect(rectangle, paint);

    }


    @Override
    public void update() {

    }
}

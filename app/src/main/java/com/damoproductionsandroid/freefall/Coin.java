package com.damoproductionsandroid.freefall;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Coin implements GameObject {

    private Rect rectangle;
    private int colour;

    public Rect getRectangle() {
        return rectangle;
    }

    public Coin(Rect rectangle, int colour) {
        this.colour = colour;
        rectangle = new Rect(0, 0, 50, 50);
    }


    public boolean playerCollect(Player player) {
        return Rect.intersects(rectangle, player.getRectangle());
    }

    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(colour);
        canvas.drawRect(rectangle, paint);
    }

    @Override
    public void update() {

    }


}

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
        rectangle = new Rect(100, 100, 150, 150);
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
        Paint paint = new Paint();
        paint.setColor(colour);
        canvas.drawRect(rectangle, paint);
    }

    @Override
    public void update() {

    }


}

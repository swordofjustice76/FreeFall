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


    public Coin(int rectHeight, int colour, int startX, int startY) {
        this.colour = colour;
        //l, t, r, b
        rectangle = new Rect(startX, startY, startX + rectHeight, startY - rectHeight);
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

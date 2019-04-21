package com.damoproductionsandroid.freefall;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class bigGapUpgrade implements GameObject {

    private Rect rectangle;
    private int colour;

    public Rect getRectangle() {
        return rectangle;
    }

    public bigGapUpgrade (int rectHeight, int startX, int startY, int colour){
        this.colour = colour;

        rectangle = new Rect(startX, startY, startX + rectHeight, startY + rectHeight);
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

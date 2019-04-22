package com.damoproductionsandroid.freefall;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class BigGapUpgrade implements GameObject {

    private Rect rectangle;
    private int colour;

    public Rect getRectangle() {
        return rectangle;
    }

    public BigGapUpgrade (int rectHeight, int colour, int startX, int startY){
        this.colour = colour;
        rectangle = new Rect(startX, startY, startX + rectHeight, startY + rectHeight);
    }

   public boolean playerCollectUpgrade(Player player){
        return Rect.intersects(rectangle, player.getRectangle());
   }

    public  void incrementY (float y){
        rectangle.top += y;
        rectangle.bottom += y;
    }

    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawRect(rectangle, paint);



    }

    @Override
    public void update() {

    }
}

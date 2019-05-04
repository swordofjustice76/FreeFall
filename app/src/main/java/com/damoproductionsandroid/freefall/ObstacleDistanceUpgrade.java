package com.damoproductionsandroid.freefall;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class ObstacleDistanceUpgrade implements GameObject {

    private Rect rect;
    private int colour;


    public Rect getRect() {
        return rect;
    }

    public ObstacleDistanceUpgrade(int rectSize, int startX, int startY, int colour) {

        this.colour = colour;
        rect = new Rect(startX, startY, startX + rectSize, startY + rectSize);
    }

    public boolean playerCollectUpgrade(Player player){
        return Rect.intersects(rect, player.getRectangle());
    }

    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        canvas.drawRect(rect, paint);
    }

    public  void incrementY (float y){
        rect.top += y;
        rect.bottom += y;
    }


    @Override
    public void update() {

    }
}

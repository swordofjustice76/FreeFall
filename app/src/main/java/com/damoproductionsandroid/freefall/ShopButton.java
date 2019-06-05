package com.damoproductionsandroid.freefall;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v7.app.AppCompatActivity;

public class ShopButton implements GameObject {
    private RectF rectangle;
    private int colour;


    public RectF getRectangle(){
        return rectangle;
    }

    public ShopButton(RectF rectangle, int colour){
        this.rectangle = rectangle;
        this.colour = colour;
    }

    @Override
    public void draw(Canvas canvas){
        Paint paint = new Paint();
        paint.setARGB(0,203, 203, 203);
        //paint.setColor(R.color.colourButton);
        //paint.setAlpha(20);
        canvas.drawRoundRect(rectangle, 10, 10, paint);
    }



    public void update() {
        int x = (Constants.SCREEN_WIDTH / 2) - (288 / 2);
        int y = 6 * Constants.SCREEN_HEIGHT / 9;

        rectangle.set(x - 40,
                y - (65 + 40),
                x + (288 + 40),
                y + 40);

       // 288 65


        //canvas.drawRect(, shopButtonPoint.y - (float)(shopText.height() + 40), , y + 40, myPaint);
    }



}



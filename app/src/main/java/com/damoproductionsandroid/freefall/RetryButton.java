package com.damoproductionsandroid.freefall;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class RetryButton implements GameObject {

    private RectF rectangle;
    private int colour;


        public RectF getRectangle(){
            return rectangle;
        }

        public RetryButton(RectF rectangle, int colour){
            this.rectangle = rectangle;
            this.colour = colour;
        }

        @Override
        public void draw(Canvas canvas){
            Paint paint = new Paint();
            paint.setColor(Color.WHITE);
            paint.setAlpha(20);
            canvas.drawRoundRect(rectangle, 10, 10, paint);
        }


    @Override
        public void update() {
            int x = (Constants.SCREEN_WIDTH / 2) - (288 / 2);
            int y = 6 * Constants.SCREEN_HEIGHT / 9;

        rectangle.set(x - 80,
                y - (65 + 40) - 200,
                x + (362),
                y + 40 - 200);

            // 288 65


            //canvas.drawRect(, shopButtonPoint.y - (float)(shopText.height() + 40), , y + 40, myPaint);
        }



    }


package com.damoproductionsandroid.freefall;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.animation.Animation;

import static android.content.ContentValues.TAG;

public class ShrinkPlayerAnimation extends Animation {
    private Bitmap[] frames;
    private int frameIndex;

    private boolean isPlaying = true;

    public boolean isPlaying() {
        return isPlaying;
    }

    public void play() {
        isPlaying = true;
        frameIndex = 0;
        lastFrame = System.currentTimeMillis();
    }

    public void stop() {
        isPlaying = false;
    }


    private float frameTime;

    private long lastFrame;

    public ShrinkPlayerAnimation(Bitmap[] frames, float animTime) {
        this.frames = frames;
        frameIndex = 0;

        frameTime = animTime / frames.length;

        lastFrame = System.currentTimeMillis();
    }

    public void draw(Canvas canvas, Rect destination) {
        if (!isPlaying) {
            return;
        }

        scaleRect(destination);

        canvas.drawBitmap(frames[frameIndex], null, destination, new Paint());

    }

    private void scaleRect(Rect rect) {
        float whRatio = (float) frames[frameIndex].getWidth() / (float)frames[frameIndex].getHeight();
        if (rect.top > rect.height())
            rect.left = rect.right - (int) (rect.height() * (whRatio));
        else
            rect.top = rect.bottom - (int) (rect.width() * (1/whRatio));
    }

    public void update() {
        if (!isPlaying) {
            return;
        }

        if (System.currentTimeMillis() - lastFrame > frameTime * 1000) {
            frameIndex++;
            frameIndex = frameIndex >= frames.length ? 0 : frameIndex;
            lastFrame = System.currentTimeMillis();
        }
    }
}

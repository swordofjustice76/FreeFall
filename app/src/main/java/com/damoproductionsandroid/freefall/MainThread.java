package com.damoproductionsandroid.freefall;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread extends Thread {
    private int FPS = 60;
    private double averageFPS;
    private final SurfaceHolder surfaceHolder;
    private GamePanel gamePanel;
    public volatile boolean running;
    public boolean runUpdate = true;
    public static Canvas canvas;

    public void setStop(boolean stop) {
        if (stop = true){
            currentThread().interrupt();
        }
    }

    public boolean stop;

    public void setRunning(boolean running) {
        this.running = running;
    }

    public MainThread(SurfaceHolder surfaceHolder, GamePanel gamePanel) {
        super();
        this.surfaceHolder = surfaceHolder;
        this.gamePanel = gamePanel;
    }

    @Override
    public void run() {
        long startTime;
        long timeMillis;
        long waitTime;
        long totalTime = 0;
        int frameCount = 0;
        long targetTime = 1000 / FPS;

        if (!running) return;

        while (running) {


            startTime = System.nanoTime();
            canvas = null;


            //try locking the canvas for pixel editing
            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {

                        this.gamePanel.update();
                        this.gamePanel.draw(canvas);


                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (canvas != null) {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }


            timeMillis = (System.nanoTime() - startTime) / 1000000;
            waitTime = targetTime - timeMillis;

            try {
                if (waitTime > 0) {
                    this.sleep(waitTime);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            totalTime += System.nanoTime() - startTime;
            frameCount++;
            if (frameCount == FPS) {
                averageFPS = 1000 / ((totalTime / frameCount) / 1000000);
                frameCount = 0;
                totalTime = 0;
                System.out.println(averageFPS);
            }

            if (Thread.interrupted()) {
                try {
                    if (Thread.interrupted()) {
                        throw new InterruptedException();
                    }
                    while (!Thread.currentThread().isInterrupted()) {
                        // ...
                    }
                } catch (InterruptedException e) {

                }

            }

        }
    }
}

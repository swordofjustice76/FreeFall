package com.damoproductionsandroid.freefall;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {
    public static final int WIDTH = 856;
    public static final int HEIGHT = 480;
    public static final int MOVESPEED = -5;

    private Rect coinsText = new Rect();

    private Rect r = new Rect();

    private MainThread thread;

    private Player player;
    private Point playerPoint;
    private ObstacleManager obstacleManager;
    private ItemManager itemManager;
    private Gravity gravity;

    private boolean movingPlayer = false;

    private boolean gameOver = false;
    private long gameOverTime;

    private boolean coinChange = false;
    private int coins;
    private Canvas canvas;


    public GamePanel(Context context) {
        super(context);

        //add the callback to the surfaceholder to intercept events
        getHolder().addCallback(this);

        thread = new MainThread(getHolder(), this);

        player = new Player(new Rect(100, 100, 200, 200), Color.rgb(255, 0, 0));
        playerPoint = new Point(Constants.SCREEN_WIDTH/2, 3*Constants.SCREEN_HEIGHT/4);
        player.update(playerPoint);

        obstacleManager = new ObstacleManager(200, 350, 75, Color.WHITE);
        itemManager = new ItemManager(350, 200, 50, Color.YELLOW);
        //gravity = new Gravity(200, 350, 75, Color.WHITE);
        //make gamePanel focusable so it can handle events
        setFocusable(true);
    }

    public void reset(){
        playerPoint = new Point(Constants.SCREEN_WIDTH/2, 3*Constants.SCREEN_HEIGHT/4);
        player.update(playerPoint);
        obstacleManager = new ObstacleManager(200, 350, 75, Color.WHITE);
        itemManager = new ItemManager(350, 200, 50, Color.YELLOW);
        //gravity = new Gravity(200, 350, 75, Color.WHITE);
        movingPlayer = false;
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (true) {
            try {
                thread.setRunning(false);
                thread.join();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            retry = false;
        }

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        thread = new MainThread(getHolder(), this);
        //player = new Player(BitmapFactory.decodeResource(getResources(), R.drawable.helicopter), 65, 25, 3);
        //we can safely start the game loop
        thread.setRunning(true);
        thread.start();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (!gameOver && player.getRectangle().contains((int) event.getX(), (int) event.getY()))
                    movingPlayer = true;
                if (gameOver && System.currentTimeMillis() - gameOverTime >= 2000) {
                    reset();
                    gameOver = false;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (!gameOver && movingPlayer)
                    playerPoint.set((int) event.getX(), (int) event.getY());
                break;
            case MotionEvent.ACTION_UP:
                movingPlayer = false;
                break;
        }

        return true;
        //return super.onTouchEvent(event);
    }

    public void update() {
        if (!gameOver) {
            player.update(playerPoint);
            obstacleManager.update();
            itemManager.update();
            if (obstacleManager.playerCollide(player)) {
                gameOver = true;
                gameOverTime = System.currentTimeMillis();
            }
            if (itemManager.playerCollect(player)) {
                coins++;
                coinChange = true;
            }
        }


    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        canvas.drawColor(getResources().getColor(R.color.colourBackground));

        player.draw(canvas);
        obstacleManager.draw(canvas);
        itemManager.draw(canvas);


        if (gameOver) {
            Paint paint = new Paint();
            paint.setTextSize(100);
            paint.setColor(Color.GRAY);
            drawGameOverText(canvas, paint, "Game Over");
        }

        if (coinChange) {
            Paint paint = new Paint();
            paint.setTextSize(75);
            paint.setColor(Color.YELLOW);
            drawCoinsText(canvas, paint, "Coins: " + coins);
        }
    }

    private void drawGameOverText(Canvas canvas, Paint paint, String text) {
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.getClipBounds(r);
        int cHeight = r.height();
        int cWidth = r.width();
        paint.getTextBounds(text, 0, text.length(), r);
        float x = cWidth / 2f - r.width() / 2f - r.left;
        float y = cHeight / 2f + r.height() / 2f - r.bottom;
        canvas.drawText(text, x, y, paint);
    }

    public void drawCoinsText(Canvas canvas, Paint paint, String text) {
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.getClipBounds(coinsText);
        int cHeight = coinsText.height();
        int cWidth = coinsText.width();
        paint.getTextBounds(text, 0, text.length(), coinsText);
        float x = 50;
        float y = 50 + coinsText.height();
        canvas.drawText(text, x, y, paint);

    }
}
package com.damoproductionsandroid.freefall;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Timer;
import java.util.TimerTask;


public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {


    private Rect coinsText = new Rect();
    public Rect metersText = new Rect();

    public Rect highScore = new Rect();



    MainActivity mainActivity;


    private Rect r = new Rect();

    private MainThread thread;

    private Player player;
    private Point playerPoint;
    private ObstacleManager obstacleManager;
    private ItemManager itemManager;
    private SoundManager soundManager;
    private HighScore highScoreHandler;
    private ItemSpawner itemSpawner;
    private ObjectLogic gravity;
    private BigGapUpgrade bigGapUpgrade;

    private boolean movingPlayer = false;

    private boolean gameOver = false;
    private long gameOverTime;

    private boolean coinSave = false;
    private int coins;

    private Canvas canvas;

    private int meters;
    private boolean playing = false;


    public GamePanel(Context context) {

        super(context);



        //add the callback to the surfaceholder to intercept events
        getHolder().addCallback(this);

        thread = new MainThread(getHolder(), this);
        soundManager = new SoundManager(context);
        itemSpawner = new ItemSpawner(325, 400, 75, Color.YELLOW);
        player = new Player(new Rect(100, 100, 250, 250), Color.rgb(255, 0, 0));
        playerPoint = new Point(Constants.SCREEN_WIDTH / 2, 3 * Constants.SCREEN_HEIGHT / 4);
        player.update(playerPoint);

        obstacleManager = new ObstacleManager(325, 400, 75, Color.WHITE);
        itemManager = new ItemManager(400, 325, 75, Color.YELLOW);

        highScoreHandler = new HighScore();


        //make gamePanel focusable so it can handle events
        setFocusable(true);




    }


    public void reset() {
        playerPoint = new Point(Constants.SCREEN_WIDTH / 2, 3 * Constants.SCREEN_HEIGHT / 4);
        player.update(playerPoint);
        obstacleManager = new ObstacleManager(Constants.PLAYER_GAP, 400, 75, Color.WHITE);
        itemManager = new ItemManager(400, Constants.PLAYER_GAP, 75, Color.YELLOW);
        highScoreHandler.setHighScore(getContext());

        movingPlayer = false;
        meters = 0;
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

        //we can safely start the game loop
        thread.setRunning(true);
        thread.start();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (!gameOver)
                    movingPlayer = true;
                if (gameOver && System.currentTimeMillis() - gameOverTime >= 2000) {
                    reset();
                    gameOver = false;

                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (!gameOver && movingPlayer)
                    playerPoint.set((int) event.getX(), 3 * Constants.SCREEN_HEIGHT / 4);
                break;
            case MotionEvent.ACTION_UP:
                movingPlayer = false;
                break;
        }

        return true;
    }


    public void update() {



        if(!playing){

            playing = true;
            soundManager.playPowerUpSound();
        }

        if (!gameOver) {
            player.update(playerPoint);
            obstacleManager.update();
            itemManager.update();
            //metres++;
            if (obstacleManager.playerCollide(player)) {
                gameOver = true;
                gameOverTime = System.currentTimeMillis();
                soundManager.playGameOver();
            }
            if (itemManager.playerCollect(player)) {
                soundManager.playCoinCollectSound();
                coins++;
                coinSave = true;
            }
            if (itemManager.playerCollectPlayerGapUpgrade(player)) {
                obstacleManager.playerGap = (int) (Constants.PLAYER_GAP * 1.5);
                soundManager.playPowerUpSound();
                //Log.i(TAG, "setPlayerGap: " + obstacleManager.playerGap);
                bigPlayerGapUpgradeTimer();

            }
            if (itemManager.playerCollectDistanceUpgrade(player)){
                soundManager.playPowerUpSound();
                obstacleManager.obstacleGap = (int)(Constants.OBSTACLE_GAP * 1.5);
                itemManager.obstacleGap = (int)(Constants.OBSTACLE_GAP * 1.5);
                bigObstacleDistanceUpgradeTimer();

            }

            if (itemManager.playerCollectShrinkPlayerUpgrade(player)){
                soundManager.playPowerUpSound();
                player.getRectangle().inset(25, 25);
                shrinkPlayerUpgradeTimer();

            }
        }
    }

    public void bigPlayerGapUpgradeTimer() {
        Timer timer = new Timer();
        TimerTask powerUpTimerTask = new TimerTask() {
            @Override
            public void run() {

                obstacleManager.playerGap = Constants.PLAYER_GAP;
            }
        };
        timer.schedule(powerUpTimerTask, 5000);
    }

    public void bigObstacleDistanceUpgradeTimer() {
        Timer timer = new Timer();
        TimerTask powerUpTimerTask = new TimerTask() {
            @Override
            public void run() {

                obstacleManager.obstacleGap = Constants.OBSTACLE_GAP;
                itemManager.obstacleGap = Constants.OBSTACLE_GAP;
            }
        };
        timer.schedule(powerUpTimerTask, 4000);
    }

    public void shrinkPlayerUpgradeTimer() {
        Timer timer = new Timer();
        TimerTask powerUpTimerTask = new TimerTask() {
            @Override
            public void run() {

                player.getRectangle().inset(-25, -25);
            }
        };
        timer.schedule(powerUpTimerTask, 4000);
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

            highScoreHandler.getCurrentScore(getContext(), itemManager.getHighScore());

            if (itemManager.getHighScore() < highScoreHandler.highscore){
                String highScore = String.valueOf(highScoreHandler.highscore);
                drawHighScoreText(canvas, paint, "Highscore: " + highScore + "m");
            } else {
                drawHighScoreText(canvas, paint, "Highscore: " + itemManager.getHighScore() + "m");
            }





        } else if (!gameOver) {
            Paint coinPaint = new Paint();
            coinPaint.setTextSize(75);
            coinPaint.setColor(Color.YELLOW);
            drawCoinsText(canvas, coinPaint, "Coins: " + coins);

            Paint metersPaint = new Paint();
            metersPaint.setTextSize(75);
            metersPaint.setColor(Color.WHITE);

        }
        if (coinSave) {
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

    public void drawHighScoreText(Canvas canvas, Paint paint, String text) {
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTextSize(70);
        canvas.getClipBounds(highScore);
        int cHeight = highScore.height();
        int cWidth = highScore.width();
        paint.getTextBounds(text, 0, text.length(), highScore);
        float x = cWidth / 2f - highScore.width() / 2f - highScore.left;
        float y = cHeight / 2f + highScore.height() / 2f - highScore.bottom + r.height() + 50;
        canvas.drawText(text, x, y, paint);
    }

    public void drawCoinsText(Canvas canvas, Paint paint, String text) {
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTextSize(60);
        canvas.getClipBounds(coinsText);
        paint.getTextBounds(text, 0, text.length(), coinsText);
        float x = ((float)Constants.SCREEN_WIDTH/2) - ((float)coinsText.width()/2);
        float y = 100 + coinsText.height()*2;
        canvas.drawText(text, x, y, paint);
    }

}
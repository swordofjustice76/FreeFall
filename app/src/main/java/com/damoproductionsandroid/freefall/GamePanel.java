package com.damoproductionsandroid.freefall;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Timer;
import java.util.TimerTask;



import static android.content.ContentValues.TAG;


public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {


    private Rect coinsText = new Rect();
    public Rect metersText = new Rect();
    public Rect shopText = new Rect();

    public Rect highScore = new Rect();

MainThread mainThread;
    MainActivity mainActivity;


    private Rect r = new Rect();

    private MainThread thread;

    private Player player;
    private Point playerPoint;
    private Point shopButtonPoint;
    private ObstacleManager obstacleManager;
    private ItemManager itemManager;
    private SoundManager soundManager;
    private Preferences highScoreHandler;
    private ShopButton shopButton;
    private SoundtrackManager soundtrackManager;
    private ItemSpawner itemSpawner;
    private ObjectLogic gravity;
    private BigGapUpgrade bigGapUpgrade;

    private boolean movingPlayer = false;

    public boolean gameOver = false;
    private long gameOverTime;

    private boolean coinSave = false;
    public int coins;
    private int collectAmount = 1;

    private Canvas canvas;

    private int meters;
    private boolean playing = false;


    public GamePanel(Context context) {

        super(context);


        //add the callback to the surfaceholder to intercept events
        getHolder().addCallback(this);

        thread = new MainThread(getHolder(), this);
        soundManager = new SoundManager(context);
        soundtrackManager = new SoundtrackManager(context);



        //itemSpawner = new ItemSpawner(325, 400, 75, Color.YELLOW);
        player = new Player(new Rect(0, 0, Constants.PLAYER_SIZE, Constants.PLAYER_SIZE), Color.rgb(216, 0, 0));
        shopButton = new ShopButton(new Rect(0, 0, 450, 150), Color.BLACK);
        playerPoint = new Point(Constants.SCREEN_WIDTH / 2, 3 * Constants.SCREEN_HEIGHT / 4);
        shopButtonPoint = new Point(Constants.SCREEN_WIDTH / 2, 6 * Constants.SCREEN_HEIGHT / 9);
        player.update(playerPoint);
        shopButton.update(shopButtonPoint);

        obstacleManager = new ObstacleManager(325, 400, 75, Color.WHITE);
        itemManager = new ItemManager(400, 325, 75, Color.YELLOW);

        highScoreHandler = new Preferences();
        highScoreHandler.setHighScore(getContext());
        highScoreHandler.setCoinAmount(getContext());
        coins = highScoreHandler.setCoinAmount(getContext());



        //make gamePanel focusable so it can handle events
        setFocusable(true);


    }


    public void reset() {
        playerPoint = new Point(Constants.SCREEN_WIDTH / 2, 3 * Constants.SCREEN_HEIGHT / 4);
        player.update(playerPoint);
        obstacleManager = new ObstacleManager(Constants.PLAYER_GAP, 400, 75, Color.WHITE);
        itemManager = new ItemManager(400, Constants.PLAYER_GAP, 75, Color.YELLOW);
        highScoreHandler.setHighScore(getContext());
        //highScoreHandler.getCoinAmount(getContext(), coins);
        soundManager.playSoundTrack();
        movingPlayer = false;
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        //while (true) {
            try {
                thread.setRunning(false);
                thread.join();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            retry = false;
        }

   // }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {


        thread = new MainThread(getHolder(), this);

        //we can safely start the game loop

            thread.setRunning(true);
            thread.start();
            thread.setStop(false);
    }

    @Override
    public boolean  onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                int touchX = (int) event.getX();
                int touchY = (int) event.getY();

                if (!gameOver)
                    movingPlayer = true;

                if (gameOver && System.currentTimeMillis() - gameOverTime >= 2000) {

                    reset();
                    gameOver = false;

                }

                if (gameOver && shopButton.getRectangle().contains(touchX, touchY)) {

                  //  thread.setRunning(false);

                    surfaceDestroyed(getHolder());
                    Intent intent = new Intent(getContext(), Shop.class);
                    getContext().startActivity(intent);
                    Log.i(TAG, "onTouchEvent: " + coins);
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


        if (!playing) {

            playing = true;
            soundtrackManager.mediaPlayer.start();

        }

        if (!gameOver) {
            player.update(playerPoint);
            obstacleManager.update();
            itemManager.update();
            coinSave = true;

            //metres++;
            if (obstacleManager.playerCollide(player)) {
                gameOver = true;
                gameOverTime = System.currentTimeMillis();
                soundManager.playGameOver();
                highScoreHandler.getCurrentScore(getContext(), itemManager.getHighScore());
                soundtrackManager.mediaPlayer.stop();
                soundtrackManager.mediaPlayer.release();
            }

            if (itemManager.playerCollect(player)) {
                soundManager.playCoinCollectSound();
                coins += collectAmount;
                highScoreHandler.getCoinAmount(getContext(), coins);
                highScoreHandler.setCoinAmount(getContext());
                coinSave = true;
            }
            if (itemManager.playerCollectPlayerGapUpgrade(player)) {
                obstacleManager.playerGap = (int) (Constants.PLAYER_GAP * 1.5);
                soundManager.playPowerUpSound();
                bigPlayerGapUpgradeTimer();

            }
            if (itemManager.playerCollectDistanceUpgrade(player)) {
                soundManager.playPowerUpSound();
                obstacleManager.obstacleGap = (int) (Constants.OBSTACLE_GAP * 1.5);
                itemManager.obstacleGap = (int) (Constants.OBSTACLE_GAP * 1.5);
                bigObstacleDistanceUpgradeTimer();

            }

            if (itemManager.playerCollectShrinkPlayerUpgrade(player)) {
                soundManager.playPowerUpSound();
                player.getRectangle().inset(25, 25);
                shrinkPlayerUpgradeTimer();
            }

            if (itemManager.playerCollectDoubleCoinsUpgrade(player)) {
                soundManager.playPowerUpSound();
                collectAmount *= 2;
                doubleCoinsUpgradeTimer();
            }

            if (itemManager.playerCollectDoubleScoreUpgrade(player)) {
                soundManager.playPowerUpSound();
                Constants.MPS_MULTIPLIER *= 2;
                doubleScoreUpgradeTimer();
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

    private void doubleCoinsUpgradeTimer() {
        Timer timer = new Timer();
        TimerTask powerUpTimerTask = new TimerTask() {
            @Override
            public void run() {

                collectAmount /= 2;
            }
        };
        timer.schedule(powerUpTimerTask, 10000);
    }

    private void doubleScoreUpgradeTimer() {
        Timer timer = new Timer();
        TimerTask powerUpTimerTask = new TimerTask() {
            @Override
            public void run() {

                Constants.MPS_MULTIPLIER /= 2;
            }
        };
        timer.schedule(powerUpTimerTask, 5000);
    }


    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        canvas.drawColor(getResources().getColor(R.color.colourBackground));

        Typeface typeface = ResourcesCompat.getFont(getContext(), R.font.pixel_font);

        player.draw(canvas);
        obstacleManager.draw(canvas);
        itemManager.draw(canvas);


        if (gameOver) {
            Paint paint = new Paint();
            paint.setTextSize(100);
            paint.setColor(Color.GRAY);
            paint.setTypeface(typeface);

            Paint paint2 = new Paint();
            paint2.setTextSize(150);
            paint2.setColor(Color.GRAY);
            paint2.setTypeface(typeface);

            drawGameOverText(canvas, paint, "Game Over");
            drawShopText(canvas, paint2, "SHOP");
            shopButton.draw(canvas);


            highScoreHandler.getCurrentScore(getContext(), itemManager.getHighScore());
            highScoreHandler.getCoinAmount(getContext(), coins);

            if (itemManager.getHighScore() < highScoreHandler.highscore) {
                String highScore = String.valueOf(highScoreHandler.highscore);
                drawHighScoreText(canvas, paint, "Highscore: " + highScore);
            } else {
                drawHighScoreText(canvas, paint, "Highscore: " + itemManager.getHighScore());
            }


        } else if (!gameOver) {
            Paint coinPaint = new Paint();
            coinPaint.setTextSize(75);
            coinPaint.setColor(Color.YELLOW);
            coinPaint.setTypeface(typeface);
            drawCoinsText(canvas, coinPaint, "Coins: " + highScoreHandler.setCoinAmount(getContext()));

            Paint metersPaint = new Paint();
            metersPaint.setTextSize(75);
            metersPaint.setTypeface(typeface);
            metersPaint.setColor(Color.WHITE);

        }
        if (coinSave) {

            Paint paint = new Paint();
            paint.setTextSize(75);
            paint.setColor(Color.YELLOW);
            paint.setTypeface(typeface);
            drawCoinsText(canvas, paint, "Coins: " + (highScoreHandler.setCoinAmount(getContext())));
        }
    }

    private void drawGameOverText(Canvas canvas, Paint paint, String text) {
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.getClipBounds(r);
        paint.setTextSize(100);
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
        float x = ((float) Constants.SCREEN_WIDTH / 2) - ((float) coinsText.width() / 2);
        float y = 100 + coinsText.height() * 2;
        canvas.drawText(text, x, y, paint);
    }


    private void drawShopText(Canvas canvas, Paint paint, String text) {
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.getClipBounds(shopText);
        paint.setTextSize(150);
        paint.getTextBounds(text, 0, text.length(), shopText);
        int x = (Constants.SCREEN_WIDTH / 2) -
                (shopText.width() / 2);
        int y = 6 * Constants.SCREEN_HEIGHT / 9;
        canvas.drawText(text, x, y, paint);
    }

}
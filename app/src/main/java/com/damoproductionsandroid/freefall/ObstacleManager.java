package com.damoproductionsandroid.freefall;

import android.graphics.Canvas;

import java.util.ArrayList;

public class ObstacleManager extends Gravity {
   // private ArrayList<Obstacle> obstacles;
    //private int playerGap;
   // private int obstacleGap;
   // private int obstacleHeight;
   // private int colour;
    private Gravity gravity;

    private long startTime;
    private long initTime;

    public ObstacleManager(int playerGap, int obstacleGap, int obstacleHeight, int colour){
        super(playerGap, obstacleGap, obstacleHeight, colour);
        this.playerGap = playerGap;
        this.obstacleGap = obstacleGap;
        this.obstacleHeight = obstacleHeight;
        this.colour = colour;
        this.gravity = new Gravity(playerGap, obstacleGap, obstacleHeight, colour);

        startTime = initTime = System.currentTimeMillis();

        obstacles = new ArrayList<>();

        populateObstacles();

    }

    public boolean playerCollide (Player player){
        for (Obstacle ob : obstacles){
            if (ob.playerCollide(player))
                return true;
        } return false;
    }

    private void populateObstacles() {
        int currY = -5*Constants.SCREEN_HEIGHT/4;
        while (currY < 0){
            int xStart = (int)(Math.random()*(Constants.SCREEN_WIDTH - playerGap));
            obstacles.add(new Obstacle(obstacleHeight, colour, xStart, currY, playerGap));
            currY += obstacleHeight + obstacleGap;
        }

    }

    public void update(){

        super.update();
        /*  int elapsedTime = (int)(System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();
        float speed = (float)(Math.sqrt(1 +(startTime - initTime)/2000.0))*Constants.SCREEN_HEIGHT/10000.0f;
        for (Obstacle ob : obstacles){
            ob.incrementY(speed*elapsedTime);
        }
        if (obstacles.get(obstacles.size() -1).getRectangle().top >= Constants.SCREEN_HEIGHT) {
            int xStart = (int)(Math.random()*(Constants.SCREEN_WIDTH - playerGap));
            obstacles.add(0, new Obstacle(obstacleHeight, colour, xStart, obstacles.get(0).getRectangle().top - obstacleHeight - obstacleGap, playerGap));
            obstacles.remove(obstacles.size() - 1);
        } */
    }

    public void draw(Canvas canvas){
        for (Obstacle ob : obstacles)
            ob.draw(canvas);
    }
}

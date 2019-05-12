package com.damoproductionsandroid.freefall;

import android.graphics.Canvas;
import java.util.ArrayList;



public class ObstacleManager extends Gravity {


    private long startTime;
    private long initTime;

    public ObstacleManager(int playerGap, int obstacleGap, int obstacleHeight, int colour) {
        super(playerGap, obstacleGap, obstacleHeight, colour);
        this.playerGap = playerGap;
        this.obstacleGap = obstacleGap;
        this.obstacleHeight = obstacleHeight;
        this.colour = colour;



        startTime = initTime = System.currentTimeMillis();

        obstacles = new ArrayList<>();

        populateObstacles();

    }

    public boolean playerCollide(Player player) {
        for (Obstacle ob : obstacles) {
            if (ob.playerCollide(player))
                return true;
        }
        return false;
    }

    private void populateObstacles() {
        int currY = -5 * Constants.SCREEN_HEIGHT / 4;
        while (currY < 0) {
            int xStart = (int) (Math.random() * (Constants.SCREEN_WIDTH - playerGap));
            obstacles.add(new Obstacle(obstacleHeight, colour, xStart, currY, playerGap));
            currY += obstacleHeight + obstacleGap;

        }

    }

    public void update() {

        super.update();

    }

    public void draw(Canvas canvas) {
        for (Obstacle ob : obstacles)
            ob.draw(canvas);

    }


}
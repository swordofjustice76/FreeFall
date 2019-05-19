package com.damoproductionsandroid.freefall;


import java.util.ArrayList;



public class ObjectLogic {

    public float speed;

    public long initTime;
    public long startTime;
    public float metres;
    public float mps;
    public int mpsMultiplier = 1;

    public static int SPAWN_REFERENCE_POINT;


    public ArrayList<Obstacle> obstacles;
    public ArrayList<Coin> coins;
    public ArrayList<BigGapUpgrade> bigGapUpgrades;
    public ArrayList<ObstacleDistanceUpgrade> obstacleDistanceUpgrades;
    public ArrayList<ShrinkPlayerUpgrade> shrinkPlayerUpgrades;
    public ArrayList<DoubleCoinsUpgrade> doubleCoinsUpgrades;
    public ArrayList<DoubleScoreUpgrade> doubleScoreUpgrades;



    public int playerGap;
    public int obstacleGap;
    public int obstacleHeight;
    public int colour;



    public ObjectLogic(int playerGap, int obstacleGap, int obstacleHeight, int colour) {
        this.playerGap = playerGap;
        this.obstacleGap = obstacleGap;
        this.obstacleHeight = obstacleHeight;
        this.colour = colour;

        SPAWN_REFERENCE_POINT = 0 - obstacleHeight;

        obstacles = new ArrayList<>();
        coins = new ArrayList<>();
        bigGapUpgrades = new ArrayList<>();
        obstacleDistanceUpgrades = new ArrayList<>();
        shrinkPlayerUpgrades = new ArrayList<>();
        doubleCoinsUpgrades = new ArrayList<>();
        doubleScoreUpgrades = new ArrayList<>();




        startTime = initTime = System.currentTimeMillis();

    }

    public void update() {


        int elapsedTime = (int) (System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();

        speed = (float) (Math.sqrt(1 + (startTime - initTime) / 2000.0)) * Constants.SCREEN_HEIGHT / 10000.0f;

        for (Obstacle ob : obstacles) {
            ob.incrementY(speed * elapsedTime);
        }



        if (obstacles.get(obstacles.size() - 1).getRectangle().top >= Constants.SCREEN_HEIGHT) {
            int xStart = (int) (Math.random() * (Constants.SCREEN_WIDTH - playerGap));
            obstacles.add(0, new Obstacle(obstacleHeight, colour, xStart, obstacles.get(0).getRectangle().top - obstacleHeight - obstacleGap, playerGap));
            obstacles.remove(obstacles.size() - 1);
        }

    }

}
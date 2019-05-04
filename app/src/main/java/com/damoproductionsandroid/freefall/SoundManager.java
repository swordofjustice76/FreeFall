package com.damoproductionsandroid.freefall;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;

public class SoundManager {

    private static SoundPool soundPool;
    private static int coinCollect;
    private static int soundTrack;
    private static int powerUp;
    private static int gameOver;

    public SoundManager(Context context) {

        loadSounds();
        coinCollect = soundPool.load(context, R.raw.coin_pickup, 0);
        soundTrack = soundPool.load(context, R.raw.soundtrack, 0);
        powerUp = soundPool.load(context, R.raw.power_up, 0);
        gameOver = soundPool.load(context, R.raw.game_over, 0);

    }


    private void loadSounds() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(3)
                    .setAudioAttributes(audioAttributes)
                    .build();

        } else {
            soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 0);
        }

    }

    public void playCoinCollectSound(){
        soundPool.play(coinCollect, 1, 1, 0, 0, 1);
    }

    public void playPowerUpSound(){
        soundPool.play(powerUp, 1, 1, 0, 0, 1);
    }

    public void playSoundTrack(){
        soundPool.play(soundTrack, 1, 1, 0, -1, 1);
    }

    public void playGameOver(){
        soundPool.play(gameOver, 1, 1, 0, 0, 1);
    }

}

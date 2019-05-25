package com.damoproductionsandroid.freefall;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;

public class SoundtrackManager extends Activity {

        MediaPlayer mediaPlayer;

    public SoundtrackManager(Context context) {
        mediaPlayer = MediaPlayer.create(context, R.raw.soundtrack);

        //mediaPlayer.start();

    }

    @Override
    protected void onStart() {
        super.onStart();
        mediaPlayer.start();
    }

    @Override
        protected void onPause () {
        super.onPause();
        mediaPlayer.stop();
        mediaPlayer.release();

    }

}


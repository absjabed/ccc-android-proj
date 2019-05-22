package com.parvez_n_jabed_co.ccc_project.Activities;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.VideoView;
import com.github.javiersantos.appupdater.AppUpdater;
import com.google.firebase.messaging.FirebaseMessaging;
import com.parvez_n_jabed_co.ccc_project.R;

public class SplashActivity extends Activity {
VideoView videov;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        FirebaseMessaging.getInstance().subscribeToTopic("CCC");
        //   clk = (Button) findViewById(R.id.button);
        videov = (VideoView) findViewById(R.id.videoView);

/*
        videov.setVideoPath("file:///android_asset/splash.mp4");
        videov.requestFocus();
        videov.start();*/

        String videopath = "android.resource://com.parvez_n_jabed_co.ccc_project/"+R.raw.splash ;
        //String videopath = "android.resource://com.parvez_n_jabed_co.ccc_project/2131099648";
        Log.e("vp", videopath);
       // String videopath = "android.resource://" + getPackageName() + "/raw/splash.mp4";
        Uri uri  =  Uri.parse(videopath);
        videov.setVideoURI(uri);
        videov.start();

        AppUpdater appUpdater = new AppUpdater(getApplicationContext());
        appUpdater.start();

        videov.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                                    Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                                    startActivity(intent);
                                    finish();
            }
        });

    }
}

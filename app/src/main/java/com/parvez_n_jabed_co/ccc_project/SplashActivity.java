package com.parvez_n_jabed_co.ccc_project;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

import com.google.firebase.messaging.FirebaseMessaging;

public class SplashActivity extends Activity {
VideoView videov;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        FirebaseMessaging.getInstance().subscribeToTopic("CCC");
        //   clk = (Button) findViewById(R.id.button);
        videov = (VideoView) findViewById(R.id.videoView);
        String videopath = "android.resource://com.parvez_n_jabed_co.ccc_project/"+R.raw.splash ;

        Uri uri  =  Uri.parse(videopath);
        videov.setVideoURI(uri);
        videov.start();
        videov.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
//                Intent intent = new Intent(SplashActivity.this,GameActivity.class);
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}

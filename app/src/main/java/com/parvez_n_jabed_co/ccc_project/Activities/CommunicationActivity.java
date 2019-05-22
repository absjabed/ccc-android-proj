package com.parvez_n_jabed_co.ccc_project.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.parvez_n_jabed_co.ccc_project.R;

public class CommunicationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication);
    }

    public void onClickMeetMayor(View view) {
        Intent intent = new Intent(CommunicationActivity.this, CommuwithMeyor.class);
        startActivity(intent);
    }

    public void onClickcccNumbers(View view) {
            Intent intent = new Intent(CommunicationActivity.this, WebViewActivity.class);
            intent.putExtra("URL", "https://goo.gl/wJDvTv");  //https://drive.google.com/file/d/0ByXcNtvRHMV6Ui1IQnNDSXR4Ylk/view
            intent.putExtra("visible",1);
            startActivity(intent);
    }
}

package com.parvez_n_jabed_co.ccc_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class NotificationActivity extends AppCompatActivity {
    String title, message,extraString;
    TextView titleTV, bodyTV, extraTV;
    private String TAG = "NotificationActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);


        titleTV = (TextView) findViewById(R.id.textTitle);
        bodyTV = (TextView) findViewById(R.id.textMessage);
        extraTV = (TextView) findViewById(R.id.textExtra);


        if (getIntent().getExtras() != null) {

            title = getIntent().getExtras().getString("Title");
            message = getIntent().getExtras().getString("Body");
            extraString = getIntent().getExtras().getString("Extra");

//            for (String key : getIntent().getExtras().keySet()) {
//                String value = getIntent().getExtras().getString(key);
//                Log.d(TAG, "Key: " + key + " Value: " + value);
//            }
        }else{
            title = getIntent().getStringExtra("Title");
            message = getIntent().getStringExtra("Body");
            extraString = getIntent().getStringExtra("Extra");
        }


        titleTV.setText(title);
        bodyTV.setText(message);
        extraTV.setText(extraString);

    }
}

package com.parvez_n_jabed_co.ccc_project;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NotificationActivity extends AppCompatActivity {
    String title, message,extraString,fcmBtnLink;
    TextView titleTV, bodyTV, extraTV;
   // Button fcmNotificationButton;
    private String TAG = "NotificationActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);


        titleTV = (TextView) findViewById(R.id.textTitle);
        bodyTV = (TextView) findViewById(R.id.textMessage);
        extraTV = (TextView) findViewById(R.id.textExtra);
      //  fcmNotificationButton = (Button) findViewById(R.id.fcmBtn);


        if (getIntent().getExtras() != null) {

            title = getIntent().getExtras().getString("Title");
            message = getIntent().getExtras().getString("Body");
            extraString = getIntent().getExtras().getString("Extra");
         //   fcmBtnLink = getIntent().getExtras().containsKey("ButtonLink") ? getIntent().getExtras().getString("ButtonLink") : null;

           /* if(!fcmBtnLink.isEmpty() || fcmBtnLink.length() != 0 | fcmBtnLink.toString() != null){
                    fcmNotificationButton.setVisibility(View.VISIBLE);
            }*/
//            for (String key : getIntent().getExtras().keySet()) {
//                String value = getIntent().getExtras().getString(key);
//                Log.d(TAG, "Key: " + key + " Value: " + value);
//            }
        }else{
            title = getIntent().getStringExtra("Title");
            message = getIntent().getStringExtra("Body");
            extraString = getIntent().getStringExtra("Extra");
         //   fcmBtnLink = getIntent().getExtras().containsKey("ButtonLink") ? getIntent().getExtras().getString("ButtonLink") : null;

          /*  if(!fcmBtnLink.isEmpty() || fcmBtnLink.length() != 0 | fcmBtnLink.toString() != null){
                fcmNotificationButton.setVisibility(View.VISIBLE);
            }*/

        }


        titleTV.setText(title);
        bodyTV.setText(message);
        extraTV.setText(extraString);

    }

    /*public void onClickFCMbtn(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(fcmBtnLink));
        String title = "অন্য অ্যাপ্লিকেশন দিয়ে লিংকটি ওপেন করুন";
        Intent chooser = Intent.createChooser(intent, title);
        startActivity(chooser);
    }*/
}

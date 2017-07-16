package com.parvez_n_jabed_co.ccc_project.HistoricalPlacesActivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.parvez_n_jabed_co.ccc_project.R;

public class PlacesViewActivity extends AppCompatActivity {

    TextView placeTitle, placeInfoTxt, placeGoTxt, placeLocationTxt;
    ImageView placeImg;
    int title,info,go,location,img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_view);

        placeTitle = (TextView) findViewById(R.id.placeTitle);
        placeInfoTxt = (TextView) findViewById(R.id.placeInfoTxt);
        placeGoTxt = (TextView) findViewById(R.id.placeGoTxt);
        placeLocationTxt = (TextView) findViewById(R.id.placeLocationTxt);
        placeImg = (ImageView) findViewById(R.id.placeImg);


        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
             title = extras.getInt("title");
             info = extras.getInt("info");
             go = extras.getInt("go");
             location = extras.getInt("location");
             img = extras.getInt("image");


            placeTitle.setText(title);
            placeInfoTxt.setText(info);
            placeGoTxt.setText(go);
            placeLocationTxt.setText(location);
            placeImg.setBackgroundResource(img);
        }



    }
}

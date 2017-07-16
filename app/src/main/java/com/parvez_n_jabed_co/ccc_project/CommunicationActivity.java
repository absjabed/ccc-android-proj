package com.parvez_n_jabed_co.ccc_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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
            Intent intent = new Intent(CommunicationActivity.this, PdfViewActivity.class);
            intent.putExtra("pdfName","Contact list for Apps.pdf");
            intent.putExtra("ACTIVITYNAME","যোগাযোগের নাম্বার সমূহ");
            startActivity(intent);
    }
}

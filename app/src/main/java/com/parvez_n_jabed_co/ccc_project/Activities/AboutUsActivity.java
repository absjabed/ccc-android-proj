package com.parvez_n_jabed_co.ccc_project.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.parvez_n_jabed_co.ccc_project.R;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
    }

    public void onClickAboutUs(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(AboutUsActivity.this);
        alertDialogBuilder
                .setMessage("CCC App Developers:\n" +
                        "Mohammad Abu Bakar Siddqe Jabed\n" +
                        "Email: absjabed@gmail.com\n"+
                        "Phone: +8801676749372\n\n"+
                        "And \n\n" +
                        "Md. Khaled Mosharraf Parvez\n" +
                        "Email: kmparvez2@gmail.com\n"+
                        "Phone: +8801843298326\n")
                .setTitle("About Developers")
                .setCancelable(false)
                .setPositiveButton(" OK ",
                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(AboutUsActivity.this, "Thanks for your interest.", Toast.LENGTH_LONG).show();
                            }
                        });
        AlertDialog alert = alertDialogBuilder.create();
        alert .setIcon(android.R.drawable.ic_dialog_info);
        alert.show();
    }

    public void onClickPlay(View view) {
        //playstore link
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.parvez_n_jabed_co.ccc_project"));
        String title = "Open with another application";
        Intent chooser = Intent.createChooser(intent, title);
        startActivity(chooser);
        /*
        String androidID = System.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
        String deviceName = android.os.Build.MODEL;
        String deviceMan = android.os.Build.MANUFACTURER;*/

    }

    public void onClickShare(View view) {
        shareIt();
    }

    public void onClickMessage(View view) {
        String samsung = "Samsung";
        String smsnumber;

        if(Build.MANUFACTURER.equals(samsung)){
            smsnumber = "01676749372, 01843298326";
        }else{
            smsnumber = "01676749372; 01843298326";
        }

        String smstxt = "Any thing you want to know from us, developers............\n\n\n\n-CCC App";

        Uri uri = Uri.parse("smsto:"+smsnumber);
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body", smstxt);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    public void onClickEmail(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Put your mail subject here..");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"absjabed@gmailcom","kmparvez2@gmail.com","automateinfosysbd@gmail.com"});
        Intent mailer = Intent.createChooser(intent, "Send feedback / Contact with Developers");
        startActivity(mailer);

    }

    private void shareIt() {
//sharing implementation here
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "Chittagong City Corporation - Official Android Application (CCC App). DownLoad Link: https://play.google.com/store/apps/details?id=com.parvez_n_jabed_co.ccc_project";//com.parvez_n_jabed_co.ccc_project
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Ctg City Corp. Official App (CCC App)"); // https://play.google.com/store/apps/details?id=com.orioninformatics.digitaldhaka
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }
}

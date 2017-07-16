package com.parvez_n_jabed_co.ccc_project.TestActivities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.parvez_n_jabed_co.ccc_project.Constant_Var;
import com.parvez_n_jabed_co.ccc_project.FormRelatedActivities.FormTypes;
import com.parvez_n_jabed_co.ccc_project.FormRelatedActivities.TaxRelatedFormsActivity;
import com.parvez_n_jabed_co.ccc_project.R;
import com.parvez_n_jabed_co.ccc_project.WebViewActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LiveTestActivity extends AppCompatActivity {

    EditText liveET;
    Button liveBtnIP, liveBtnNew;
    String link;
    private ProgressDialog loading;
    String json_response;
    String url, status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_test);


        liveET = (EditText) findViewById(R.id.liveLinkET);
        liveBtnIP = (Button) findViewById(R.id.liveBtn);
        liveBtnNew = (Button) findViewById(R.id.liveBtnAnother);

        if (!isNetworkAvailable()) {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(LiveTestActivity.this);
            alertDialogBuilder
                    .setMessage("No internet connection on your device. Would you like to enable it?")
                    .setTitle("No Internet Connection.")
                    .setCancelable(false)
                    .setPositiveButton(" Enable Internet ",
                            new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog, int id) {
                                    Toast.makeText(LiveTestActivity.this, "Now enable your Internet connection.", Toast.LENGTH_LONG).show();
                                    finish();
                                    Intent dialogIntent = new Intent(Settings.ACTION_SETTINGS);
                                    dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    getBaseContext().startActivity(dialogIntent);
                                }
                            });

            alertDialogBuilder.setNegativeButton(" Cancel ", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    liveBtnIP.setEnabled(false);
                    liveBtnNew.setEnabled(false);
                    dialog.cancel();
                    //finish();
                }
            });
            AlertDialog alert = alertDialogBuilder.create();
            alert.show();
        } else {
            try {
                getData();
            } catch (Exception e) {
                Toast.makeText(this, "দুঃখিত আপনার ইন্টারনেট সংযোগটি ধীর গতি সম্পন্ন\nকিছুক্ষন পর আবার চেষ্টা করুন।", Toast.LENGTH_LONG).show();
            }
        }


    }

    private void getData() {
        // String id = editTextId.getText().toString().trim();
        /** if (id.equals("")) {
         Toast.makeText(this, "Please enter an id", Toast.LENGTH_LONG).show();
         return;
         }*/
        loading = ProgressDialog.show(this, "Please wait...", "Geting things ready for you....", false, false);

        String url = Constant_Var.LIVE_BROADCASTING_LINK.trim();

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                loading.dismiss();
                json_response = response;
                //showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LiveTestActivity.this, "VOLLEY Error!" + error.getMessage().toString(), Toast.LENGTH_LONG).show();

                        loading.dismiss();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void liveActivity(View view) {
        link = liveET.getText().toString().trim();
        Intent intent = new Intent(LiveTestActivity.this, WebViewActivity.class);
        intent.putExtra("URL", link);
        startActivity(intent);
    }

    public void onClickLiveButtonNew(View view) {

    }

    private void getLinkStatus() {
        JSONObject jsonObject;
        JSONArray jsonArray;
        try {
            jsonObject = new JSONObject(json_response);
            jsonArray = jsonObject.getJSONArray(Constant_Var.JSON_ARRAY);
            JSONObject linkData = jsonArray.getJSONObject(0);

            url = linkData.getString("livelink");
            status = linkData.getString("status");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }

    public void onClickLiveAnotherButton(View view) {
        try {
            if (json_response == null) {
                Toast.makeText(this, "There is a Problem with your Internet connection", Toast.LENGTH_SHORT).show();

            } else {
//                Toast.makeText(this, json_response, Toast.LENGTH_SHORT).show();
                getLinkStatus(); //to get link and status to url & status variable
//                Toast.makeText(this, "Url: "+ url, Toast.LENGTH_SHORT).show();
//                Toast.makeText(this, "Status: "+ status, Toast.LENGTH_SHORT).show();

                    if(status.equals("1")){
                        Toast.makeText(this, "এখনই চসিক এর সরাসরি সম্প্রচারের লিঙ্কে আপনাকে রিডাইরেক্ট করা হচ্ছে।", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(LiveTestActivity.this, WebViewActivity.class);
                        intent.putExtra("URL", url);
                        startActivity(intent);

                    }else if(status.equals("0")){
                        Toast.makeText(this, "দুঃখিত এই মুহূর্তে চসিক হতে কোন কিছু সরাসরি সম্প্রচার করা হচ্ছে না\nএখন আপনি পূর্বের সংরক্ষিত ভিডিও সমূহ দেখতে পাবেন", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(LiveTestActivity.this, WebViewActivity.class);
                        intent.putExtra("URL", url);
                        startActivity(intent);
                    }else{
                    Toast.makeText(this, "দুঃখিত আপনার ইন্টারনেট সংযোগটি ধীর গতি সম্পন্ন\nকিছুক্ষন পর আবার চেষ্টা করুন।", Toast.LENGTH_LONG).show();
                }
            }
        } catch (Exception ex) {
            Toast.makeText(this, ex.toString(), Toast.LENGTH_SHORT).show();
            loading.dismiss();
        }
    }
}
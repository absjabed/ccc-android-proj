package com.parvez_n_jabed_co.ccc_project;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;
import android.Manifest;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.beardedhen.androidbootstrap.BootstrapLabel;
import com.parvez_n_jabed_co.ccc_project.TestActivities.LiveTestActivity;

import org.json.JSONException;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ComplainActivityNew extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spnrComplainType;
    private BootstrapEditText ETdescription, ETphoneemail, ETname;
    private BootstrapButton addPic, addVideo, reportSubmitForm, chkBtnB;
    private CheckBox attachmentCheckBox;
    LinearLayout attachmentLayout;
    BootstrapLabel attachmentLabel;
    // LogCat tag
    private static final String TAG = MainActivity.class.getSimpleName();

    // Camera activity request codes
    private static final int CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 100;
    private static final int CAMERA_CAPTURE_VIDEO_REQUEST_CODE = 200;

    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;

    private Uri fileUri;
    private String complainDescription, complainPhoneEmail, complainName;
    // file url to store image/video
    /*
    complaintype
    * ETReportdescription
    * ETReportphoneemail
    *btnAddPic
    * btnAddVideo
    * submitReportForm
    * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);

        spnrComplainType = (Spinner) findViewById(R.id.complainReportType);
        ETdescription = (BootstrapEditText) findViewById(R.id.ETReportdescription);
        ETphoneemail = (BootstrapEditText) findViewById(R.id.ETReportphoneemail);
        addPic = (BootstrapButton) findViewById(R.id.btnAddPic);
        addVideo = (BootstrapButton) findViewById(R.id.btnAddVideo);
        reportSubmitForm = (BootstrapButton) findViewById(R.id.submitReportForm);
        attachmentCheckBox = (CheckBox) findViewById(R.id.chkboxAttachment);
        attachmentLayout = (LinearLayout) findViewById(R.id.attachmentLayout);
        attachmentLabel = (BootstrapLabel) findViewById(R.id.attachmentLabel);
        chkBtnB = (BootstrapButton) findViewById(R.id.chkboxAttachmentB);
        ETname = (BootstrapEditText) findViewById(R.id.ETReportname);

        chkBtnB.setOnCheckedChangedListener(new BootstrapButton.OnCheckedChangedListener() {
            @Override
            public void OnCheckedChanged(BootstrapButton bootstrapButton, boolean isChecked) {
                if(isChecked){
                    attachmentLabel.setVisibility(View.VISIBLE);
                    attachmentLayout.setVisibility(View.VISIBLE);
                    reportSubmitForm.setVisibility(View.GONE);
                }else{
                    attachmentLabel.setVisibility(View.GONE);
                    attachmentLayout.setVisibility(View.GONE);
                    reportSubmitForm.setVisibility(View.VISIBLE);
                }
            }
        });
        /*attachmentCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(attachmentCheckBox.isChecked()){
                    attachmentLabel.setVisibility(View.VISIBLE);
                    attachmentLayout.setVisibility(View.VISIBLE);
                    reportSubmitForm.setVisibility(View.GONE);
                }else{
                    attachmentLabel.setVisibility(View.GONE);
                    attachmentLayout.setVisibility(View.GONE);
                    reportSubmitForm.setVisibility(View.VISIBLE);
                }
            }
        });*/

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.complain_types,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnrComplainType.setAdapter(adapter);
        spnrComplainType.setOnItemSelectedListener(this);

        // Checking camera availability
        if (!isDeviceSupportCamera()) {
            Toast.makeText(getApplicationContext(),
                    "দুক্ষিত! আপনার ডিভাইসটি ক্যামেরা সমর্থন করে না",
                    Toast.LENGTH_LONG).show();
            // will close the app if the device does't have camera
            finish();
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(position==0)
        {
            ETdescription.setText("স্থানীয় রাস্তা মেরামত করা প্রয়োজন , রাস্তাটির সঠিক অবস্থান কোন ওয়ার্ডে এর নাম ও ওয়ার্ড নাম্বার যুক্ত করুন।");

        }

        else if(position==1)
        {
            ETdescription.setText("স্থানীয় এলাকার ময়লা-আবর্জনা সম্পর্কিত অভিযোগ। ওয়ার্ডে এর নাম ও ওয়ার্ড নাম্বার যুক্ত করুন।");

        }

        else if(position==2)
        {
            ETdescription.setText("স্থানীয় এলাকার রোড লাইট/যেকোন লাইট সম্পর্কিত অভিযোগ। ওয়ার্ডে এর নাম ও ওয়ার্ড নাম্বার যুক্ত করুন।");

        }

        else if(position==3)
        {
            ETdescription.setText("স্থানীয় এলাকার নালা-নর্দমা সম্পর্কিত অভিযোগ। ওয়ার্ডে এর নাম ও ওয়ার্ড নাম্বার যুক্ত করুন।");

        }

        else if(position==4)
        {
            ETdescription.setText("যেকোন দুর্নীতি সম্পর্কিত অভিযোগ। ওয়ার্ডে এর নাম ও ওয়ার্ড নাম্বার যুক্ত করুন।");

        }

        else if(position==5)
        {
            ETdescription.setText("অসাধুপায় অবলম্বন/অবৈধ কার্যক্রম সম্পর্কিত অভিযোগ। ওয়ার্ডে এর নাম ও ওয়ার্ড নাম্বার যুক্ত করুন।");

        }

        else if(position==6)
        {
            ETdescription.setText("আপনার নিজের যেকোন অভিযোগ। ওয়ার্ডে এর নাম ও ওয়ার্ড নাম্বার যুক্ত করুন।");

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void submitReportToCCC(View view) {
        if (ETphoneemail.getText().toString() == null | ETphoneemail.getText().toString().isEmpty() |
                ETdescription.getText().toString() == null| ETdescription.getText().toString().isEmpty()|
                ETname.getText().toString() == null| ETname.getText().toString().isEmpty()){
            Toast.makeText(this, "প্রয়োজনীয় সকল তথ্য অবশ্যই প্রদান করতে হবে", Toast.LENGTH_SHORT).show();

        }else{
            if(ETdescription.getText().toString().trim().length()>=500){
                Toast.makeText(this, "আপনার অভিযোগ অবশ্যই ৫০০ অক্ষরের মধ্যে হতে হবে।", Toast.LENGTH_SHORT).show();
            }else{

                    if(ETphoneemail.getText().toString().trim().length()>=200){
                        Toast.makeText(this, "আপনার ফোন নং এবং ই-মেইল ঠিকানা অবশ্যই ২০০ অক্ষরের মধ্যে হতে হবে।", Toast.LENGTH_SHORT).show();
                    }else{

                        if(ETname.getText().toString().trim().length()>=40){
                            Toast.makeText(this, "আপনার নাম অবশ্যই ৪০ অক্ষরের মধ্যে হতে হবে।", Toast.LENGTH_SHORT).show();
                        }else {
                            if (!isNetworkAvailable()) {

                                Toast.makeText(this, "দুঃখিত, আপানার ইন্টারনেট সংযোগ চালু করে আবার চেষ্টা করুন।", Toast.LENGTH_SHORT).show();

                            } else {
                                String strEmailPhone, description, name;

                                strEmailPhone = ETphoneemail.getText().toString().trim();
                                description = ETdescription.getText().toString().trim();
                                name = ETname.getText().toString().trim();
                       /*         try {
                                    URLEncoder.encode(strEmailPhone, "UTF-8");
                                    URLEncoder.encode(description, "UTF-8");
                                    URLEncoder.encode(name, "UTF-8");
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                }*/

                                try {
                                    submitToServer(strEmailPhone, description, name);
                                    Toast.makeText(this, "ধন্যবাদ আপনার অভিযোগের জন্য\nআপনাকে দ্রুত এই ব্যাপারে আপডেট জানানো হবে।", Toast.LENGTH_SHORT).show();
                                    Intent intentM = new Intent(ComplainActivityNew.this, MainActivity.class);
                                    intentM.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intentM);
                                    ComplainActivityNew.this.finish();
                                } catch (Exception ex) {
                                    Toast.makeText(this, "সার্ভারে তথ্য পাঠানো যায়নি: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
                                }

                            }
                        }
                }

            }
        }
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }
    private void submitToServer(String strEmailPhone, String description, String name) throws JSONException {

        final String sdescription = description;
        final String semailphone = strEmailPhone;
        final String sname = name;

        //clearing UI components........

        ETphoneemail.setText(null);
        ETphoneemail.setText(null);
        ETname.setText(null);

        // Toast.makeText(this, ctype+" "+name+" "+email+" "+description+" "+phone, Toast.LENGTH_SHORT).show();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constant_Var.COMPLAIN_URL,// Complain URL
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(ComplainActivityNew.this,response,Toast.LENGTH_LONG).show();
//                                AlertClass alert = new AlertClass(ComplainActivity.this,2500, AlertType.SUCCESS_ALERT,layout);
//                                alert.showAlert();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ComplainActivityNew.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){

                        /*public static final String KEY_NAME = "user_name";
    public static final String KEY_ADDRESS = "user_address";
    public static final String KEY_DESCRIPTION = "user_description";
    public static final String KEY_PHONE_EMAIL = "user_phone_email";*/

                Map<String,String> params = new HashMap<String, String>();
                params.put(Constant_Var.KEY_COMPLAIN_DESCRIPTION,sdescription);
                params.put(Constant_Var.KEY_COMPLAIN_PHONE_EMAIL,semailphone);
                params.put(Constant_Var.KEY_COMPLAIN_NAME, sname);
                Log.d("testComplain",params.get(Constant_Var.KEY_COMPLAIN_DESCRIPTION)+" "+params.get(Constant_Var.KEY_COMPLAIN_PHONE_EMAIL)+" "+params.get(Constant_Var.KEY_COMPLAIN_NAME));
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }

    /**
     * Checking device has camera hardware or not
     * */
    private boolean isDeviceSupportCamera() {
        if (getApplicationContext().getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_CAMERA)) {
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }
    }


    public void onClickAddPic(View view) {
        if (ETphoneemail.getText().toString() == null | ETphoneemail.getText().toString().isEmpty() |
                ETdescription.getText().toString() == null| ETdescription.getText().toString().isEmpty()|
                ETname.getText().toString() == null| ETname.getText().toString().isEmpty()){
            Toast.makeText(this, "প্রয়োজনীয় সকল তথ্য অবশ্যই প্রদান করতে হবে", Toast.LENGTH_SHORT).show();

        }else{
            if(ETdescription.getText().toString().trim().length()>=500){
                Toast.makeText(this, "আপনার অভিযোগ অবশ্যই ৫০০ অক্ষরের মধ্যে হতে হবে।", Toast.LENGTH_SHORT).show();
            }else {
                if(ETphoneemail.getText().toString().trim().length()>=200){
                    Toast.makeText(this, "আপনার ফোন নং এবং ই-মেইল ঠিকানা অবশ্যই ২০০ অক্ষরের মধ্যে হতে হবে।", Toast.LENGTH_SHORT).show();
                }else {
                    if(ETname.getText().toString().trim().length()>=40){
                        Toast.makeText(this, "আপনার নাম অবশ্যই ৪০ অক্ষরের মধ্যে হতে হবে।", Toast.LENGTH_SHORT).show();
                    }else {
                        // capture picture
                        complainDescription = ETdescription.getText().toString();
                        complainPhoneEmail = ETphoneemail.getText().toString();
                        complainName = ETname.getText().toString();
/*
                        try {
                            URLEncoder.encode(complainDescription, "UTF-8");
                            URLEncoder.encode(complainPhoneEmail, "UTF-8");
                            URLEncoder.encode(complainName, "UTF-8");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }*/


                        int PERMISSION_ALL = 1;

                        String[] PERMISSIONS =  {Manifest.permission.CALL_PHONE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.SEND_SMS, Manifest.permission.RECORD_AUDIO, Manifest.permission.CAMERA};

                        if(!hasPermissions(this, PERMISSIONS)){
                            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
                        }else
                        {
                            captureImage();
                        }
                    }
                }
            }
        }

    }
    public void onClickAddVideo(View view) {
        if (ETphoneemail.getText().toString() == null | ETphoneemail.getText().toString().isEmpty() |
                ETdescription.getText().toString() == null| ETdescription.getText().toString().isEmpty()|
                ETname.getText().toString() == null| ETname.getText().toString().isEmpty()){
            Toast.makeText(this, "প্রয়োজনীয় সকল তথ্য অবশ্যই প্রদান করতে হবে", Toast.LENGTH_SHORT).show();

        }else{


            if(ETdescription.getText().toString().trim().length()>=500){
                Toast.makeText(this, "আপনার অভিযোগ অবশ্যই ৫০০ অক্ষরের মধ্যে হতে হবে।", Toast.LENGTH_SHORT).show();
            }else {
                if(ETphoneemail.getText().toString().trim().length()>=200){
                    Toast.makeText(this, "আপনার ফোন নং এবং ই-মেইল ঠিকানা অবশ্যই ২০০ অক্ষরের মধ্যে হতে হবে।", Toast.LENGTH_SHORT).show();
                }else {
                    if(ETname.getText().toString().trim().length()>=40){
                        Toast.makeText(this, "আপনার নাম অবশ্যই ৪০ অক্ষরের মধ্যে হতে হবে।", Toast.LENGTH_SHORT).show();
                    }else {
                        // record video
                        complainDescription = ETdescription.getText().toString();
                        complainPhoneEmail = ETphoneemail.getText().toString();
                        complainName = ETname.getText().toString();

                        /*try {
                            URLEncoder.encode(complainDescription, "UTF-8");
                            URLEncoder.encode(complainPhoneEmail, "UTF-8");
                            URLEncoder.encode(complainName, "UTF-8");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }*/

                        int PERMISSION_ALL = 1;

                        String[] PERMISSIONS =  {Manifest.permission.CALL_PHONE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.SEND_SMS, Manifest.permission.RECORD_AUDIO, Manifest.permission.CAMERA};

                        if(!hasPermissions(this, PERMISSIONS)){
                            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
                        }else
                        {
                            recordVideo();
                        }
                    }
                }
            }
        }

    }

    private void captureImage() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);

        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);

        // start the image capture Intent
        startActivityForResult(intent, CAMERA_CAPTURE_IMAGE_REQUEST_CODE);
    }

    private void recordVideo() {
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);

        fileUri = getOutputMediaFileUri(MEDIA_TYPE_VIDEO);

        // set video quality
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);

        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file
        // name

        // start the video capture Intent
        startActivityForResult(intent, CAMERA_CAPTURE_VIDEO_REQUEST_CODE);
    }

    /**
     * Here we store the file url as it will be null after returning from camera
     * app
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // save file url in bundle as it will be null on screen orientation
        // changes
        outState.putParcelable("file_uri", fileUri);
        outState.putString("complain_description",complainDescription);
        outState.putString("complain_phone_email", complainPhoneEmail);
        outState.putString("complain_name",complainName);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // get the file url
        fileUri = savedInstanceState.getParcelable("file_uri");
        complainDescription = savedInstanceState.getString("complain_description");
        complainPhoneEmail = savedInstanceState.getString("complain_phone_email");
        complainName = savedInstanceState.getString("complain_name");
    }



    /**
     * Receiving activity result method will be called after closing the camera
     * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // if the result is capturing Image
        if (requestCode == CAMERA_CAPTURE_IMAGE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {

                // successfully captured the image
                // launching upload activity
                launchUploadActivity(true);


            } else if (resultCode == RESULT_CANCELED) {

                // user cancelled Image capture
                Toast.makeText(getApplicationContext(),
                        "ছবি তোলা বাতিল করা হয়েছে।", Toast.LENGTH_SHORT)
                        .show();

            } else {
                // failed to capture image
                Toast.makeText(getApplicationContext(),
                        "দুঃখিত! ছবি তোলা সম্ভব হয়নি।", Toast.LENGTH_SHORT)
                        .show();
            }

        } else if (requestCode == CAMERA_CAPTURE_VIDEO_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {

                // video successfully recorded
                // launching upload activity
                launchUploadActivity(false);

            } else if (resultCode == RESULT_CANCELED) {

                // user cancelled recording
                Toast.makeText(getApplicationContext(),
                        "ভিডিও রেকর্ডিং বাতিল করা হয়েছে।", Toast.LENGTH_SHORT)
                        .show();

            } else {
                // failed to record video
                Toast.makeText(getApplicationContext(),
                        "দুঃখিত! ভিডিও রেকর্ড করা সম্ভব হয়নি।", Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }


    private void launchUploadActivity(boolean isImage){
        Intent i = new Intent(ComplainActivityNew.this, UploadActivity.class);
        i.putExtra("filePath", fileUri.getPath());
        i.putExtra("isImage", isImage);
        i.putExtra("complain_description",complainDescription);
        i.putExtra("complain_phone_email",complainPhoneEmail);
        i.putExtra("complain_name", complainName);
        startActivity(i);
    }

    /**
     * ------------ Helper Methods ----------------------
     * */

    /**
     * Creating file uri to store image/video
     */
    public Uri getOutputMediaFileUri(int type) {
        return Uri.fromFile(getOutputMediaFile(type));
    }

    /**
     * returning image / video
     */
    private static File getOutputMediaFile(int type) {

        // External sdcard location
        File mediaStorageDir = new File(
                Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                Constant_Var.IMAGE_DIRECTORY_NAME);

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d(TAG, "Oops! Failed create "
                        + Constant_Var.IMAGE_DIRECTORY_NAME + " directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator
                    + "IMG_" + timeStamp + ".jpg");
        } else if (type == MEDIA_TYPE_VIDEO) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator
                    + "VID_" + timeStamp + ".mp4");
        } else {
            return null;
        }

        return mediaFile;
    }

    public static boolean hasPermissions(Context context, String... permissions) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

}

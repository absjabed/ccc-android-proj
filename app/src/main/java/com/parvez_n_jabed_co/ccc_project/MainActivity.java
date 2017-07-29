package com.parvez_n_jabed_co.ccc_project;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.text.Html;
import android.text.TextUtils;

import android.view.View;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;
import com.parvez_n_jabed_co.ccc_project.FormRelatedActivities.FormListActivity;
import com.parvez_n_jabed_co.ccc_project.HistoricalPlacesActivities.PlacesNameActivity;
import com.parvez_n_jabed_co.ccc_project.TaxRelatedActivities.TaxActivity;
import com.parvez_n_jabed_co.ccc_project.TestActivities.LiveTestActivity;


public class MainActivity extends AppCompatActivity {
    ImageButton imfb,imyoutube,imwebsite,imabtus, imsettings;
    Button imtvv;
    private static final int REQUEST_CALL = 1;
    Intent callIntent;
    int x= 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

         final LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linlayoutmain);

        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
/*        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.title_ixom);
        getSupportActionBar().setDisplayUseLogoEnabled(true);*/
        setContentView(R.layout.activity_main);
        //FirebaseMessaging.getInstance().subscribeToTopic("CCC");

        Button imgar = (Button)findViewById(R.id.imservices);
        /*imgar.setBackgroundResource(R.drawable.ar_anim);
        AnimationDrawable frameAnimationar = (AnimationDrawable) imgar.getBackground();
        frameAnimationar.start();*/

        Button imgev = (Button)findViewById(R.id.imfutureplan);
      /*  imgev.setBackgroundResource(R.drawable.ev_anim);
        AnimationDrawable frameAnimationev = (AnimationDrawable) imgev.getBackground();
        frameAnimationev.start();
*/
        Button imgpro = (Button)findViewById(R.id.improject);
      /*  imgpro.setBackgroundResource(R.drawable.pro_anim);
        AnimationDrawable frameAnimationpro = (AnimationDrawable) imgpro.getBackground();
        frameAnimationpro.start();*/

        Button imgli = (Button)findViewById(R.id.imlive);
       /* imgli.setBackgroundResource(R.drawable.li_anim);
        AnimationDrawable frameAnimationli = (AnimationDrawable) imgli.getBackground();
        frameAnimationli.start();*/
        imgli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent webviewIntent = new Intent(MainActivity.this,LiveTestActivity.class);

                startActivity(webviewIntent);

            }
        });

        imgpro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle2 = new Bundle();
                bundle2.putInt("ACTIVITY",Constant_Var.PROJECT__ACTIVITY);
                bundle2.putString("ACTIVITYNAME","সি/ক প্রজেক্ট সমূহ");
                bundle2.putInt("TYPE_NAME",R.array.project_name);
                bundle2.putInt("TYPE_PIC",R.drawable.forms);
                Intent intent2 = new Intent(MainActivity.this,ListViewNormalSecond.class);
                intent2.putExtras(bundle2);
                startActivity(intent2);

            }
        });
        imgar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* Intent webviewIntent = new Intent(MainActivity.this,WebViewActivity.class);
                webviewIntent.putExtra("URL","http://www.ccc.org.bd/gallery");
                startActivity(webviewIntent);*/

                Bundle bundle1 = new Bundle();
                bundle1.putInt("ACTIVITY",Constant_Var.SERVICES_ACTIVITY);
                bundle1.putInt("TYPE_NAME",R.array.services_list);
                bundle1.putString("ACTIVITYNAME",Constant_Var.SERVICE_ACTIVITY_NAME);
                Intent intent1 = new Intent(MainActivity.this,DefaultListView.class);
                intent1.putExtras(bundle1);
                startActivity(intent1);
            }
        });
        imgev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle1 = new Bundle();
                bundle1.putInt("ACTIVITY",Constant_Var.FUTUREPLANE_ACTIVITY);
                bundle1.putInt("TYPE_NAME",R.array.future_plan_list);
                bundle1.putString("ACTIVITYNAME",Constant_Var.FUTUREPLANE_ACTIVITY_NAME);
                Intent intent1 = new Intent(MainActivity.this,DefaultListView.class);
                intent1.putExtras(bundle1);

                startActivity(intent1);


            }
        });

        imfb = (ImageButton) findViewById(R.id.btnfba);
        imyoutube = (ImageButton) findViewById(R.id.btnyoutube);
        imwebsite = (ImageButton) findViewById(R.id.btnwebsite);
        imabtus= (ImageButton) findViewById(R.id.btnabtus);
        //  imtvv = (Button)findViewById(R.id.btnudvodhon);
        imfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent webviewIntent = new Intent(MainActivity.this,WebViewActivity.class);
                webviewIntent.putExtra("URL","https://www.facebook.com");
                startActivity(webviewIntent);

            }
        });


        imyoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent webviewIntent = new Intent(MainActivity.this,WebViewActivity.class);
                webviewIntent.putExtra("URL","https://www.youtube.com/channel/UCXa9UQkB_bC2rco11B6wRfw");
                startActivity(webviewIntent);

            }
        });

        imwebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent webviewIntent = new Intent(MainActivity.this,WebViewActivity.class);
                webviewIntent.putExtra("URL","http://www.ccc.org.bd");
                startActivity(webviewIntent);

            }
        });
       /* imtvv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent webviewIntent = new Intent(MainActivity.this,WelcomeActivity.class);

                startActivity(webviewIntent);

            }
        });

        */

        imabtus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent webviewIntent = new Intent(MainActivity.this,AboutUsActivity.class);
                startActivity(webviewIntent);

            }
        });




        GridView gridview = (GridView) findViewById(R.id.gridview);


        gridview.setAdapter(new FruitAdapter(

                new FruitItem("চসিক অফিসিয়ালস",R.drawable.officials), //CCC Internal
                new FruitItem("শিক্ষা",R.drawable.education), //Education
                new FruitItem("স্বাস্থ্য",R.drawable.health),//Health
                new FruitItem("প্রেস রিলিজ",R.drawable.newspaper), //Press Release
                new FruitItem("ফর্ম",R.drawable.forms), //
                new FruitItem("ট্যাক্স",R.drawable.tax),
                new FruitItem("ই-টেন্ডার",R.drawable.tender),
                new FruitItem("যোগাযোগ",R.drawable.communication), //Communication
                new FruitItem("বিনোদন",R.drawable.entertainment),
                new FruitItem("জরুরী সেবা",R.drawable.emergency),
                new FruitItem("অভিযোগ বাক্স",R.drawable.complain),
                new FruitItem("হেল্পলাইন",R.drawable.helpline)
        ));


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                switch(position) {

                    case Constant_Var.CCC_ACTIVITY:
                        Bundle bundle1 = new Bundle();
                        bundle1.putInt("ACTIVITY",Constant_Var.CCC_ACTIVITY);
                        bundle1.putString("ACTIVITYNAME", Constant_Var.OFFICIAL_ACTIVITY_NAME);
                        bundle1.putInt("TYPE_NAME",R.array.ccc_types);
                        bundle1.putInt("TYPE_PIC",R.drawable.officials);
                        Intent intent1 = new Intent(MainActivity.this,Icon_name_List_view.class);
                        intent1.putExtras(bundle1);
                        startActivity(intent1);

                        break;
                    case Constant_Var.EDUCATION_ACTIVITY:
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt("ACTIVITY",Constant_Var.EDUCATION_ACTIVITY);
                        bundle2.putString("ACTIVITYNAME", Constant_Var.EDUCATION_ACTIVITY_NAME);
                        bundle2.putInt("TYPE_NAME",R.array.education_types);
                        bundle2.putInt("TYPE_PIC",R.drawable.education);
                        Intent intent2 = new Intent(MainActivity.this,Icon_name_List_view.class);
                        intent2.putExtras(bundle2);
                        startActivity(intent2);
                        break;

                    case Constant_Var.HEALTH_ACTIVITY:

                        Bundle bundle3 = new Bundle();
                        bundle3.putInt("ACTIVITY",Constant_Var.HEALTH_ACTIVITY);
                        bundle3.putString("ACTIVITYNAME", Constant_Var.HEALTH_ACTIVITY_NAME);
                        bundle3.putInt("TYPE_NAME",R.array.health_types);
                        bundle3.putInt("TYPE_PIC",R.drawable.health);
                        Intent intent3 = new Intent(MainActivity.this,Icon_name_List_view.class);
                        intent3.putExtras(bundle3);
                        startActivity(intent3);
                        break;
                    case Constant_Var.CERTIFICAT_ACTIVITY:
                        Intent intent4 = new Intent(MainActivity.this, PressPdfListActivity.class);
                        startActivity(intent4);

                        break;
                    case Constant_Var.FORMS_ACTIVITY:
                        //medical help
                        try {
                            Intent intent5 = new Intent(MainActivity.this, FormListActivity.class);
                            startActivity(intent5);
                        }
                        catch (Exception e)
                        {


                        }
                            break;
                    case Constant_Var.TAX_ACTIVITY:
                        //beach activity
                        Intent intent6 = new Intent(MainActivity.this,TaxActivity.class);
                        startActivity(intent6);
                        break;
                    case Constant_Var.E_TENDER_ACTIVITY:
                        //lifestyle
                      /*  Intent intent7 = new Intent(MainActivity.this,TenderActivity.class);
                        startActivity(intent7);*/

                        Bundle bundle7 = new Bundle();
                        bundle7.putInt("ACTIVITY",Constant_Var.E_TENDER_ACTIVITY);
                        bundle7.putString("ACTIVITYNAME",Constant_Var.ETENDER_ACTIVITY_NAME);
                        bundle7.putInt("TYPE_NAME",R.array.tenderarray_name);
                        bundle7.putInt("TYPE_PIC",R.drawable.tender);
                        Intent intent7 = new Intent(MainActivity.this,ListViewNormalSecond.class);
                        intent7.putExtras(bundle7);
                        startActivity(intent7);
                        break;
                    case Constant_Var.COMMUNICATION_ACTIVITY:
                        Intent intent8 = new Intent(MainActivity.this,CommunicationActivity.class);
                        startActivity(intent8);
                        break;

                    case Constant_Var.ENTERTAINMENT_ACTIVITY:
                        Bundle bundle9 = new Bundle();
                        bundle9.putInt("ACTIVITY",Constant_Var.ENTERTAINMENT_ACTIVITY);
                        bundle9.putString("ACTIVITYNAME", Constant_Var.ENTERTAINMENT_ACTIVITY_NAME);
                        bundle9.putInt("TYPE_NAME",R.array.entertainment_types);
                        bundle9.putInt("TYPE_PIC",R.array.entertainment_pic);
                        Intent intent9 = new Intent(MainActivity.this,Icon_name_List_view.class);
                        intent9.putExtras(bundle9);
                        startActivity(intent9);
                        break;

                    case Constant_Var.EMARGENCY_ACTIVITY:
                        Bundle bundle10 = new Bundle();
                        bundle10.putInt("ACTIVITY",Constant_Var.EMARGENCY_ACTIVITY);
                        bundle10.putString("ACTIVITYNAME", Constant_Var.EMARGENCY_ACTIVITY_NAME);
                        bundle10.putInt("TYPE_NAME",R.array.emargency_types);
                        bundle10.putInt("TYPE_PIC",R.array.emargency_pic);
                        Intent intent10 = new Intent(MainActivity.this,Icon_name_List_view.class);
                        intent10.putExtras(bundle10);
                        startActivity(intent10);
                        break;
                    case Constant_Var.COMPLAIN_ACTIVITY:
                        Intent intent11 = new Intent(MainActivity.this,ComplainActivityNew.class);
                        startActivity(intent11);
                        break;
                    case Constant_Var.HELPLINE_ACTIVITY:
                        callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:16104"));
                        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
                        }else{
                            startActivity(callIntent);
                        }
                        break;


                }
            }
        });


        TextView textView = (TextView)findViewById(R.id.tx);

        textView.setSelected(true);
        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView.setSingleLine(true);






    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_CALL:
            {
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    startActivity(callIntent);
                }
            }
        }
    }

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/


}

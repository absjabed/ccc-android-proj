package com.parvez_n_jabed_co.ccc_project;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.parvez_n_jabed_co.ccc_project.FormRelatedActivities.FormListActivity;
import com.parvez_n_jabed_co.ccc_project.TaxRelatedActivities.TaxActivity;
import com.parvez_n_jabed_co.ccc_project.TestActivities.LiveTestActivity;


public class GameActivity extends Activity {
	ImageButton imfb,imyoutube,imwebsite,imabtus, imsettings;
	private static final int REQUEST_CALL = 1;
	Intent callIntent;
	GameView gameView;
ImageButton project,services,futureplan,live;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		Window window = getWindow();
		window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		window.setFormat(PixelFormat.RGBA_8888);

		setContentView(R.layout.activity_game);
		gameView=(GameView) findViewById(R.id.myGameView);
		gameView.setActivity(this);

		imfb = (ImageButton) findViewById(R.id.btnfba);
		imyoutube = (ImageButton) findViewById(R.id.btnyoutube);
		imwebsite = (ImageButton) findViewById(R.id.btnwebsite);
		imabtus= (ImageButton) findViewById(R.id.btnabtus);
		//  imtvv = (Button)findViewById(R.id.btnudvodhon);
		imfb.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent webviewIntent = new Intent(GameActivity.this,WebViewActivity.class);
				webviewIntent.putExtra("URL","https://www.facebook.com");
				startActivity(webviewIntent);

			}
		});


		imyoutube.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent webviewIntent = new Intent(GameActivity.this,WebViewActivity.class);
				webviewIntent.putExtra("URL","https://www.youtube.com/channel/UCXa9UQkB_bC2rco11B6wRfw");
				startActivity(webviewIntent);

			}
		});

		imwebsite.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent webviewIntent = new Intent(GameActivity.this,WebViewActivity.class);
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

				Intent webviewIntent = new Intent(GameActivity.this,AboutUsActivity.class);
				startActivity(webviewIntent);

			}
		});






		project = (ImageButton) findViewById(R.id.imbtnproject);
		services = (ImageButton) findViewById(R.id.imbtnservices);
		futureplan = (ImageButton) findViewById(R.id.imbtnfutureplan);
		live = (ImageButton) findViewById(R.id.imbtnlive);
		project.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Bundle bundle2 = new Bundle();
				bundle2.putInt("ACTIVITY",Constant_Var.PROJECT__ACTIVITY);
				bundle2.putString("ACTIVITYNAME","সি/ক প্রজেক্ট সমূহ");
				bundle2.putInt("TYPE_NAME",R.array.project_name);
				bundle2.putInt("TYPE_PIC",R.drawable.forms);
				Intent intent2 = new Intent(GameActivity.this,ListViewNormalSecond.class);
				intent2.putExtras(bundle2);
				startActivity(intent2);

			}
		});
		services.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Bundle bundle1 = new Bundle();
				bundle1.putInt("ACTIVITY",Constant_Var.SERVICES_ACTIVITY);
				bundle1.putInt("TYPE_NAME",R.array.services_list);
				bundle1.putString("ACTIVITYNAME",Constant_Var.SERVICE_ACTIVITY_NAME);
				Intent intent1 = new Intent(GameActivity.this,DefaultListView.class);
				intent1.putExtras(bundle1);
				startActivity(intent1);
			}
		});
		futureplan.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Bundle bundle1 = new Bundle();
				bundle1.putInt("ACTIVITY",Constant_Var.FUTUREPLANE_ACTIVITY);
				bundle1.putInt("TYPE_NAME",R.array.future_plan_list);
				bundle1.putString("ACTIVITYNAME",Constant_Var.FUTUREPLANE_ACTIVITY_NAME);
				Intent intent1 = new Intent(GameActivity.this,DefaultListView.class);
				intent1.putExtras(bundle1);

				startActivity(intent1);

			}
		});
		live.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent webviewIntent = new Intent(GameActivity.this,LiveTestActivity.class);

				startActivity(webviewIntent);
			}
		});




	}

	public   void startActivityCCC() {
		Bundle bundle1 = new Bundle();
		bundle1.putInt("ACTIVITY", Constant_Var.CCC_ACTIVITY);
		bundle1.putString("ACTIVITYNAME", Constant_Var.OFFICIAL_ACTIVITY_NAME);
		bundle1.putInt("TYPE_NAME", R.array.ccc_types);
		bundle1.putInt("TYPE_PIC", R.drawable.officials);
		Intent intent1 = new Intent(GameActivity.this, Icon_name_List_view.class);
		intent1.putExtras(bundle1);
		startActivity(intent1);
	}

	public  void startActivityEducation() {
		Bundle bundle2 = new Bundle();
		bundle2.putInt("ACTIVITY", Constant_Var.EDUCATION_ACTIVITY);
		bundle2.putString("ACTIVITYNAME", Constant_Var.EDUCATION_ACTIVITY_NAME);
		bundle2.putInt("TYPE_NAME", R.array.education_types);
		bundle2.putInt("TYPE_PIC", R.drawable.education);
		Intent intent2 = new Intent(GameActivity.this, Icon_name_List_view.class);
		intent2.putExtras(bundle2);
		startActivity(intent2);
	}
	public  void startActivityHealth() {
		Bundle bundle3 = new Bundle();
		bundle3.putInt("ACTIVITY", Constant_Var.HEALTH_ACTIVITY);
		bundle3.putString("ACTIVITYNAME", Constant_Var.HEALTH_ACTIVITY_NAME);
		bundle3.putInt("TYPE_NAME", R.array.health_types);
		bundle3.putInt("TYPE_PIC", R.drawable.health);
		Intent intent3 = new Intent(GameActivity.this, Icon_name_List_view.class);
		intent3.putExtras(bundle3);
		startActivity(intent3);
	}
	public  void startActivityCirtificate() {
		Intent intent4 = new Intent(GameActivity.this, PressPdfListActivity.class);
		startActivity(intent4);
	}

	public  void startActivityForms() {

		//medical help
		try {
			Intent intent5 = new Intent(GameActivity.this, FormListActivity.class);
			startActivity(intent5);
		} catch (Exception e) {


		}
	}

	public  void startActivityTax() {
		//beach activity
		Intent intent6 = new Intent(GameActivity.this, TaxActivity.class);
		startActivity(intent6);
	}
	public  void startActivityTender() {
		//lifestyle
                      /*  Intent intent7 = new Intent(GameActivity.this,TenderActivity.class);
                        startActivity(intent7);*/

		Bundle bundle7 = new Bundle();
		bundle7.putInt("ACTIVITY", Constant_Var.E_TENDER_ACTIVITY);
		bundle7.putString("ACTIVITYNAME", Constant_Var.ETENDER_ACTIVITY_NAME);
		bundle7.putInt("TYPE_NAME", R.array.tenderarray_name);
		bundle7.putInt("TYPE_PIC", R.drawable.tender);
		Intent intent7 = new Intent(GameActivity.this, ListViewNormalSecond.class);
		intent7.putExtras(bundle7);
		startActivity(intent7);
	}
	public  void startActivityComunication() {
		Intent intent8 = new Intent(GameActivity.this, CommuwithMeyor.class);
		startActivity(intent8);
	}

	public  void startActivityEntertainment() {
		Bundle bundle9 = new Bundle();
		bundle9.putInt("ACTIVITY", Constant_Var.ENTERTAINMENT_ACTIVITY);
		bundle9.putString("ACTIVITYNAME", Constant_Var.ENTERTAINMENT_ACTIVITY_NAME);
		bundle9.putInt("TYPE_NAME", R.array.entertainment_types);
		bundle9.putInt("TYPE_PIC", R.array.entertainment_pic);
		Intent intent9 = new Intent(GameActivity.this, Icon_name_List_view.class);
		intent9.putExtras(bundle9);
		startActivity(intent9);
	}

	public  void startActivityEmargency() {
		Bundle bundle10 = new Bundle();
		bundle10.putInt("ACTIVITY", Constant_Var.EMARGENCY_ACTIVITY);
		bundle10.putString("ACTIVITYNAME", Constant_Var.EMARGENCY_ACTIVITY_NAME);
		bundle10.putInt("TYPE_NAME", R.array.emargency_types);
		bundle10.putInt("TYPE_PIC", R.array.emargency_pic);
		Intent intent10 = new Intent(GameActivity.this, Icon_name_List_view.class);
		intent10.putExtras(bundle10);
		startActivity(intent10);
	}
	public  void startActivityComplain() {
		Intent intent11 = new Intent(GameActivity.this, ComplainActivityNew.class);
		startActivity(intent11);
	}
	public  void startActivityHealpline() {
		callIntent = new Intent(Intent.ACTION_CALL);
		callIntent.setData(Uri.parse("tel:16104"));
		if (ContextCompat.checkSelfPermission(GameActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
			ActivityCompat.requestPermissions(GameActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
		} else {
			startActivity(callIntent);
		}
	}






}

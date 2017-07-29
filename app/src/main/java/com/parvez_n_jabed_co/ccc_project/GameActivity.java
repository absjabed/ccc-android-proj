package com.parvez_n_jabed_co.ccc_project;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

import com.parvez_n_jabed_co.ccc_project.FormRelatedActivities.FormListActivity;
import com.parvez_n_jabed_co.ccc_project.TaxRelatedActivities.TaxActivity;


public class GameActivity extends Activity {

	private static final int REQUEST_CALL = 1;
	Intent callIntent;
	GameView gameView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		gameView=new GameView(this,this);
		setContentView(gameView);




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

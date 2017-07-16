package com.parvez_n_jabed_co.ccc_project;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Icon_name_List_view extends AppCompatActivity implements AdapterView.OnItemClickListener {

   TextView activity_title ;
    String[] hospital_names= new String[20];
int activity;
    List<TransportItem> rowItems;
    ListView mylistview;
    TypedArray hospital_pics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setLogo(R.drawable.title_ixom2);
 //       getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_icon_name__list_view);

        rowItems = new ArrayList<TransportItem>();

        Bundle bundle = getIntent().getExtras();

        int name_type_address  = bundle.getInt("TYPE_NAME");
        int img_pic  = bundle.getInt("TYPE_PIC");
        String activityname = bundle.getString("ACTIVITYNAME");
        activity = bundle.getInt("ACTIVITY");
        hospital_names = getResources().getStringArray(name_type_address);
        activity_title = (TextView) findViewById(R.id.activityTitle);
        activity_title.setText(activityname);

        if(activity == Constant_Var.EMARGENCY_ACTIVITY || activity == Constant_Var.ENTERTAINMENT_ACTIVITY)
        {

            hospital_pics = getResources().obtainTypedArray(img_pic);
            for (int i = 0; i < hospital_names.length; i++) {

                // TransportItem item = new TransportItem(hospital_names[i], trans_pic.getResourceId(i,0));
                TransportItem item = new TransportItem(hospital_names[i], hospital_pics.getResourceId(i,0));

                rowItems.add(i, item);
            }
        }
  else {
            for (int i = 0; i < hospital_names.length; i++) {

                // TransportItem item = new TransportItem(hospital_names[i], trans_pic.getResourceId(i,0));
                TransportItem item = new TransportItem(hospital_names[i], img_pic);

                rowItems.add(i, item);
            }
        }
        mylistview = (ListView) findViewById(R.id.icon_list_view);
        TransportAdepter adapter = new TransportAdepter(this, rowItems);
        mylistview.setAdapter(adapter);

        mylistview.setOnItemClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.allmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_info) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        String hospital_name = rowItems.get(position).getTrans_type();
        Toast.makeText(getApplicationContext(), "" + hospital_name,
                Toast.LENGTH_SHORT).show();

        if(activity==Constant_Var.CCC_ACTIVITY)
        {
            Intent intent = Icon_List_All_Function.ccc_list(Icon_name_List_view.this,position);

            if(intent!=null)
                startActivity(intent);
        }

        else if(activity==Constant_Var.EDUCATION_ACTIVITY) {

            Intent intent = Icon_List_All_Function.edu_list(Icon_name_List_view.this,position);
            if(intent!=null)
                startActivity(intent);

        }
        else if(activity==Constant_Var.EMARGENCY_ACTIVITY) {

            Intent intent = Icon_List_All_Function.emarg_list(Icon_name_List_view.this,position);
            if(intent!=null)
                startActivity(intent);

        }
        else if(activity==Constant_Var.ENTERTAINMENT_ACTIVITY) {

            Intent intent = Icon_List_All_Function.entertainment_list(Icon_name_List_view.this,position);
            if(intent!=null)
                startActivity(intent);

        }
        else if(activity==Constant_Var.HEALTH_ACTIVITY) {

            Intent intent = Icon_List_All_Function.health_list(Icon_name_List_view.this,position);
            if(intent!=null)
                startActivity(intent);

        }
        else if(activity==Constant_Var.EVENT_ACTIVITY) {

            Intent intent = Icon_List_All_Function.event_list(Icon_name_List_view.this,position);
            if(intent!=null)
                startActivity(intent);

        }

    }

}

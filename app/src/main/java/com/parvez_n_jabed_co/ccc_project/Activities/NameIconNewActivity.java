package com.parvez_n_jabed_co.ccc_project.Activities;


import android.app.AlertDialog;
import android.content.DialogInterface;
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

import com.parvez_n_jabed_co.ccc_project.R;
import com.parvez_n_jabed_co.ccc_project.Adapters.TransportAdepter;
import com.parvez_n_jabed_co.ccc_project.Adapters.TransportItem;

import java.util.ArrayList;
import java.util.List;

public class NameIconNewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    TextView activity_title ;
    String[] hospital_names= new String[50];
    String[] hospital_address= new String[50];
    String[] hospital_openday= new String[50];
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
        setContentView(R.layout.activity_name_icon_new);

        rowItems = new ArrayList<TransportItem>();

        Bundle bundle = getIntent().getExtras();

        int name_type_address  = bundle.getInt("TYPE_NAME");
        int address_type_address = bundle.getInt("TYPE_ADDRESS");
        int openday_type_address = bundle.getInt("TYPE_OPENDAY");
        int img_pic  = bundle.getInt("TYPE_PIC");
        String activityname = bundle.getString("ACTIVITYNAME");
        activity = bundle.getInt("ACTIVITY");
        hospital_names = getResources().getStringArray(name_type_address);
        hospital_address = getResources().getStringArray(address_type_address);
        hospital_openday = getResources().getStringArray(openday_type_address);
        activity_title = (TextView) findViewById(R.id.activityTitle);
        activity_title.setText(activityname);


            for (int i = 0; i < hospital_names.length; i++) {

                // TransportItem item = new TransportItem(hospital_names[i], trans_pic.getResourceId(i,0));
                TransportItem item = new TransportItem(hospital_names[i], img_pic);

                rowItems.add(i, item);
            }

        mylistview = (ListView) findViewById(R.id.icon_list_view_new);
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


       // String hospital_name = rowItems.get(position).getTrans_type();

       final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(hospital_address[position]+"\n"+hospital_openday[position]).setTitle(hospital_names[position])
                .setCancelable(true)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.dismiss();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }

}

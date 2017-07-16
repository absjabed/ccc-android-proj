package com.parvez_n_jabed_co.ccc_project;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GroupFixedImgLVActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    String[] hospital_names= new String[200];
    TypedArray hospital_pics;

    String[] hospital_email;
    String[] hospital_mobile;
    int activity;
    List<RowItem> rowItems;
    ListView mylistview;
    TextView activity_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_fixed_img_lv);
        rowItems = new ArrayList<RowItem>();




        Bundle bundle = getIntent().getExtras();
        int image_res_address = bundle.getInt("RES_IMAGE");
        int name_res_address  = bundle.getInt("RES_NAME");
        int email_res_address  = bundle.getInt("RES_EMAIL");
        int mobile_res_address  = bundle.getInt("RES_MOBILE");

        String activityname = bundle.getString("ACTIVITYNAME");

        activity_title = (TextView) findViewById(R.id.activityTitle);
        activity_title.setText(activityname);

        if(mobile_res_address==-1)
        {

            activity = bundle.getInt("ACTIVITY");
            hospital_names = getResources().getStringArray(name_res_address);
            hospital_email = getResources().getStringArray(email_res_address);

            for (int i = 0; i < hospital_names.length; i++) {

                RowItem item = new RowItem(hospital_names[i], image_res_address, hospital_email[i], "");
                rowItems.add(i, item);
            }

        }
        else {

    activity = bundle.getInt("ACTIVITY");
    hospital_names = getResources().getStringArray(name_res_address);
    hospital_email = getResources().getStringArray(email_res_address);
    hospital_mobile = getResources().getStringArray(mobile_res_address);
    for (int i = 0; i < hospital_names.length; i++) {

        RowItem item = new RowItem(hospital_names[i], image_res_address, hospital_email[i], hospital_mobile[i]);
        rowItems.add(i, item);
    }

}

        mylistview = (ListView) findViewById(R.id.res2_listview);
        Restaurant2Adapter adapter = new Restaurant2Adapter(this, rowItems);
        mylistview.setAdapter(adapter);

        mylistview.setOnItemClickListener(this);



    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}

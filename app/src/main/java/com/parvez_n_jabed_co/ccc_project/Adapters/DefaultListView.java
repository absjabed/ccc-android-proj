package com.parvez_n_jabed_co.ccc_project.Adapters;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.parvez_n_jabed_co.ccc_project.R;

public class DefaultListView extends AppCompatActivity {
ListView listView;
    String[] arraylistitems;
    int activity;
    TextView activity_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_list_view);

        listView = (ListView)findViewById(R.id.defaultlistview);



        Bundle bundle = getIntent().getExtras();

        int arrayvalue = bundle.getInt("TYPE_NAME");
        activity = bundle.getInt("ACTIVITY");
        String activityname = bundle.getString("ACTIVITYNAME");


        activity_title = (TextView) findViewById(R.id.activityTitle);
        if(activityname!=null)
        activity_title.setText(activityname);

        arraylistitems = getResources().getStringArray(arrayvalue);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,arraylistitems){

            // Just to change the color of project list items
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view =super.getView(position, convertView, parent);

                TextView textView=(TextView) view.findViewById(android.R.id.text1);

            /*YOUR CHOICE OF COLOR*/
                textView.setTextColor(Color.WHITE);

                return view;
            }
        };
        listView.setAdapter(adapter);

    }
}



package com.parvez_n_jabed_co.ccc_project.Activities.FormRelatedActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.parvez_n_jabed_co.ccc_project.Adapters.CustomList;
import com.parvez_n_jabed_co.ccc_project.R;
import com.parvez_n_jabed_co.ccc_project.Activities.WebViewActivity;

public class TreadLisenseForms extends AppCompatActivity {
    ListView list;
    String[] web = {
            "ট্রেড লাইসেন্স এর আবেদন ফর্ম",
            "ট্রেড লাইসেন্স নবায়ন ফর্ম"
    } ;
    int imageId = R.drawable.ccc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tread_lisense_forms);


        CustomList adapter = new CustomList(TreadLisenseForms.this, web, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                if(position==FormTypes.TRADE_LICENSE)
                {
                    Intent intent = new Intent(TreadLisenseForms.this,WebViewActivity.class);
                    intent.putExtra("URL","https://goo.gl/VSY8kc"); //https://drive.google.com/file/d/0ByXcNtvRHMV6cW5iUW9LYWNjYXc/view
                    intent.putExtra("visible",1);
                    startActivity(intent);
                }
                else if(position==FormTypes.RENEW_TRADE_LICENSE)
                {
                    Intent intent = new Intent(TreadLisenseForms.this,WebViewActivity.class);
                    intent.putExtra("URL","https://goo.gl/cBCJYJ");  //https://drive.google.com/file/d/0ByXcNtvRHMV6c29EMXhqRWp4WVU/view
                    intent.putExtra("visible",1);
                    startActivity(intent);
                }
            }
        });
    }
}

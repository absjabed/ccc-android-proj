package com.parvez_n_jabed_co.ccc_project.FormRelatedActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.parvez_n_jabed_co.ccc_project.OnlyClasses.CustomList;
import com.parvez_n_jabed_co.ccc_project.R;
import com.parvez_n_jabed_co.ccc_project.WebViewActivity;

public class OtherVariousFormsActivity extends AppCompatActivity {
    ListView list;
    String[] web = {
            "জন্ম নিবন্ধন ফর্ম",
            "জন্ম নিবন্ধন ফর্ম (অনলাইন আবেদন)",
            "মৃত্যু নিবন্ধন ফর্ম",
            "\tমূল্যায়ন এবং মূল্যনির্ধারণের \nবিরুদ্ধে আপত্তির পিটিশন ফর্ম",
            "\tতথ্য পরিবর্তন (রেকর্ড পরিবর্তন)\n করার জন্যে আবেদন ফর্ম",
            "সেপ্টিক ট্যাংক পরিষ্কারের জন্যে \nআবেদন ফর্ম"
    } ;
    /*Integer[] imageId = {
            R.drawable.ccc,
            R.drawable.ccc,
            R.drawable.ccc,
            R.drawable.ccc,
            R.drawable.ccc,
            R.drawable.ccc,
            R.drawable.ccc,
            R.drawable.ccc

    };
    */
    int imageId = R.drawable.ccc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_various_forms);

        CustomList adapter = new CustomList(OtherVariousFormsActivity.this, web, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                if(position==FormTypes.BIRTH_CERTIFICATE) {
                    Intent intent = new Intent(OtherVariousFormsActivity.this, WebViewActivity.class);
                    intent.putExtra("URL", "https://goo.gl/5jtGoU"); //https://drive.google.com/file/d/0ByXcNtvRHMV6aEQ0M1o5T25Ud2c/view
                    intent.putExtra("visible",1);
                    startActivity(intent);
                }else if(position==FormTypes.BIRTH_CERTIFICATE_ONLINE) {
                    Intent intent = new Intent(OtherVariousFormsActivity.this, WebViewActivity.class);
                    intent.putExtra("URL", "https://goo.gl/77ihLc"); //https://bris.lgd.gov.bd/pub/?pg=application_form
                    startActivity(intent);
                }
                else if(position==FormTypes.DEATH_CERTIFICATE) {
                    Intent intent = new Intent(OtherVariousFormsActivity.this, WebViewActivity.class);
                    intent.putExtra("URL", "https://goo.gl/A16AUX");  //https://drive.google.com/file/d/0ByXcNtvRHMV6Y1ctV1JBVzVHeTA/view
                    intent.putExtra("visible",1);
                    startActivity(intent);
                }
                else if(position==FormTypes.ASSISMENT_VALUEATION_OBJECTION) {
                    Intent intent = new Intent(OtherVariousFormsActivity.this, WebViewActivity.class);
                    intent.putExtra("URL", "https://goo.gl/k25Gyi"); //https://drive.google.com/file/d/0ByXcNtvRHMV6VFIxM242QlQ4aFE/view
                    intent.putExtra("visible",1);
                    startActivity(intent);
                }
                else if(position==FormTypes.MUTATION_APPLICATION_MULLAYON) {
                    Intent intent = new Intent(OtherVariousFormsActivity.this, WebViewActivity.class);
                    intent.putExtra("URL", "https://goo.gl/cyr64v");  //https://drive.google.com/file/d/0ByXcNtvRHMV6OTlRcHIyTkp6bGM/view
                    intent.putExtra("visible",1);
                    startActivity(intent);
                }
                else if(position==FormTypes.SEPTIK_TANK_CLEANING) {
                    Intent intent = new Intent(OtherVariousFormsActivity.this, WebViewActivity.class);
                    intent.putExtra("URL", "https://goo.gl/LnbqYt");  //https://drive.google.com/file/d/0ByXcNtvRHMV6d0c2TjNJWmk2UkE/view
                    intent.putExtra("visible",1);
                    startActivity(intent);
                }
            }
        });
    }
}

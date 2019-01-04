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

public class TaxRelatedFormsActivity extends AppCompatActivity {
    ListView list;
    String[] web = {
            "ট্যাক্স পরিশোধের ফর্ম",
            "দোকান হস্তান্তরের আবেদনের ফর্ম",
            "দোকানের অস্থায়ী চুক্তিপত্রের ফর্ম",
            "ফ্ল্যাট এর আবেদনের ফর্ম",
            "ফ্ল্যাট বরাদ্দের আবেদন ফর্ম",
            "হাউজিং প্রকল্পের আবেদনের ফর্ম"
    } ;
/*    Integer[] imageId = {
            R.drawable.ccc,
            R.drawable.ccc,
            R.drawable.ccc,
            R.drawable.ccc,
            R.drawable.ccc,
            R.drawable.ccc

    };*/

    int imageId = R.drawable.ccc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax_related_forms);

        CustomList adapter = new CustomList(TaxRelatedFormsActivity.this, web, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                if(position==FormTypes.TAX_PAYMENT_FORM)
                {
                    Intent intent = new Intent(TaxRelatedFormsActivity.this,WebViewActivity.class);
                    intent.putExtra("URL","https://goo.gl/45UTzV");// https://drive.google.com/file/d/0ByXcNtvRHMV6OHZ1UVh1dXRqSnc/view
                    intent.putExtra("visible",1);
                    startActivity(intent);
//                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/file/d/0ByXcNtvRHMV6OHZ1UVh1dXRqSnc/view"));
//                    String title = "Complete Action Using";
//                    Intent chooser = Intent.createChooser(intent, title);
//                    startActivity(chooser);
                }
                else if(position==FormTypes.DOKAN_HOSTANTOR)
                {
                    Intent intent = new Intent(TaxRelatedFormsActivity.this,WebViewActivity.class);
                    intent.putExtra("URL","https://goo.gl/nQVTPF");  //https://drive.google.com/file/d/0ByXcNtvRHMV6ZXNYZThwX0VfYVE/view
                    intent.putExtra("visible",1);
                    startActivity(intent);
                }
                else if(position==FormTypes.DOKANER_OSTHAYI_CHUKTI) {
                    Intent intent = new Intent(TaxRelatedFormsActivity.this, WebViewActivity.class);
                    intent.putExtra("URL", "https://goo.gl/UasUCW");  //https://drive.google.com/file/d/0ByXcNtvRHMV6OEZhZkFZeDFZZG8/view
                    startActivity(intent);
                }
                else if(position==FormTypes.FLAT_ER_ABEDON_FORM) {
                    Intent intent = new Intent(TaxRelatedFormsActivity.this, WebViewActivity.class);
                    intent.putExtra("URL", "https://goo.gl/gQSZDM");  //https://drive.google.com/file/d/0ByXcNtvRHMV6SmJZeUtzQ3VOaTA/view
                    intent.putExtra("visible",1);
                    startActivity(intent);
                }
                else if(position==FormTypes.FLAT_BORADDER_ABEDON) {
                    Intent intent = new Intent(TaxRelatedFormsActivity.this, WebViewActivity.class);
                    intent.putExtra("URL", "https://goo.gl/YVRECn"); //https://drive.google.com/file/d/0ByXcNtvRHMV6MnoxT09DWHo2S1U/view
                    intent.putExtra("visible",1);
                    startActivity(intent);
                }
                else if(position==FormTypes.HOUSING_PROKOLPER_ABEDON) {
                    Intent intent = new Intent(TaxRelatedFormsActivity.this, WebViewActivity.class);
                    intent.putExtra("URL", "https://goo.gl/tLEVKK"); //https://drive.google.com/file/d/0ByXcNtvRHMV6SDNmV19VTkQ4Qk0/view
                    intent.putExtra("visible",1);
                    startActivity(intent);
                }
            }
        });

    }
}

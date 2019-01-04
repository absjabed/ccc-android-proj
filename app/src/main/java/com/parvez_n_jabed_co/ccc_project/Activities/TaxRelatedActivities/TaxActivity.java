package com.parvez_n_jabed_co.ccc_project.Activities.TaxRelatedActivities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.parvez_n_jabed_co.ccc_project.Activities.FormRelatedActivities.FormTypes;
import com.parvez_n_jabed_co.ccc_project.Adapters.CustomList;
import com.parvez_n_jabed_co.ccc_project.R;

public class TaxActivity extends AppCompatActivity {

    ListView list;
    String[] web = {
            "হোল্ডিং ট্যাক্স পরিশোধ",
            "পুনঃ মূল্যায়নের অনুরোধ"
    } ;

    ListView list2;
    String[] web2 = {
            "ট্যাক্স প্রদান সম্পর্কিত",
            "ট্রেড লাইসেন্স সম্পর্কিত",
            "রাজস্ব  সার্কেল অফিস সমূহ"
           // "রাজস্ব  সার্কেল সম্পর্কিত"
    } ;
    int imageId = R.drawable.ccc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax);

        CustomList adapter = new
                CustomList(TaxActivity.this, web, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                if(position== FormTypes.HOLDING_TAX_PAYMENT)
                {
//                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
//                            Uri.parse("www.ccctax.org"));
//                    startActivity(browserIntent);
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ccctax.org/"));
                    String title = "অন্য অ্যাপ্লিকেশন দিয়ে লিংকটি ওপেন করুন";
                    Intent chooser = Intent.createChooser(intent, title);
                    startActivity(chooser);

                }
                else if(position==FormTypes.RE_CHECK_TAX_REQUEST)
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ccctax.org/"));
                    String title = "অন্য অ্যাপ্লিকেশন দিয়ে লিংকটি ওপেন করুন";
                    Intent chooser = Intent.createChooser(intent, title);
                    startActivity(chooser);
                    /*Intent intent = new Intent(TaxActivity.this,ReCheckTaxActivity1.class);
                    startActivity(intent);*/
                }
            }
        });

        CustomList adapter2 = new
                CustomList(TaxActivity.this, web2, imageId);
        list2=(ListView)findViewById(R.id.list2);
        list2.setAdapter(adapter2);
        list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                if(position== FormTypes.TAX_PAYMENT_INFO)
                {
                    Intent intent = new Intent(TaxActivity.this,TaxPaymentInfoActivity.class);
                    startActivity(intent);
                }
                else if(position==FormTypes.TRADE_LIC_INFO)
                {
                    Intent intent = new Intent(TaxActivity.this,TradeLiscenceInfoActivity.class);
                    startActivity(intent);
                }
                else if(position==FormTypes.REVENUE_CIRCLE_OFFICE)
                {
                    Intent intent = new Intent(TaxActivity.this,RevenueCircleOfficeInfo.class);
                    startActivity(intent);
                }
           /*     else if(position==FormTypes.REVENUE_CIRCLE_INFO)
                {
                    Intent intent = new Intent(TaxActivity.this,RevenueCircleInfo.class);
                    startActivity(intent);
                }*/
            }
        });
    }
}

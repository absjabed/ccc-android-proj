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

public class FormListActivity extends AppCompatActivity {

    ListView list;
    String[] web = {
            "রাজস্ব বিভাগের ফর্ম সমূহ (এস্টেট)",
            "দরপত্র সম্পর্কিত ফর্ম সমূহ",
            "ট্রেড লাইসেন্স সম্পর্কিত ফর্ম সমূহ",
            " বিভিন্ন নিবন্ধন ও অন্যান্য ফর্ম সমূহ"
    } ;
   /* Integer[] imageId = {
            R.drawable.ccc,
            R.drawable.ccc,
            R.drawable.ccc

    };*/

    int imageId = R.drawable.ccc;
    //http://www.ccc.org.bd/sites/default/files/downloads/Sample%20Trade%20Licence%20Application%20Form.pdf
    //http://www.ccc.org.bd/sites/default/files/downloads/Death%20Registration.pdf
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_list);

        int imageId = R.drawable.ccc;

        CustomList adapter = new
                CustomList(FormListActivity.this, web, imageId);
        list=(ListView)findViewById(R.id.form_list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                if(position==FormTypes.RAJOSSHO_BIVAG_ER_FORMS)
                {
                    Intent intent = new Intent(FormListActivity.this,TaxRelatedFormsActivity.class);
                    startActivity(intent);
                }
                else if(position==FormTypes.TENDER_ER_FORMS)
                {
                   Intent intent = new Intent(FormListActivity.this,TenderRelatedFormsActivity.class);
                    startActivity(intent);
                }
                else if(position==FormTypes.TREAD_FORMS) {
                    Intent intent = new Intent(FormListActivity.this, TreadLisenseForms.class);
                    startActivity(intent);
                }
                else if(position==FormTypes.OTHER_FORMS) {
                    Intent intent = new Intent(FormListActivity.this, OtherVariousFormsActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}

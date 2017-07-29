package com.parvez_n_jabed_co.ccc_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.parvez_n_jabed_co.ccc_project.FormRelatedActivities.FormListActivity;
import com.parvez_n_jabed_co.ccc_project.FormRelatedActivities.FormTypes;
import com.parvez_n_jabed_co.ccc_project.FormRelatedActivities.OtherVariousFormsActivity;
import com.parvez_n_jabed_co.ccc_project.FormRelatedActivities.TaxRelatedFormsActivity;
import com.parvez_n_jabed_co.ccc_project.FormRelatedActivities.TenderRelatedFormsActivity;
import com.parvez_n_jabed_co.ccc_project.OnlyClasses.CustomList;
import com.parvez_n_jabed_co.ccc_project.R;

public class PressPdfListActivity extends AppCompatActivity {


    ListView list;
    String[] web = {
            "সর্বশেষ প্রেস রিলিজ সমূহ",
            "প্রেস রিলিজ 28-07-2017",
            "প্রেস রিলিজ 27-07-2017",
            "প্রেস রিলিজ 26-07-2017",
            "প্রেস রিলিজ 25-07-2017",
            "প্রেস রিলিজ 24-07-2017",
            "প্রেস রিলিজ 23-07-2017",
            "প্রেস রিলিজ 22-07-2017"

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
    };*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_press_pdf_list);

        CustomList adapter = new
                CustomList(PressPdfListActivity.this, web, R.drawable.ccc);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                /*Intent intent = new Intent(OtherVariousFormsActivity.this, WebViewActivity.class);
                    intent.putExtra("URL", "https://drive.google.com/file/d/0ByXcNtvRHMV6aEQ0M1o5T25Ud2c/view");
                    intent.putExtra("visible",1);
                    startActivity(intent);*/

                /*
                *  Now here we don't need any external Pdf Library to view Pdfs here.....
                * */

                if(position == 0)
                {
                    Intent intent = new Intent(PressPdfListActivity.this,WebViewActivity.class);
                    intent.putExtra("URL", "http://www.ccc.org.bd/press-release");
                    startActivity(intent);
                }
                else if(position==1)
                {
                    Intent intent = new Intent(PressPdfListActivity.this,WebViewActivity.class);
                    intent.putExtra("URL", "http://www.ccc.org.bd/press-release-28-07-2017");
                    startActivity(intent);
                }
                else if(position==2) {
                    Intent intent = new Intent(PressPdfListActivity.this, WebViewActivity.class);
                    intent.putExtra("URL", "http://www.ccc.org.bd/press-release-27-07-2017");
                    startActivity(intent);
                }
                else if(position==3) {
                    Intent intent = new Intent(PressPdfListActivity.this, WebViewActivity.class);
                    intent.putExtra("URL", "http://www.ccc.org.bd/press-release-26-07-2017");
                    startActivity(intent);
                }
                else if(position==4) {
                    Intent intent = new Intent(PressPdfListActivity.this, WebViewActivity.class);
                    intent.putExtra("URL", "http://www.ccc.org.bd/press-release-25-07-2017");
                    startActivity(intent);
                }
                else if(position==5) {
                    Intent intent = new Intent(PressPdfListActivity.this, WebViewActivity.class);
                    intent.putExtra("URL", "http://www.ccc.org.bd/press-release-24-07-2017");
                    startActivity(intent);
                }
                else if(position==6) {
                    Intent intent = new Intent(PressPdfListActivity.this, WebViewActivity.class);
                    intent.putExtra("URL", "http://www.ccc.org.bd/press-release-23-07-2017");
                    startActivity(intent);
                }
                else if(position==7) {
                    Intent intent = new Intent(PressPdfListActivity.this, WebViewActivity.class);
                    intent.putExtra("URL", "http://www.ccc.org.bd/press-release-22-07-2017");
                    startActivity(intent);
                }
            }
        });

    }
}

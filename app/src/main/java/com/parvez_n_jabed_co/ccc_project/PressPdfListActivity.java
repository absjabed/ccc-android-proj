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
            "প্রেস রিলিজ 12-07-2017",
            "প্রেস রিলিজ 11-07-2017",
            "প্রেস রিলিজ 10-07-2017",
            "প্রেস রিলিজ 09-07-2017",
            "প্রেস রিলিজ 08-07-2017",
            "প্রেস রিলিজ 07-07-2017",
            "প্রেস রিলিজ 05-07-2017"

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
                    intent.putExtra("URL", "http://www.ccc.org.bd/sites/default/files/press/Press%20Release%2012-07-2017_0.pdf");
                    intent.putExtra("visible",1);
                    startActivity(intent);
                }
                else if(position==2) {
                    Intent intent = new Intent(PressPdfListActivity.this, WebViewActivity.class);
                    intent.putExtra("URL", "http://www.ccc.org.bd/sites/default/files/press/Press%20Release%20110-07-2017.pdf");
                    intent.putExtra("visible",1);
                    startActivity(intent);
                }
                else if(position==3) {
                    Intent intent = new Intent(PressPdfListActivity.this, WebViewActivity.class);
                    intent.putExtra("URL", "http://www.ccc.org.bd/sites/default/files/press/Press%20Release%2010-07-2017.pdf");
                    intent.putExtra("visible",1);
                    startActivity(intent);
                }
                else if(position==4) {
                    Intent intent = new Intent(PressPdfListActivity.this, WebViewActivity.class);
                    intent.putExtra("URL", "http://www.ccc.org.bd/sites/default/files/press/Press%20Release%2009-07-2017.pdf");
                    intent.putExtra("visible",1);
                    startActivity(intent);
                }
                else if(position==5) {
                    Intent intent = new Intent(PressPdfListActivity.this, WebViewActivity.class);
                    intent.putExtra("URL", "http://www.ccc.org.bd/sites/default/files/press/Press%20Release%2008-07-2017.pdf");
                    intent.putExtra("visible",1);
                    startActivity(intent);
                }
                else if(position==6) {
                    Intent intent = new Intent(PressPdfListActivity.this, WebViewActivity.class);
                    intent.putExtra("URL", "http://www.ccc.org.bd/sites/default/files/press/Press%20Release%2007-07-2017.pdf");
                    intent.putExtra("visible",1);
                    startActivity(intent);
                }
                else if(position==7) {
                    Intent intent = new Intent(PressPdfListActivity.this, WebViewActivity.class);
                    intent.putExtra("URL", "http://www.ccc.org.bd/sites/default/files/press/Press%20Release%2005-07-2017.pdf");
                    intent.putExtra("visible",1);
                    startActivity(intent);
                }
            }
        });

    }
}

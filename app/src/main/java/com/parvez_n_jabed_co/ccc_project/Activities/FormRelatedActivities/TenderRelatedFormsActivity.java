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

public class TenderRelatedFormsActivity extends AppCompatActivity {
    ListView list;
    String[] web = {
           "হাট-বাজার এর দরপত্র ফর্ম",
            "দোকানের দরপত্র ফর্ম",
            "নার্সারীর দরপত্র ফর্ম",
            "ফ্লোরের দরপত্র ফর্ম",
           "পশু জবইখানার দরপত্র ফর্ম",
            "গণশৌচাগার দরপত্র ফর্ম",
            "\t\tপার্কিং এর দরপত্র প্রদানের \n নির্ধারিত ইজারার শর্তাবলী সম্বলিত ফর্ম",
            "\t\tফেরীঘাট এর দরপত্র প্রদানের \n নির্ধারিত ইজারা শর্তাবলী সম্বলিত ফর্ম"
    } ;
   /* Integer[] imageId = {
            R.drawable.ccc,
            R.drawable.ccc,
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
        setContentView(R.layout.activity_tender_related_forms);

        CustomList adapter = new CustomList(TenderRelatedFormsActivity.this, web, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                if(position==FormTypes.HAT_BAZARER_DORPOTRO)
                {
                    Intent intent = new Intent(TenderRelatedFormsActivity.this,WebViewActivity.class);
                    intent.putExtra("URL","https://goo.gl/scWLpW"); //https://drive.google.com/file/d/0ByXcNtvRHMV6ZU9WRDdnSnBtcXM/view
                    intent.putExtra("visible",1);
                    startActivity(intent);
                }
                else if(position==FormTypes.DOKANER_DORPOTRO)
                {
                    Intent intent = new Intent(TenderRelatedFormsActivity.this,WebViewActivity.class);
                    intent.putExtra("URL","https://goo.gl/vz2Vg5"); //https://drive.google.com/file/d/0ByXcNtvRHMV6ejZENnNSYUZ1YUE/view
                    intent.putExtra("visible",1);
                    startActivity(intent);
                }
                else if(position==FormTypes.NARSARI_ER_DORPOTRO) {
                    Intent intent = new Intent(TenderRelatedFormsActivity.this, WebViewActivity.class);
                    intent.putExtra("URL", "https://goo.gl/QKyVxz"); //https://drive.google.com/file/d/0ByXcNtvRHMV6aXBETzBOa3NIbDg/view
                    intent.putExtra("visible",1);
                    startActivity(intent);
                }
                else if(position==FormTypes.FLOOR_ER_DORPOTRO) {
                    Intent intent = new Intent(TenderRelatedFormsActivity.this, WebViewActivity.class);
                    intent.putExtra("URL", "https://goo.gl/84NPnE"); //https://drive.google.com/file/d/0ByXcNtvRHMV6OVZERHdwNjhaT0k/view
                    intent.putExtra("visible",1);
                    startActivity(intent);
                }
                else if(position==FormTypes.POSHU_JOBAI_KHANAR_DORPOTRO) {
                    Intent intent = new Intent(TenderRelatedFormsActivity.this, WebViewActivity.class);
                    intent.putExtra("URL", "https://goo.gl/nnWpYz"); //https://drive.google.com/file/d/0ByXcNtvRHMV6cnFUUmFtbHlZMjg/view
                    intent.putExtra("visible",1);
                    startActivity(intent);
                }
                else if(position==FormTypes.TOILET_ER_DORPOTRO) {
                    Intent intent = new Intent(TenderRelatedFormsActivity.this, WebViewActivity.class);
                    intent.putExtra("URL", "https://goo.gl/brwA5p"); //https://drive.google.com/file/d/0ByXcNtvRHMV6X2E5eVdSRE1DRGs/view
                    intent.putExtra("visible",1);
                    startActivity(intent);
                }
                else if(position==FormTypes.PARKING_ER_DORPOTRO) {
                    Intent intent = new Intent(TenderRelatedFormsActivity.this, WebViewActivity.class);
                    intent.putExtra("URL", "https://goo.gl/YcY2cb");  //https://drive.google.com/file/d/0ByXcNtvRHMV6OGh6REIzbzZ3M28/view
                    intent.putExtra("visible",1);
                    startActivity(intent);
                }
                else if(position==FormTypes.FERI_GHAT_ER_DORPOTRO) {
                    Intent intent = new Intent(TenderRelatedFormsActivity.this, WebViewActivity.class);
                    intent.putExtra("URL", "https://goo.gl/RgSVyA"); //https://drive.google.com/file/d/0ByXcNtvRHMV6QTZVZURGWW1aMW8/view
                    intent.putExtra("visible",1);
                    startActivity(intent);
                }
            }
        });

    }
}

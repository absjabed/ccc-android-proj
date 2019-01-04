package com.parvez_n_jabed_co.ccc_project.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.parvez_n_jabed_co.ccc_project.R;

public class TenderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tender);


        GridView gridview = (GridView) findViewById(R.id.gridviewtender);


        gridview.setAdapter(new tenderAdapter(

                new TenderItem("সি/ক টেন্ডার সমূহের ওয়েবলিংক"),//http://www.ccc.org.bd/tender
                new TenderItem("06-04-2017"),
                new TenderItem("27-03-2017"),
                new TenderItem("22-03-2017"),
                new TenderItem("03-04-2017"),

                new TenderItem("16-02-2017"),
                new TenderItem("30-12-2016"),
                new TenderItem("24-11-2016"),
                new TenderItem("21-08-2016"),
                new TenderItem("18-07-2016"),
                new TenderItem("30-06-2016"),

                new TenderItem("16-06-2016"),
                new TenderItem("16-06-2016")
        ));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position==0)
                {
                    Intent webviewIntent = new Intent(TenderActivity.this,WebViewActivity.class);
                    webviewIntent.putExtra("URL","http://www.ccc.org.bd/tender");
                    startActivity(webviewIntent);
                }else if(position==1)
                {
                    Intent webviewIntent = new Intent(TenderActivity.this,WebViewActivity.class);
                    webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/Tender%2006-04-2017_0.pdf");
                    webviewIntent.putExtra("visible",1);
                    startActivity(webviewIntent);
                }
                else  if(position==2)
                {
                    Intent webviewIntent = new Intent(TenderActivity.this,WebViewActivity.class);
                    webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/27-03-2017.pdf");
                    webviewIntent.putExtra("visible",1);
                    startActivity(webviewIntent);
                }
                else  if(position==3)
                {
                    Intent webviewIntent = new Intent(TenderActivity.this,WebViewActivity.class);
                    webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/22-03-2017.pdf");
                    webviewIntent.putExtra("visible",1);
                    startActivity(webviewIntent);
                }

                else  if(position==4)
                {
                    Intent webviewIntent = new Intent(TenderActivity.this,WebViewActivity.class);
                    webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/03-04-2017%20%282%29.pdf");
                    webviewIntent.putExtra("visible",1);
                    startActivity(webviewIntent);
                }

                else  if(position==5)
                {
                    Intent webviewIntent = new Intent(TenderActivity.this,WebViewActivity.class);
                    webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/03-04-2017.pdf");
                    webviewIntent.putExtra("visible",1);
                    startActivity(webviewIntent);
                }

                else  if(position==6)
                {
                    Intent webviewIntent = new Intent(TenderActivity.this,WebViewActivity.class);
                    webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/Tender%20Notice%2016-02-2017.pdf");
                    webviewIntent.putExtra("visible",1);
                    startActivity(webviewIntent);
                }

                else  if(position==7)
                {
                    Intent webviewIntent = new Intent(TenderActivity.this,WebViewActivity.class);
                    webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/Tender%20Notice%2030-12-2016.pdf");
                    webviewIntent.putExtra("visible",1);
                    startActivity(webviewIntent);
                }

                else  if(position==8)
                {
                    Intent webviewIntent = new Intent(TenderActivity.this,WebViewActivity.class);
                    webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/Tender%20Notice%2024-11-2016.pdf");
                    webviewIntent.putExtra("visible",1);
                    startActivity(webviewIntent);
                }

                else  if(position==9)
                {
                    Intent webviewIntent = new Intent(TenderActivity.this,WebViewActivity.class);
                    webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/Tender%20Notice%2021-08-2016.pdf");
                    webviewIntent.putExtra("visible",1);
                    startActivity(webviewIntent);
                }

                else  if(position==10)
                {
                    Intent webviewIntent = new Intent(TenderActivity.this,WebViewActivity.class);
                    webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/Tender%20Notice%2018-07-2016.pdf");
                    webviewIntent.putExtra("visible",1);
                    startActivity(webviewIntent);
                }

                else  if(position==11)
                {
                    Intent webviewIntent = new Intent(TenderActivity.this,WebViewActivity.class);
                    webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/Tender%20Notice%2030-06-2016.pdf");
                    webviewIntent.putExtra("visible",1);
                    startActivity(webviewIntent);
                }

                else  if(position==12)
                {
                    Intent webviewIntent = new Intent(TenderActivity.this,WebViewActivity.class);
                    webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/Tender%20Notice%2016-06-2016.pdf");
                    webviewIntent.putExtra("visible",1);
                    startActivity(webviewIntent);
                }



            }
        });

    }
}

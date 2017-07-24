package com.parvez_n_jabed_co.ccc_project;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class WebViewActivity extends AppCompatActivity {
    private WebView wv1;
    ProgressDialog prDialog;
    String URL;
    int downloadBtnNeed;
    Button downloadBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        downloadBtn = (Button) findViewById(R.id.downloadBtn);

            URL = getIntent().getStringExtra("URL");
            downloadBtnNeed = getIntent().getIntExtra("visible",0);
                if(downloadBtnNeed == 1){
                    downloadBtn.setVisibility(View.VISIBLE);
                }

        init();
        listener();
        //wv1 = (WebView) findViewById(R.id.webView);
        //wv1.setWebViewClient(new MyBrowser());

        //wv1.getSettings().setLoadsImagesAutomatically(true);
        //wv1.getSettings().setJavaScriptEnabled(true);
        //wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        //wv1.loadUrl(url);
    }

    private void init() {
        wv1 = (WebView) findViewById(R.id.webView);
        wv1.getSettings().setJavaScriptEnabled(true);

        prDialog = new ProgressDialog(WebViewActivity.this);
        prDialog.setTitle("একটু অপেক্ষা করুন");
        prDialog.setMessage("পেজ লোড হচ্ছে....");
        prDialog.setIndeterminate(false);
        prDialog.setCancelable(false);
        wv1.loadUrl(URL);
//https://drive.google.com/file/d/0B534aayZ5j7Yc3RhcnRlcl9maWxl/view
    }

    private void listener() {
        wv1.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                prDialog.show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                prDialog.dismiss();
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.allmenu, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_info) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    public void onDownloadButtonClicked(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
        String title = "অন্য অ্যাপ্লিকেশন দিয়ে লিংকটি ওপেন করুন";
        Intent chooser = Intent.createChooser(intent, title);
        startActivity(chooser);
    }

    public void onClickLoadAnotherBtn(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
        String title = "অন্য অ্যাপ্লিকেশন দিয়ে লিংকটি ওপেন করুন";
        Intent chooser = Intent.createChooser(intent, title);
        startActivity(chooser);
    }

//    private class MyBrowser extends WebViewClient {
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            view.loadUrl(url);
//            return true;
//        }
//
//        @Override
//        public void onPageStarted(WebView view, String url, Bitmap favicon) {
//            super.onPageStarted(view, url, favicon);
//            prDialog = new ProgressDialog(WebViewActivity.this);
//            prDialog.setMessage("Please wait ...");
//            prDialog.show();
//        }
//
//        @Override
//        public void onPageFinished(WebView view, String url) {
//            super.onPageFinished(view, url);
//            if (prDialog != null) {
//                prDialog.dismiss();
//            }
//        }
//    }
}

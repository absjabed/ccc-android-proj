package com.parvez_n_jabed_co.ccc_project.TaxRelatedActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.parvez_n_jabed_co.ccc_project.MainActivity;
import com.parvez_n_jabed_co.ccc_project.R;

public class ReCheckTaxActivity1 extends AppCompatActivity {
    Button submitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_check_tax1);
        submitBtn = (Button) findViewById(R.id.reCheckSubmitBtn);
    }

    public void reCheckSubmit(View view) {
        Toast.makeText(this, "ধন্যবাদ, আমরা শীঘ্রই আপনার সাথে যোগাযোগ করব।", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ReCheckTaxActivity1.this, MainActivity.class);
        startActivity(intent);
    }
}

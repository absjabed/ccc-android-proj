package com.parvez_n_jabed_co.ccc_project.Activities.TaxRelatedActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.parvez_n_jabed_co.ccc_project.Activities.MainActivity;
import com.parvez_n_jabed_co.ccc_project.R;

public class HoldingTaxPaymentFinal extends AppCompatActivity {
Button gotoLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holding_tax_payment_final);

        gotoLink = (Button) findViewById(R.id.btnLink);
    }

    public void getReceipt(View view) {
        Toast.makeText(this, "আপনার ট্যাক্স প্রদান সম্পন্ন হয়েছে।", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(HoldingTaxPaymentFinal.this, MainActivity.class);
        startActivity(intent);
    }
}

package com.parvez_n_jabed_co.ccc_project.Activities.TaxRelatedActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.parvez_n_jabed_co.ccc_project.R;

public class HoldingTaxPayment1 extends AppCompatActivity {
    Button nextBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holding_tax_payment1);
        nextBtn = (Button) findViewById(R.id.holdingTaxNextBtn);
    }


    public void gotoHoldingTax2(View view) {
        Intent intent = new Intent(HoldingTaxPayment1.this, HoldingTaxPayment2.class);
        startActivity(intent);
    }
}

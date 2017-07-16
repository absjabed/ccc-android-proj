package com.parvez_n_jabed_co.ccc_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class Complain_Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText complainedit, emailPhone;
    Button submitbtn;
    String longi, latti;
    ImageButton locationbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain_);
        Spinner spnrcomplaintype = (Spinner) findViewById(R.id.complaintype);
        complainedit = (EditText) findViewById(R.id.complainedit);
        emailPhone = (EditText) findViewById(R.id.ETEmailPhone);

 //       submitbtn =(Button) findViewById(R.id.submitcomplain);
        locationbtn =(ImageButton) findViewById(R.id.complainlocation);

//        submitbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Your complain is submitted. Thank You" ,
//                        Toast.LENGTH_SHORT).show();
//            }
//        });
        locationbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "আপনার অভিযোগের লোকেশন সংযুক্ত করা হল।\nএই ফিচারটি আপাতত পরীক্ষা মূলক," ,
                        Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.complain_types,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnrcomplaintype.setAdapter(adapter);
        spnrcomplaintype.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(position==0)
        {
            complainedit.setText("স্থানীয় রাস্তা মেরামত করা প্রয়োজন , রাস্তাটির সঠিক অবস্থান কোন ওয়ার্ডে এর নাম ও ওয়ার্ড নাম্বার যুক্ত করুন।");

        }

        else if(position==1)
        {
            complainedit.setText("স্থানীয় এলাকার ময়লা-আবর্জনা সম্পর্কিত অভিযোগ। ওয়ার্ডে এর নাম ও ওয়ার্ড নাম্বার যুক্ত করুন।");

        }

        else if(position==2)
        {
            complainedit.setText("স্থানীয় এলাকার রোড লাইট/যেকোন লাইট সম্পর্কিত অভিযোগ। ওয়ার্ডে এর নাম ও ওয়ার্ড নাম্বার যুক্ত করুন।");

        }

        else if(position==3)
        {
            complainedit.setText("স্থানীয় এলাকার নালা-নর্দমা সম্পর্কিত অভিযোগ। ওয়ার্ডে এর নাম ও ওয়ার্ড নাম্বার যুক্ত করুন।");

        }

        else if(position==4)
        {
            complainedit.setText("যেকোন দুর্নীতি সম্পর্কিত অভিযোগ। ওয়ার্ডে এর নাম ও ওয়ার্ড নাম্বার যুক্ত করুন।");

        }

        else if(position==5)
        {
            complainedit.setText("অসাধুপায় অবলম্বন/অবৈধ কার্যক্রম সম্পর্কিত অভিযোগ। ওয়ার্ডে এর নাম ও ওয়ার্ড নাম্বার যুক্ত করুন।");

        }

        else if(position==6)
        {
            complainedit.setText("আপনার নিজের যেকোন অভিযোগ। ওয়ার্ডে এর নাম ও ওয়ার্ড নাম্বার যুক্ত করুন।");

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void onClickComplainSubmit(View view) {

        if (complainedit.getText().toString() == null | complainedit.getText().toString().isEmpty() |
                emailPhone.getText().toString() == null| emailPhone.getText().toString().isEmpty()){
            Toast.makeText(this, "প্রয়োজনীয় সকল তথ্য অবশ্যই প্রদান করতে হবে", Toast.LENGTH_SHORT).show();


        }else{
            String strEmailPhone, description;

            strEmailPhone = emailPhone.getText().toString().trim();
            description = complainedit.getText().toString().trim();

            try {
                submitToServer(strEmailPhone, description);
                Toast.makeText(this, "ধন্যবাদ আপনার অংশগ্রহণের জন্য\nআপনাকে দ্রুত এই ব্যাপারে আপডেট জানানো হবে।", Toast.LENGTH_SHORT).show();
            }catch (Exception ex){
                Toast.makeText(this, "সার্ভারে তথ্য পাঠানো যায়নি: "+ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void submitToServer(String strEmailPhone, String description) throws JSONException {

        final String sdescription = description;
        final String semailphone = strEmailPhone;

        //clearing UI components........

        emailPhone.setText(null);
        complainedit.setText(null);

        // Toast.makeText(this, ctype+" "+name+" "+email+" "+description+" "+phone, Toast.LENGTH_SHORT).show();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constant_Var.COMPLAIN_URL,// Complain URL
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Complain_Activity.this,response,Toast.LENGTH_LONG).show();
//                                AlertClass alert = new AlertClass(ComplainActivity.this,2500, AlertType.SUCCESS_ALERT,layout);
//                                alert.showAlert();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Complain_Activity.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){

                        /*public static final String KEY_NAME = "user_name";
    public static final String KEY_ADDRESS = "user_address";
    public static final String KEY_DESCRIPTION = "user_description";
    public static final String KEY_PHONE_EMAIL = "user_phone_email";*/

                Map<String,String> params = new HashMap<String, String>();
                params.put(Constant_Var.KEY_COMPLAIN_DESCRIPTION,sdescription);
                params.put(Constant_Var.KEY_COMPLAIN_PHONE_EMAIL,semailphone);
                Log.d("testComplain",params.get(Constant_Var.KEY_COMPLAIN_DESCRIPTION)+" "+params.get(Constant_Var.KEY_COMPLAIN_PHONE_EMAIL));
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }


}

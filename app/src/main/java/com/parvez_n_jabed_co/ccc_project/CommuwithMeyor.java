package com.parvez_n_jabed_co.ccc_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.beardedhen.androidbootstrap.BootstrapEditText;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class CommuwithMeyor extends AppCompatActivity {

    BootstrapEditText ETname, ETaddress, ETphone, ETdescription;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commuwith_meyor);
        ETname = (BootstrapEditText) findViewById(R.id.ETname);
        ETaddress = (BootstrapEditText) findViewById(R.id.ETaddress);
        ETphone = (BootstrapEditText) findViewById(R.id.ETphone);
        ETdescription = (BootstrapEditText) findViewById(R.id.ETdescription);
    }

    public void onClickSubmitForm(View view) throws JSONException {

        if (ETname.getText().toString() == null | ETname.getText().toString().isEmpty() |
                ETdescription.getText().toString() == null| ETdescription.getText().toString().isEmpty()|
                ETphone.getText().toString() == null|ETphone.getText().toString().isEmpty()|
                ETaddress.getText().toString() == null|ETaddress.getText().toString().isEmpty()){
            Toast.makeText(this, "প্রয়োজনীয় সকল তথ্য অবশ্যই প্রদান করতে হবে", Toast.LENGTH_SHORT).show();


        }else{
            String name, address, phone, description;

            name = ETname.getText().toString().trim();
            address = ETaddress.getText().toString().trim();
            phone = ETphone.getText().toString().trim();
            description = ETdescription.getText().toString().trim();

            try {
                submitToServer(name, address, phone, description);
                Toast.makeText(this, "আমরা আপনার অনুরোধ যাচাই করে আপনার সাথে শীঘ্রই যোগাযোগ করবো", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CommuwithMeyor.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                CommuwithMeyor.this.finish();
            }catch (Exception ex){
                Toast.makeText(this, "সার্ভারে তথ্য পাঠানো যায়নি: "+ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void submitToServer(String name, String address, String description, String phone) throws JSONException {

                final String sname = name;
                final String saddress = address;
                final String sdescription = description;
                final String sphone = phone;

                //clearing UI components........

                ETname.setText(null);
                ETaddress.setText(null);
                ETdescription.setText(null);
                ETphone.setText(null);

               // Toast.makeText(this, ctype+" "+name+" "+email+" "+description+" "+phone, Toast.LENGTH_SHORT).show();


                StringRequest stringRequest = new StringRequest(Request.Method.POST, Constant_Var.MEET_MAYOR_URL,// Complain URL
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                               Toast.makeText(CommuwithMeyor.this,response,Toast.LENGTH_LONG).show();
//                                AlertClass alert = new AlertClass(ComplainActivity.this,2500, AlertType.SUCCESS_ALERT,layout);
//                                alert.showAlert();

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(CommuwithMeyor.this,error.toString(),Toast.LENGTH_LONG).show();
                            }
                        }){
                    @Override
                    protected Map<String,String> getParams(){

                        /*public static final String KEY_NAME = "user_name";
    public static final String KEY_ADDRESS = "user_address";
    public static final String KEY_DESCRIPTION = "user_description";
    public static final String KEY_PHONE_EMAIL = "user_phone_email";*/

                        Map<String,String> params = new HashMap<String, String>();
                        params.put(Constant_Var.KEY_NAME,sname);
                        params.put(Constant_Var.KEY_ADDRESS,saddress);
                        params.put(Constant_Var.KEY_DESCRIPTION,sdescription);
                        params.put(Constant_Var.KEY_PHONE_EMAIL,sphone);
                        Log.d("testMayor",params.get(Constant_Var.KEY_NAME)+" "+ params.get(Constant_Var.KEY_ADDRESS)+" "+params.get(Constant_Var.KEY_DESCRIPTION)+" "+params.get(Constant_Var.KEY_PHONE_EMAIL));
                        return params;
                    }

                };

                RequestQueue requestQueue = Volley.newRequestQueue(this);
                requestQueue.add(stringRequest);


        }
    }


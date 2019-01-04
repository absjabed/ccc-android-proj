package com.parvez_n_jabed_co.ccc_project.Activities;


        import android.content.Intent;
        import android.content.pm.ActivityInfo;
        import android.content.res.TypedArray;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ListView;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.parvez_n_jabed_co.ccc_project.Adapters.Constant_Var;
        import com.parvez_n_jabed_co.ccc_project.Adapters.GroupListAllfuctions;
        import com.parvez_n_jabed_co.ccc_project.R;
        import com.parvez_n_jabed_co.ccc_project.Adapters.RestaurantAdapter;
        import com.parvez_n_jabed_co.ccc_project.Adapters.RowItem;

        import java.util.ArrayList;
        import java.util.List;

public class GroupListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    String[] hospital_names= new String[200];
    TypedArray hospital_pics;
    TextView activity_title;
    String[] hospital_email;
    String[] hospital_mobile;
    int activity;
    List<RowItem> rowItems;
    ListView mylistview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_group_list_view);

        rowItems = new ArrayList<RowItem>();


        Bundle bundle = getIntent().getExtras();
        int image_res_address = bundle.getInt("RES_IMAGE");
        int name_res_address  = bundle.getInt("RES_NAME");
        int email_res_address  = bundle.getInt("RES_EMAIL");
        int mobile_res_address  = bundle.getInt("RES_MOBILE");
         activity = bundle.getInt("ACTIVITY");
        String activityname = bundle.getString("ACTIVITYNAME");

        activity_title = (TextView) findViewById(R.id.activityTitle);
        activity_title.setText(activityname);



        hospital_names = getResources().getStringArray(name_res_address);
        hospital_pics = getResources().obtainTypedArray(image_res_address);
        hospital_email = getResources().getStringArray(email_res_address);
        hospital_mobile = getResources().getStringArray(mobile_res_address);
        for (int i = 0; i < hospital_names.length; i++) {

            RowItem item = new RowItem(hospital_names[i], hospital_pics.getResourceId(i,0), hospital_email[i], hospital_mobile[i]);
            rowItems.add(i,item);
        }



        mylistview = (ListView) findViewById(R.id.res_listview);
        RestaurantAdapter adapter = new RestaurantAdapter(this, rowItems);
        mylistview.setAdapter(adapter);

        mylistview.setOnItemClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.allmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_info) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        String hospital_name = rowItems.get(position).getHospital_name();
        Toast.makeText(getApplicationContext(), "" + hospital_name,
                Toast.LENGTH_SHORT).show();
        if(activity== Constant_Var.COUNCILLOR_ACTIVITY) {

           Intent intent = GroupListAllfuctions.councillor_list(GroupListViewActivity.this,position);
            if(intent!=null)
            startActivity(intent);

        }
        else if(activity == 3)
        {
            Intent intent = GroupListAllfuctions.reslist(GroupListViewActivity.this,position);
            if(intent!=null)
            startActivity(intent);
        }


    }






}

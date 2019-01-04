package com.parvez_n_jabed_co.ccc_project.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.parvez_n_jabed_co.ccc_project.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class DepartmentViewActivity extends AppCompatActivity {

    int dept_title, image, dept_info;
    String name, contact;
    TextView dept_titleTV, dept_infoTV, head_nameTV, head_contactTV;
    CircleImageView cmv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_view);


        dept_titleTV = (TextView) findViewById(R.id.dept_title);
        dept_infoTV = (TextView) findViewById(R.id.deptInfoTxt);
        head_nameTV = (TextView) findViewById(R.id.dept_head_name);
        head_contactTV = (TextView) findViewById(R.id.dept_head_contact);
        cmv = (CircleImageView) findViewById(R.id.dept_head_image);

        Bundle bundle = getIntent().getExtras();

        if(bundle !=null) {
            dept_title = bundle.getInt("dept_title");
            dept_info = bundle.getInt("dept_info");
            image = bundle.getInt("image");
            name = bundle.getString("name");
            contact = bundle.getString("contact");


            dept_titleTV.setText(dept_title);
            dept_infoTV.setText(dept_info);
            head_nameTV.setText(name);
            head_contactTV.setText(contact);
            cmv.setImageResource(image);
        }




    }
}

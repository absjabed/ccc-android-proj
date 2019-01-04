package com.parvez_n_jabed_co.ccc_project.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.parvez_n_jabed_co.ccc_project.Adapters.CustomList;
import com.parvez_n_jabed_co.ccc_project.R;

public class DepartmentListActivity extends AppCompatActivity {



    ListView list;
    String[] web = {
            "SECRETARIAT - সচিবালয়ের বিভাগ",
            "ENGINEERING - প্রকৌশল",
            "REVENUE - রাজস্ব বিভাগ",
            "EDUCATION - শিক্ষা",
            "HEALTH - স্বাস্থ্য",
            "ACCOUNTS - হিসাব বিভাগ",
            "CONSERVANCY - কনসার্ভেন্সী বিভাগ"
    } ;
    int imageId = R.drawable.ccc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_list);


        CustomList adapter = new
                CustomList(DepartmentListActivity.this, web, imageId);
        list=(ListView)findViewById(R.id.deptlist);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                if(position== 0) //SECRETARIAT //মোহাম্মদ আবুল হোসেন head3 ০১৫৫৬-৫৬১০৯৮
                {
                    Bundle extras = new Bundle();
                    extras.putInt("dept_title", R.string.deptSecretariat1);
                    extras.putInt("image", R.drawable.head2);
                    extras.putString("name", "মোহাম্মদ আবুল হোসেন");
                    extras.putString("contact", "সচিব");
                    extras.putInt("dept_info", R.string.deptSecretariat2);

                    Intent intent = new Intent(DepartmentListActivity.this,DepartmentViewActivity.class);
                    intent.putExtras(extras);

                    startActivity(intent);
                }
                else if(position==1) //ENGINEERING // head4  লেঃ কর্ণেল মহিউদ্দিন আহমেদ  ০১৭৯৪-৪৯৩৪৮৬
                {
                    Bundle extras = new Bundle();
                    extras.putInt("dept_title", R.string.deptEngineering1);
                    extras.putInt("image", R.drawable.head3);
                    extras.putString("name", "লেঃ কর্ণেল মহিউদ্দিন আহমেদ");
                    extras.putString("contact", "প্রধান প্রকৌশলী");
                    extras.putInt("dept_info", R.string.deptEngineering2);

                    Intent intent = new Intent(DepartmentListActivity.this,DepartmentViewActivity.class);
                    intent.putExtras(extras);

                    startActivity(intent);
                }
                else if(position==2) {  //REVENUE // ড. মুহাম্মদ মুসত্মাফিজুর রহমান head5  ০১৫৫৩০০৩০৩৩

                    Bundle extras = new Bundle();
                    extras.putInt("dept_title", R.string.deptRevenue1);
                    extras.putInt("image", R.drawable.head4);
                    extras.putString("name", "ড. মুহাম্মদ মুসতাফিজুর রহমান");
                    extras.putString("contact", "প্রধান রাজস্ব কর্মকর্তা");
                    extras.putInt("dept_info", R.string.deptRevenue2);

                    Intent intent = new Intent(DepartmentListActivity.this,DepartmentViewActivity.class);
                    intent.putExtras(extras);

                    startActivity(intent);
                }
                else if(position==3) { //EDUCATION // বেগম নাজিয়া শিরিন head6  ০১৭১৩-১০২৫৩৫
                    Bundle extras = new Bundle();
                    extras.putInt("dept_title", R.string.deptEducation1);
                    extras.putInt("image", R.drawable.head5);
                    extras.putString("name", "বেগম নাজিয়া শিরিন");
                    extras.putString("contact", "প্রধান শিক্ষা কর্মকর্তা");
                    extras.putInt("dept_info", R.string.deptEducation2);

                    Intent intent = new Intent(DepartmentListActivity.this,DepartmentViewActivity.class);
                    intent.putExtras(extras);

                    startActivity(intent);
                }
                else if(position==4) { //HEALTH //head9 ডাঃ সেলিম আকতার চৌধুরী  ০১৮১৯-৩১৯১৩৭
                    Bundle extras = new Bundle();
                    extras.putInt("dept_title", R.string.deptHealth1);
                    extras.putInt("image", R.drawable.head8);
                    extras.putString("name", "ডাঃ সেলিম আকতার চৌধুরী");
                    extras.putString("contact", "প্রধান স্বাস্থ্য কর্মকর্তা");
                    extras.putInt("dept_info", R.string.deptHealth2);

                    Intent intent = new Intent(DepartmentListActivity.this,DepartmentViewActivity.class);
                    intent.putExtras(extras);

                    startActivity(intent);
                }
                else if(position==5) { //ACCOUNTS // মোহাম্মদ সাইফুদ্দিন head 10  ০১৮১৯-৩৮৫০৪৬
                    Bundle extras = new Bundle();
                    extras.putInt("dept_title", R.string.deptAccounts1);
                    extras.putInt("image", R.drawable.head9);
                    extras.putString("name", "মোহাম্মদ সাইফুদ্দিন");
                    extras.putString("contact", "প্রধান হিসাবরক্ষণ কর্মকর্তা");
                    extras.putInt("dept_info", R.string.deptAccounts2);

                    Intent intent = new Intent(DepartmentListActivity.this,DepartmentViewActivity.class);
                    intent.putExtras(extras);

                    startActivity(intent);
                }
                else if(position==6) { //CONSERVANCY // শেখ শফিকুল মান্নান সিদ্দিকী head11  ০১৭১২-২৫২৬১৫
                    Bundle extras = new Bundle();
                    extras.putInt("dept_title", R.string.deptConservancy1);
                    extras.putInt("image", R.drawable.head10);
                    extras.putString("name", "শেখ শফিকুল মান্নান সিদ্দিকী");
                    extras.putString("contact", "প্রধান পরিচ্ছন্ন কর্মকর্তা");
                    extras.putInt("dept_info", R.string.deptConservancy2);

                    Intent intent = new Intent(DepartmentListActivity.this,DepartmentViewActivity.class);
                    intent.putExtras(extras);

                    startActivity(intent);
                }
            }
        });
    }
}

package com.parvez_n_jabed_co.ccc_project.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.parvez_n_jabed_co.ccc_project.Activities.DepartmentListActivity;
import com.parvez_n_jabed_co.ccc_project.Activities.GroupFixedImgLVActivity;
import com.parvez_n_jabed_co.ccc_project.Activities.GroupListViewActivity;
import com.parvez_n_jabed_co.ccc_project.Activities.HistoricalPlacesActivities.PlacesNameActivity;
import com.parvez_n_jabed_co.ccc_project.Activities.HistoryActivity;
import com.parvez_n_jabed_co.ccc_project.Activities.Mayor_CEOActivity;
import com.parvez_n_jabed_co.ccc_project.Activities.NameIconNewActivity;
import com.parvez_n_jabed_co.ccc_project.Activities.PressPdfListActivity;
import com.parvez_n_jabed_co.ccc_project.Activities.WebViewActivity;
import com.parvez_n_jabed_co.ccc_project.R;

/**
 * Created by PARVEZ on 14-Apr-17.
 */

public class Icon_List_All_Function {


    public  static Intent ccc_list(Context context, int postion)
    {
        Intent intent = new Intent();
        if(postion==0) {
            intent = new Intent(context, Mayor_CEOActivity.class);
        }

        else if(postion==1)
        {

            Bundle bundle = new Bundle();
            bundle.putInt("ACTIVITY",Constant_Var.COUNCILLOR_ACTIVITY);
            bundle.putString("ACTIVITYNAME", Constant_Var.COUNCILOR_ACTIVITY_NAME);
            bundle.putInt("RES_IMAGE", R.array.counsilor_pic);
            bundle.putInt("RES_NAME",R.array.counsilor_name);
            bundle.putInt("RES_EMAIL",R.array.counsilor_ward);
            bundle.putInt("RES_MOBILE",R.array.counsilor_phone);
            Intent intent1 = new Intent(context,GroupListViewActivity.class);
            intent1.putExtras(bundle);
            return  intent1;
        }
        else if(postion==2)
        {

            Bundle bundle = new Bundle();
            bundle.putInt("ACTIVITY",Constant_Var.HEAD_ACTIVITY);
            bundle.putString("ACTIVITYNAME", Constant_Var.OFFICIAL_ACTIVITY_NAME);
            bundle.putInt("RES_IMAGE",R.array.head_pic);
            bundle.putInt("RES_NAME",R.array.head_name);
            bundle.putInt("RES_EMAIL",R.array.head_post_name);
            bundle.putInt("RES_MOBILE",R.array.head_phone_no);
            Intent intent1 = new Intent(context,GroupListViewActivity.class);
            intent1.putExtras(bundle);
            return  intent1;
        }
     /*   else if(postion==3)
        {
            Bundle bundle1 = new Bundle();
            bundle1.putInt("ACTIVITY",Constant_Var.DEPARTMENT_ACTIVITY);
            bundle1.putInt("TYPE_NAME",R.array.department_types);
            bundle1.putInt("TYPE_PIC",R.drawable.officials);
            Intent intent1 = new Intent(context,IconNameList2.class);
            intent1.putExtras(bundle1);
            return  intent1;
        }*/
        else if(postion == 3)
        {
            Intent intent1 = new Intent(context,DepartmentListActivity.class);
            return  intent1;
        }


        else {
            intent = null;
        }
        return  intent;
    }


    public  static Intent edu_list(Context context, int postion)
    {
        Intent intent = new Intent();
        if(postion==0) {

            Bundle bundle = new Bundle();
            bundle.putInt("ACTIVITY",Constant_Var.KINDERGARDEN_ACTIVITY);
            bundle.putString("ACTIVITYNAME", Constant_Var.KINDERGARDEN_ACTIVITY_NAME);
            bundle.putInt("RES_IMAGE",R.drawable.education);
            bundle.putInt("RES_NAME",R.array.kindar_school_name);
            bundle.putInt("RES_EMAIL",R.array.kindar_school_head_name);
            bundle.putInt("RES_MOBILE",R.array.kindar_school_phone);
            Intent intent1 = new Intent(context,GroupFixedImgLVActivity.class);
            intent1.putExtras(bundle);
            return  intent1;
        }
        else if(postion==1)
        {
            Bundle bundle = new Bundle();
            bundle.putInt("ACTIVITY",Constant_Var.BALOK_SCHOOL_ACTIVITY);
            bundle.putString("ACTIVITYNAME", Constant_Var.BOYSSCHOOL_ACTIVITY_NAME);
            bundle.putInt("RES_IMAGE",R.drawable.education);
            bundle.putInt("RES_NAME",R.array.balok_school_name);
            bundle.putInt("RES_EMAIL",R.array.balok_school_head_name);
            bundle.putInt("RES_MOBILE",R.array.balok_school_phone);
            Intent intent1 = new Intent(context,GroupFixedImgLVActivity.class);
            intent1.putExtras(bundle);
            return  intent1;
        }
        else if(postion==2)
        {
            Bundle bundle = new Bundle();
            bundle.putInt("ACTIVITY",Constant_Var.BALIKA_SCHOOL_ACTIVITY);
            bundle.putString("ACTIVITYNAME", Constant_Var.GIRLSSCHOOL_ACTIVITY_NAME);
            bundle.putInt("RES_IMAGE",R.drawable.education);
            bundle.putInt("RES_NAME",R.array.balika_school_name);
            bundle.putInt("RES_EMAIL",R.array.balika_school_head_name);
            bundle.putInt("RES_MOBILE",R.array.balika_school_phone);
            Intent intent1 = new Intent(context,GroupFixedImgLVActivity.class);
            intent1.putExtras(bundle);
            return  intent1;
        }
        else if(postion==3)
        {
            Bundle bundle = new Bundle();
            bundle.putInt("ACTIVITY",Constant_Var.BALOKBALIKA_SCHOOL_ACTIVITY);
            bundle.putString("ACTIVITYNAME", Constant_Var.BOYSGIRLS_ACTIVITY_NAME);
            bundle.putInt("RES_IMAGE",R.drawable.education);
            bundle.putInt("RES_NAME",R.array.balok_balika_school_name);
            bundle.putInt("RES_EMAIL",R.array.balok_balika_school_head_name);
            bundle.putInt("RES_MOBILE",R.array.balok_balika_school_phone);
            Intent intent1 = new Intent(context,GroupFixedImgLVActivity.class);
            intent1.putExtras(bundle);
            return  intent1;
        }
        else if(postion==4)
        {
            Bundle bundle = new Bundle();
            bundle.putInt("ACTIVITY",Constant_Var.COLLEGE_ACTIVITY);
            bundle.putString("ACTIVITYNAME", Constant_Var.COLLAGE_ACTIVITY_NAME);
            bundle.putInt("RES_IMAGE",R.drawable.education);
            bundle.putInt("RES_NAME",R.array.college_name);
            bundle.putInt("RES_EMAIL",R.array.college_head_name);
            bundle.putInt("RES_MOBILE",R.array.college_phone);
            Intent intent1 = new Intent(context,GroupFixedImgLVActivity.class);
            intent1.putExtras(bundle);
            return  intent1;
        }
        else if(postion==5)
        {
            Bundle bundle = new Bundle();
            bundle.putInt("ACTIVITY",Constant_Var.COMPUTER_INS_ACTIVITY);
            bundle.putString("ACTIVITYNAME", "সি/ক কম্পিউটার ইন্সটিটিউশনসমূহ");
            bundle.putInt("RES_IMAGE",R.drawable.education);
            bundle.putInt("RES_NAME",R.array.computer_school_name);
            bundle.putInt("RES_EMAIL",R.array.computer_school_head_name);
            bundle.putInt("RES_MOBILE",R.array.computer_school_phone);
            Intent intent1 = new Intent(context,GroupFixedImgLVActivity.class);
            intent1.putExtras(bundle);
            return  intent1;

        }
        else {
            intent = null;
        }
        return  intent;
    }




    public  static Intent emarg_list(Context context, int postion)
    {
        Intent intent = new Intent();

         if(postion==1)
        {
            Bundle bundle = new Bundle();
            bundle.putInt("ACTIVITY",Constant_Var.HOSPITAL_LIST_ACTIVITY);
            bundle.putString("ACTIVITYNAME", Constant_Var.HOSPITALEMARGENCY_ACTIVITY_NAME);
            bundle.putInt("RES_IMAGE",R.drawable.health);
            bundle.putInt("RES_NAME",R.array.hospital_name);
            bundle.putInt("RES_EMAIL",R.array.hospital_phone);
            bundle.putInt("RES_MOBILE",-1);
            Intent intent1 = new Intent(context,GroupFixedImgLVActivity.class);
            intent1.putExtras(bundle);
            return  intent1;
        }
        else if(postion==2)
        {
            Bundle bundle = new Bundle();
            bundle.putInt("ACTIVITY",Constant_Var.POLICE_ACTIVITY);
            bundle.putString("ACTIVITYNAME", Constant_Var.POLICELIST_ACTIVITY_NAME);
            bundle.putInt("RES_IMAGE",R.drawable.police);
            bundle.putInt("RES_NAME",R.array.police_station_name);
            bundle.putInt("RES_EMAIL",R.array.police_station_phone);
            bundle.putInt("RES_MOBILE",-1);
            Intent intent1 = new Intent(context,GroupFixedImgLVActivity.class);
            intent1.putExtras(bundle);
            return  intent1;
        }
        else if(postion==3)
        {
            Bundle bundle = new Bundle();
            bundle.putInt("ACTIVITY",Constant_Var.RAB_ACTIVITY);
            bundle.putString("ACTIVITYNAME", "RAB");
            bundle.putInt("RES_IMAGE",R.drawable.rab);
            bundle.putInt("RES_NAME",R.array.police_station_name);
            bundle.putInt("RES_EMAIL",R.array.police_station_phone);
            bundle.putInt("RES_MOBILE",-1);
            Intent intent1 = new Intent(context,GroupFixedImgLVActivity.class);
            intent1.putExtras(bundle);
            return  intent1;
        }
        else if(postion==4)
        {
            Bundle bundle = new Bundle();
            bundle.putInt("ACTIVITY",Constant_Var.FIRE_SERVICE_ACTIVITY);
            bundle.putString("ACTIVITYNAME", Constant_Var.FIRESERVICE_ACTIVITY_NAME);
            bundle.putInt("RES_IMAGE",R.drawable.fireservice);
            bundle.putInt("RES_NAME",R.array.fire_station_name);
            bundle.putInt("RES_EMAIL",R.array.fire_station_phone);
            bundle.putInt("RES_MOBILE",-1);
            Intent intent1 = new Intent(context,GroupFixedImgLVActivity.class);
            intent1.putExtras(bundle);
            return  intent1;
        }
        else if(postion==5)
        {
            Bundle bundle = new Bundle();
            bundle.putInt("ACTIVITY",Constant_Var.NEWSPAPER_ACTIVITY);
            bundle.putString("ACTIVITYNAME", Constant_Var.NEWSPAPER_ACTIVITY_NAME);
            bundle.putInt("RES_IMAGE",R.drawable.newspaper);
            bundle.putInt("RES_NAME",R.array.daily_newspaper_name);
            bundle.putInt("RES_EMAIL",R.array.daily_newspaper_phone);
            bundle.putInt("RES_MOBILE",-1);
            Intent intent1 = new Intent(context,GroupFixedImgLVActivity.class);
            intent1.putExtras(bundle);
            return  intent1;

        }

        else if(postion==6)
        {
            Bundle bundle = new Bundle();
            bundle.putInt("ACTIVITY",Constant_Var.WASA_ACTIVITY);
            bundle.putString("ACTIVITYNAME", Constant_Var.WASA_ACTIVITY_NAME);
            bundle.putInt("RES_IMAGE",R.drawable.wasa);
            bundle.putInt("RES_NAME",R.array.chittagong_wasa_administration_name);
            bundle.putInt("RES_EMAIL",R.array.chittagong_wasa_administration_phone);
            bundle.putInt("RES_MOBILE",-1);
            Intent intent1 = new Intent(context,GroupFixedImgLVActivity.class);
            intent1.putExtras(bundle);
            return  intent1;

        }
        else {
            intent = null;
        }
        return  intent;
    }



    public  static Intent health_list(Context context,int postion)
    {
        Intent intent = new Intent();
        if(postion==0) {
            Bundle bundle = new Bundle();
            bundle.putInt("ACTIVITY",Constant_Var.PROSHASON_HOS_ACTIVITY);
            bundle.putString("ACTIVITYNAME","");
            bundle.putInt("RES_IMAGE",R.drawable.health);
            bundle.putInt("RES_NAME",R.array.prosasonik_doc_name);
            bundle.putInt("RES_EMAIL",R.array.prosasonik_doc_post);
            bundle.putInt("RES_MOBILE",R.array.prosasonik_doc_phone);
            Intent intent1 = new Intent(context,GroupFixedImgLVActivity.class);
            intent1.putExtras(bundle);
            return  intent1;
        }
        else if(postion==1)
        {
            Bundle bundle = new Bundle();
            bundle.putInt("ACTIVITY",Constant_Var.MEMON_HOS_ACTIVITY);
            bundle.putString("ACTIVITYNAME", Constant_Var.MATRISODON_ACTIVITY_NAME);
            bundle.putInt("RES_IMAGE",R.drawable.health);
            bundle.putInt("RES_NAME",R.array.memoncc_doc_name);
            bundle.putInt("RES_EMAIL",R.array.memoncc_doc_post);
            bundle.putInt("RES_MOBILE",R.array.memon_doc_phone);
            Intent intent1 = new Intent(context,GroupFixedImgLVActivity.class);
            intent1.putExtras(bundle);
            return  intent1;
        }

        else if(postion==2)
        {

            Bundle bundle = new Bundle();
            bundle.putInt("ACTIVITY",Constant_Var.GENERAL_HOS__ACTIVITY);
            bundle.putString("ACTIVITYNAME", Constant_Var.GENERALHOSPITAL_ACTIVITY_NAME);
            bundle.putInt("RES_IMAGE",R.drawable.health);
            bundle.putInt("RES_NAME",R.array.generalcc_doc_name);
            bundle.putInt("RES_EMAIL",R.array.generalcc_doc_post);
            bundle.putInt("RES_MOBILE",R.array.general_doc_phone);
            Intent intent1 = new Intent(context,GroupFixedImgLVActivity.class);
            intent1.putExtras(bundle);
            return  intent1;
        }

        else if(postion==3)
        {

            Bundle bundle = new Bundle();
            bundle.putInt("ACTIVITY",Constant_Var.MOSTOFA_HOS__ACTIVITY);
            bundle.putString("ACTIVITYNAME", Constant_Var.MOSTOFA_ACTIVITY_NAME);
            bundle.putInt("RES_IMAGE",R.drawable.health);
            bundle.putInt("RES_NAME",R.array.mostofacc_doc_name);
            bundle.putInt("RES_EMAIL",R.array.mostofacc_doc_post);
            bundle.putInt("RES_MOBILE",R.array.mostofa_doc_phone);
            Intent intent1 = new Intent(context,GroupFixedImgLVActivity.class);
            intent1.putExtras(bundle);
            return  intent1;
        }

        else if(postion==4)
        {

            Bundle bundle = new Bundle();
            bundle.putInt("ACTIVITY",Constant_Var.SAFA_HOS__ACTIVITY);
            bundle.putString("ACTIVITYNAME", Constant_Var.SAFA_ACTIVITY_NAME);
            bundle.putInt("RES_IMAGE",R.drawable.health);
            bundle.putInt("RES_NAME",R.array.safacc_doc_name);
            bundle.putInt("RES_EMAIL",R.array.safacc_doc_post);
            bundle.putInt("RES_MOBILE",R.array.safa_doc_phone);
            Intent intent1 = new Intent(context,GroupFixedImgLVActivity.class);
            intent1.putExtras(bundle);
            return  intent1;
        }

        else if(postion==5)
        {

            Bundle bundle = new Bundle();
            bundle.putInt("ACTIVITY",Constant_Var.WARD_HOS__ACTIVITY);
            bundle.putString("ACTIVITYNAME", Constant_Var.WORDCLINIC_ACTIVITY_NAME);
            bundle.putInt("RES_IMAGE",R.drawable.health);
            bundle.putInt("RES_NAME",R.array.wardwise_clinic_name);
            bundle.putInt("RES_EMAIL",R.array.wardwise_clinic_doc_name);
            bundle.putInt("RES_MOBILE",R.array.wardwise_clinic_phone);
            Intent intent1 = new Intent(context,GroupFixedImgLVActivity.class);
            intent1.putExtras(bundle);
            return  intent1;
        }

        else if(postion==6)
        {

            Bundle bundle = new Bundle();
            bundle.putInt("ACTIVITY",Constant_Var.MID_WARY_HOS__ACTIVITY);
            bundle.putString("ACTIVITYNAME","মিডওয়াইফারী ইনিষ্টিটিউট");
            bundle.putInt("RES_IMAGE",R.drawable.health);
            bundle.putInt("RES_NAME",R.array.midwifari_doc_name);
            bundle.putInt("RES_EMAIL",R.array.midwifari_doc_post);
            bundle.putInt("RES_MOBILE",R.array.midwifari_doc_phone);
            Intent intent1 = new Intent(context,GroupFixedImgLVActivity.class);
            intent1.putExtras(bundle);
            return  intent1;
        }


        else if(postion==7)
        {

            Bundle bundle = new Bundle();
            bundle.putInt("ACTIVITY",Constant_Var.IHT_HOS__ACTIVITY);
            bundle.putString("ACTIVITYNAME", Constant_Var.ISTITUTEHEALTH_ACTIVITY_NAME);
            bundle.putInt("RES_IMAGE",R.drawable.health);
            bundle.putInt("RES_NAME",R.array.iht_doc_name);
            bundle.putInt("RES_EMAIL",R.array.iht_doc_post);
            bundle.putInt("RES_MOBILE",R.array.iht_doc_phone);
            Intent intent1 = new Intent(context,GroupFixedImgLVActivity.class);
            intent1.putExtras(bundle);
            return  intent1;
        }


        else {
            intent = null;
        }
        return  intent;
    }

    public  static Intent entertainment_list(Context context,int postion)
    {
        Intent intent = new Intent();
        if(postion==0)
        {
            Bundle bundle1 = new Bundle();
            bundle1.putInt("ACTIVITY",Constant_Var.CINEMA_HALL_ACTIVITY);
            bundle1.putInt("TYPE_NAME",R.array.cinema_hall_name);
            bundle1.putInt("TYPE_ADDRESS",R.array.cinema_hall_address);
            bundle1.putInt("TYPE_OPENDAY",R.array.cinema_hall_phone);
            bundle1.putInt("TYPE_PIC",R.drawable.cinema);
            bundle1.putString("ACTIVITYNAME",Constant_Var.CINEMALIST_ACTIVITY_NAME);
            Intent intent1 = new Intent(context,NameIconNewActivity.class);
            intent1.putExtras(bundle1);
            return  intent1;

//Cinema Hall List
        } else if(postion==1)
        {

            Bundle bundle1 = new Bundle();
            bundle1.putInt("ACTIVITY",Constant_Var.LIBRATY_ACTIVITY);
            bundle1.putInt("TYPE_NAME",R.array.library_name);

            bundle1.putInt("TYPE_ADDRESS",R.array.library_address);
            bundle1.putInt("TYPE_OPENDAY",R.array.library_open_date);

            bundle1.putInt("TYPE_PIC",R.drawable.library);

            bundle1.putString("ACTIVITYNAME",Constant_Var.LIBRARY_ACTIVITY_NAME);
            Intent intent1 = new Intent(context,NameIconNewActivity.class);
            intent1.putExtras(bundle1);
            return  intent1;

            //Library List
        }else if(postion==2){
            intent = new Intent(context,PlacesNameActivity.class);
        }else if(postion==3)
         {

             Bundle bundle1 = new Bundle();
             bundle1.putInt("ACTIVITY",Constant_Var.SHOPPINGMALL_ACTIVITY);
             bundle1.putInt("TYPE_NAME",R.array.shopping_mall_name);

             bundle1.putInt("TYPE_ADDRESS",R.array.shopping_mall_address);
             bundle1.putInt("TYPE_OPENDAY",R.array.shopping_mall_open_date);

             bundle1.putInt("TYPE_PIC",R.drawable.location);
             bundle1.putString("ACTIVITYNAME",Constant_Var.SHOPPING_ACTIVITY_NAME);
             Intent intent1 = new Intent(context,NameIconNewActivity.class);
             intent1.putExtras(bundle1);
             return  intent1;
             //Shopping Mall List
         }else if(postion==4){
        intent = new Intent(context,HistoryActivity.class);
    }


        else {
            intent = null;
        }
        return  intent;
    }
    public  static Intent event_list(Context context,int postion)
    {
        Intent intent = new Intent();
        if(postion==0) {
            Bundle bundle1 = new Bundle();
            bundle1.putInt("ACTIVITY",Constant_Var.FUTUREPLANE_ACTIVITY);
            bundle1.putInt("TYPE_NAME",R.array.future_plan_list);
            bundle1.putString("ACTIVITYNAME",Constant_Var.FUTUREPLANE_ACTIVITY_NAME);
            Intent intent1 = new Intent(context,DefaultListView.class);
            intent1.putExtras(bundle1);
            return  intent1;

         //   intent.putExtra("URL","http://www.ccc.org.bd/events");

        }
        else if(postion==1)
        {
            intent = new Intent(context,PressPdfListActivity.class);
        }


        else {
            intent = null;
        }
        return  intent;
    }
    public  static Intent project_list(Context context,int postion)
    {
        Intent intent = new Intent();
        if(postion==0) {

            Bundle bundle1 = new Bundle();
            bundle1.putInt("ACTIVITY",Constant_Var.ONGOINGPROJECT_ACTIVITY);
            bundle1.putInt("TYPE_NAME",R.array.ongoing_project);
            bundle1.putString("ACTIVITYNAME",Constant_Var.ONGOINGPROJECT_ACTIVITY_NAME);
            Intent intent1 = new Intent(context,DefaultListView.class);
            intent1.putExtras(bundle1);
            return  intent1;
           /* intent = new Intent(context,WebViewActivity.class);
            intent.putExtra("URL","http://www.ccc.org.bd/on_going_projects");*/

        }
        else if(postion==1)
        {
            Bundle bundle1 = new Bundle();
            bundle1.putInt("ACTIVITY",Constant_Var.UPCOMMINGGPROJECT_ACTIVITY);
            bundle1.putInt("TYPE_NAME",R.array.upcoming_project_name);
            bundle1.putString("ACTIVITYNAME",Constant_Var.UPCOMMINGPROJECT_ACTIVITY_NAME);
            Intent intent1 = new Intent(context,DefaultListView.class);
            intent1.putExtras(bundle1);
            return  intent1;
            /*intent = new Intent(context,WebViewActivity.class);
            intent.putExtra("URL","http://www.ccc.org.bd/up_coming_projects");*/
        }

        else if(postion==2)
        {
            intent = new Intent(context,WebViewActivity.class);
            intent.putExtra("URL","http://www.ccc.org.bd/urban_issues");
        }


        else {
            intent = null;
        }
        return  intent;
    }


    public  static Intent tender_list(Context context,int position)
    {
        Intent intent = new Intent();
                 if(position==0)
                {
                    Intent webviewIntent = new Intent(context,WebViewActivity.class);
                    webviewIntent.putExtra("URL","http://www.ccc.org.bd/tender");
                    return (webviewIntent);
                }else if(position==1)
                {
                    Intent webviewIntent = new Intent(context,WebViewActivity.class);
                    webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/Tender%2006-04-2017_0.pdf");
                    webviewIntent.putExtra("visible",1);
                    return (webviewIntent);
                }
                else  if(position==2)
                {
                    Intent webviewIntent = new Intent(context,WebViewActivity.class);
                    webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/27-03-2017.pdf");
                    webviewIntent.putExtra("visible",1);
                    return (webviewIntent);
                }
                else  if(position==3)
                {
                    Intent webviewIntent = new Intent(context,WebViewActivity.class);
                    webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/22-03-2017.pdf");
                    webviewIntent.putExtra("visible",1);
                    return (webviewIntent);
                }

                else  if(position==4)
                {
                    Intent webviewIntent = new Intent(context,WebViewActivity.class);
                    webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/03-04-2017%20%282%29.pdf");
                    webviewIntent.putExtra("visible",1);
                    return (webviewIntent);
                }

                else  if(position==5)
                {
                    Intent webviewIntent = new Intent(context,WebViewActivity.class);
                    webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/03-04-2017.pdf");
                    webviewIntent.putExtra("visible",1);
                    return (webviewIntent);
                }

                else  if(position==6)
                {
                    Intent webviewIntent = new Intent(context,WebViewActivity.class);
                    webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/Tender%20Notice%2016-02-2017.pdf");
                    webviewIntent.putExtra("visible",1);
                    return (webviewIntent);
                }

                else  if(position==7)
                {
                    Intent webviewIntent = new Intent(context,WebViewActivity.class);
                    webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/Tender%20Notice%2030-12-2016.pdf");
                    webviewIntent.putExtra("visible",1);
                    return (webviewIntent);
                }

                else  if(position==8)
                {
                    Intent webviewIntent = new Intent(context,WebViewActivity.class);
                    webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/Tender%20Notice%2024-11-2016.pdf");
                    webviewIntent.putExtra("visible",1);
                    return (webviewIntent);
                }

                else  if(position==9)
                {
                    Intent webviewIntent = new Intent(context,WebViewActivity.class);
                    webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/Tender%20Notice%2021-08-2016.pdf");
                    webviewIntent.putExtra("visible",1);
                    return (webviewIntent);
                }

                else  if(position==10)
                {
                    Intent webviewIntent = new Intent(context,WebViewActivity.class);
                    webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/Tender%20Notice%2018-07-2016.pdf");
                    webviewIntent.putExtra("visible",1);
                    return (webviewIntent);
                }

                else  if(position==11)
                {
                    Intent webviewIntent = new Intent(context,WebViewActivity.class);
                    webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/Tender%20Notice%2030-06-2016.pdf");
                    webviewIntent.putExtra("visible",1);
                    return (webviewIntent);
                }

                else  if(position==12)
                {
                    Intent webviewIntent = new Intent(context,WebViewActivity.class);
                    webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/Tender%20Notice%2016-06-2016.pdf");
                    webviewIntent.putExtra("visible",1);
                    return (webviewIntent);
                }

 /*       if(position==0)
        {
            Intent webviewIntent = new Intent(context,WebViewActivity.class);
            webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/Tender%2006-04-2017_0.pdf");
            return  (webviewIntent);
        }
        else  if(position==1)
        {
            Intent webviewIntent = new Intent(context,WebViewActivity.class);
            webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/27-03-2017.pdf");
            return  (webviewIntent);
        }
        else  if(position==2)
        {
            Intent webviewIntent = new Intent(context,WebViewActivity.class);
            webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/22-03-2017.pdf");
            return  (webviewIntent);
        }

        else  if(position==3)
        {
            Intent webviewIntent = new Intent(context,WebViewActivity.class);
            webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/03-04-2017%20%282%29.pdf");
            return  (webviewIntent);
        }

        else  if(position==4)
        {
            Intent webviewIntent = new Intent(context,WebViewActivity.class);
            webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/03-04-2017.pdf");
            return  (webviewIntent);
        }

        else  if(position==5)
        {
            Intent webviewIntent = new Intent(context,WebViewActivity.class);
            webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/Tender%20Notice%2016-02-2017.pdf");
            return  (webviewIntent);
        }

        else  if(position==6)
        {
            Intent webviewIntent = new Intent(context,WebViewActivity.class);
            webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/Tender%20Notice%2030-12-2016.pdf");
            return  (webviewIntent);
        }

        else  if(position==7)
        {
            Intent webviewIntent = new Intent(context,WebViewActivity.class);
            webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/Tender%20Notice%2024-11-2016.pdf");
            return  (webviewIntent);
        }

        else  if(position==8)
        {
            Intent webviewIntent = new Intent(context,WebViewActivity.class);
            webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/Tender%20Notice%2021-08-2016.pdf");
            return  (webviewIntent);
        }

        else  if(position==9)
        {
            Intent webviewIntent = new Intent(context,WebViewActivity.class);
            webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/Tender%20Notice%2018-07-2016.pdf");
            return  (webviewIntent);
        }

        else  if(position==10)
        {
            Intent webviewIntent = new Intent(context,WebViewActivity.class);
            webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/Tender%20Notice%2030-06-2016.pdf");
            return  (webviewIntent);
        }

        else  if(position==11)
        {
            Intent webviewIntent = new Intent(context,WebViewActivity.class);
            webviewIntent.putExtra("URL","http://www.ccc.org.bd/sites/default/files/tenders/Tender%20Notice%2016-06-2016.pdf");
            return  (webviewIntent);
        }*/


        else {
            intent = null;
        }
        return  intent;
    }
}

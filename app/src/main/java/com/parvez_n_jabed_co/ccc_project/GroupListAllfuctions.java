package com.parvez_n_jabed_co.ccc_project;

import android.content.Context;
import android.content.Intent;

/**
 * Created by PARVEZ on 10-Apr-17.
 */

public  class GroupListAllfuctions {

    public  static Intent councillor_list(Context context,int postion)
    {
        Intent intent = new Intent();
        if(postion==5) {
             intent = new Intent(context, WebViewActivity.class);
        }
        else if(postion==0)
        {
             intent = new Intent(context, WebViewActivity.class);
        }
        else {
            intent = null;
        }
        return  intent;
    }

    public  static Intent reslist(Context context,int postion)
    {
        Intent intent = new Intent();
        if(postion==3) {
            intent = new Intent(context, MainActivity.class);
        }
        else if(postion==2)
        {
            intent = new Intent(context, WebViewActivity.class);
        }

        else {
            intent = null;
        }
        return  intent;
    }


}

package com.parvez_n_jabed_co.ccc_project.FirebaseIntregations;

import android.app.Application;

import com.firebase.client.Firebase;


/**
 * Created by abs pc1 on 2017-09-26.
 */

public class FireApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}

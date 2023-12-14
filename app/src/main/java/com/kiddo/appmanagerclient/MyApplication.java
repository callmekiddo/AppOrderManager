package com.kiddo.appmanagerclient;

import android.app.Application;

import com.kiddo.appmanagerclient.datastore.TokenStore;

public class MyApplication extends Application {
    private static MyApplication application;

    public static MyApplication App(){
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

}

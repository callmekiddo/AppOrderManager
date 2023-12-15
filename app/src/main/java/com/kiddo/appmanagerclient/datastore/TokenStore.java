package com.kiddo.appmanagerclient.datastore;

import android.content.Context;
import android.content.SharedPreferences;

import com.kiddo.appmanagerclient.MyApplication;

public class TokenStore{
    private SharedPreferences sharedPreferences;
    public TokenStore(){
        sharedPreferences = MyApplication.App().getSharedPreferences("SHARE_PREFERENCES",Context.MODE_PRIVATE);
    }
    public void saveToken(String token){
        sharedPreferences.edit().putString("TOKEN",token).apply();
    }

    public String getToken(){
        return sharedPreferences.getString("TOKEN","");
    }
}

package com.kiddo.appmanagerclient.retrofit;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private Retrofit.Builder retrofit;

    public RetrofitService(){
        initializerRetrofit();
    }

    private void initializerRetrofit(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://marmot-sacred-normally.ngrok-free.app")
                .addConverterFactory(GsonConverterFactory.create(new Gson()));
    }

    public Retrofit.Builder getRetrofit(){
        return retrofit;
    }

}

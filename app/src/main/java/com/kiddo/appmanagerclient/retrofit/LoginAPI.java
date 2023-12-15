package com.kiddo.appmanagerclient.retrofit;

import com.kiddo.appmanagerclient.model.Account;
import com.kiddo.appmanagerclient.model.AuthReponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginAPI {

    @POST("/api/manager/login")
    Call<AuthReponse> loginQL(@Body Account account);


    @POST("/api/shipper/login")
    Call<AuthReponse> loginNV(@Body Account account);
}

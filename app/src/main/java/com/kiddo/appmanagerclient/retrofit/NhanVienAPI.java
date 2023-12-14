package com.kiddo.appmanagerclient.retrofit;

import com.kiddo.appmanagerclient.model.Account;
import com.kiddo.appmanagerclient.model.AuthReponse;
import com.kiddo.appmanagerclient.model.DonHang;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface NhanVienAPI {

    @POST("/api//login")
    Call<AuthReponse> login(@Body Account account);

    @GET("/api/order")
    Call<List<DonHang>> getDH(@Body String token);
}

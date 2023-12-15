package com.kiddo.appmanagerclient.retrofit;


import com.kiddo.appmanagerclient.model.DonHang;
import com.kiddo.appmanagerclient.model.KhachHang;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface QuanLyAPI {


    @GET("/api/order")
    Call<List<DonHang>> getDH();

    @GET("/api/user")
    Call<KhachHang> getKH(@Body String token);
}

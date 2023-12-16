package com.kiddo.appmanagerclient.retrofit;

import com.kiddo.appmanagerclient.model.DonHang;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface NhanVienAPI {

    @GET("/api/shipper/order")
    Call<List<DonHang>> getDH();

    @GET("/api/order/{id}")
    Call<DonHang> getDHByID(@Path("id") Long id);
}

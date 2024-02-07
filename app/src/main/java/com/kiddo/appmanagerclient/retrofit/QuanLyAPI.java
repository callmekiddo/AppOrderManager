package com.kiddo.appmanagerclient.retrofit;


import com.kiddo.appmanagerclient.model.DonHang;
import com.kiddo.appmanagerclient.model.NhanVien;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface QuanLyAPI {


    @GET("/api/manager/order")
    Call<List<DonHang>> getDHQL();

    @GET("/api/manager/shipper")
    Call<List<NhanVien>> getNV();

    @GET("/api/manager/order/{id}")
    Call<DonHang> getDHByID(@Path("id") Long id);

    @POST("/api/manager/order/{id}")
    @FormUrlEncoded
    Call<Long> sendToShipper(@Path("id") Long id, @Field("id") Long shipperId);
}

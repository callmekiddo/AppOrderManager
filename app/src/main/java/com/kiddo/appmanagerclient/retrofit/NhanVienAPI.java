package com.kiddo.appmanagerclient.retrofit;

import com.kiddo.appmanagerclient.model.DonHang;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface NhanVienAPI {

    @GET("/api/shipper/order")
    Call<List<DonHang>> getDHNV();

    @GET("/api/order/{id}")
    Call<DonHang> getDHByID(@Path("id") Long id);

    @POST("/api/shipper/order/{id}")
    @FormUrlEncoded
    Call<Map<Long, String>> isComplete(@Path("id") Long id, @Field("isSucceed") Boolean isSucceed);
}

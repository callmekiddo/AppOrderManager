package com.kiddo.appmanagerclient.retrofit;

import com.kiddo.appmanagerclient.model.DonHang;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface NhanVienAPI {

    @GET("/api/order")
    Call<List<DonHang>> getDH(@Body String token);
}

package com.kiddo.appmanagerclient.nhanvien;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.kiddo.appmanagerclient.R;
import com.kiddo.appmanagerclient.model.DonHang;
import com.kiddo.appmanagerclient.nhanvien.view.ViewDHAdapter_nv;
import com.kiddo.appmanagerclient.retrofit.NhanVienAPI;
import com.kiddo.appmanagerclient.retrofit.QuanLyAPI;
import com.kiddo.appmanagerclient.retrofit.RetrofitService;
import com.kiddo.appmanagerclient.retrofit.TokenInterceptor;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeNV extends AppCompatActivity {

    private RecyclerView recyclerView;

    private String token = "";

    private List<DonHang> listDH;

    RetrofitService retrofitService = new RetrofitService();
    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new TokenInterceptor()).build();
    NhanVienAPI nhanVienAPI = retrofitService.getRetrofit().client(client).build().create(NhanVienAPI.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_nv);

        listDH = new ArrayList<>();
        getListDH();

    }

    private void getListDH(){
        nhanVienAPI.getDH(token)
                .enqueue(new Callback<List<DonHang>>() {
                    @Override
                    public void onResponse(Call<List<DonHang>> call, Response<List<DonHang>> response) {
                        listView(response.body());

                    }

                    @Override
                    public void onFailure(Call<List<DonHang>> call, Throwable t) {

                    }
                });
    }

    private void listView(List<DonHang> listDH){
        ViewDHAdapter_nv viewDHAdapterNv= new ViewDHAdapter_nv(listDH);
        recyclerView.setAdapter(viewDHAdapterNv);
    }
}

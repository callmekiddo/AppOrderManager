package com.kiddo.appmanagerclient.quanly;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kiddo.appmanagerclient.R;
import com.kiddo.appmanagerclient.model.AuthReponse;
import com.kiddo.appmanagerclient.model.DonHang;
import com.kiddo.appmanagerclient.nhanvien.view.ViewDHAdapter_nv;
import com.kiddo.appmanagerclient.quanly.view.ViewDHAdapter_ql;
import com.kiddo.appmanagerclient.retrofit.QuanLyAPI;
import com.kiddo.appmanagerclient.retrofit.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeQL extends AppCompatActivity {

    private RecyclerView recyclerView;

    private String token = "";

    private List<DonHang> listDH;

    RetrofitService retrofitService = new RetrofitService();
    QuanLyAPI quanLyAPI = retrofitService.getRetrofit().create(QuanLyAPI.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_ql);

        token = getIntent().getStringExtra("token");

        listDH = new ArrayList<>();
        getListDH();

    }

    private void getListDH(){
        quanLyAPI.getDH(token)
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
        ViewDHAdapter_ql viewDHAdapterQl = new ViewDHAdapter_ql(listDH);
        recyclerView.setAdapter(viewDHAdapterQl);
    }
}

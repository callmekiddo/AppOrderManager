package com.kiddo.appmanagerclient.quanly;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kiddo.appmanagerclient.R;
import com.kiddo.appmanagerclient.datastore.TokenStore;
import com.kiddo.appmanagerclient.model.AuthReponse;
import com.kiddo.appmanagerclient.model.DonHang;
import com.kiddo.appmanagerclient.model.DonHang_MonAn;
import com.kiddo.appmanagerclient.nhanvien.view.ViewDHAdapter_nv;
import com.kiddo.appmanagerclient.quanly.view.OnItemClickListener;
import com.kiddo.appmanagerclient.quanly.view.ViewDHAdapter_ql;
import com.kiddo.appmanagerclient.retrofit.LoginAPI;
import com.kiddo.appmanagerclient.retrofit.QuanLyAPI;
import com.kiddo.appmanagerclient.retrofit.RetrofitService;
import com.kiddo.appmanagerclient.retrofit.TokenInterceptor;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeQL extends AppCompatActivity {

    private RecyclerView recyclerView;

    private String token = "";

    private List<DonHang> listDH;

    private String status = "";

    private DonHang donHang;

    RetrofitService retrofitService = new RetrofitService();
    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new TokenInterceptor()).build();
    QuanLyAPI quanLyAPI = retrofitService.getRetrofit().client(client).build().create(QuanLyAPI.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_ql);

        recyclerView = findViewById(R.id.view_dh_ql);

        listDH = new ArrayList<>();
        getListDH();


    }


    private void getListDH(){
        quanLyAPI.getDH()
                .enqueue(new Callback<List<DonHang>>() {
                    @Override
                    public void onResponse(Call<List<DonHang>> call, Response<List<DonHang>> response) {
                        if(response.body() == null){
                            return;
                        }else {
                            listView(response.body());

                        }
                    }

                    @Override
                    public void onFailure(Call<List<DonHang>> call, Throwable t) {

                    }
                });
    }

    private void listView(List<DonHang> listDH){
        ViewDHAdapter_ql viewDHAdapterQl = new ViewDHAdapter_ql(listDH, new OnItemClickListener() {
            @Override
            public void onClick(Long id) {
                Intent intent = new Intent(HomeQL.this, ThongTinDonHang_ql.class);
                intent.putExtra("ID", id);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(viewDHAdapterQl);
    }
}

package com.kiddo.appmanagerclient.nhanvien;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.kiddo.appmanagerclient.R;
import com.kiddo.appmanagerclient.model.DonHang;
import com.kiddo.appmanagerclient.nhanvien.view.ViewDHAdapter_nv;
import com.kiddo.appmanagerclient.OnItemClickListener;
import com.kiddo.appmanagerclient.retrofit.NhanVienAPI;
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

    private final String token = "";

    private List<DonHang> listDH;

    private final String status = "DELIVERING";

    RetrofitService retrofitService = new RetrofitService();
    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new TokenInterceptor()).build();
    NhanVienAPI nhanVienAPI = retrofitService.getRetrofit().client(client).build().create(NhanVienAPI.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_nv);

        recyclerView = findViewById(R.id.view_dh_nv);

        listDH = new ArrayList<>();
        getListDH();

    }

    private void getListDH(){
        nhanVienAPI.getDHNV()
                .enqueue(new Callback<List<DonHang>>() {
                    @Override
                    public void onResponse(Call<List<DonHang>> call, Response<List<DonHang>> response) {
                        if(response.body() == null){
                        }else {
                            List<DonHang> filterList = filterByStatus(response.body(), status);
                            listView(filterList);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<DonHang>> call, Throwable t) {

                    }
                });
    }

    private List<DonHang> filterByStatus(List<DonHang> list, String status){
        List<DonHang> filterList = new ArrayList<>();
        for(DonHang dh : list){
            if(dh.getStatus().equals(status)){
                filterList.add(dh);
            }
        }
        return filterList;
    }

    private void listView(List<DonHang> listDH){
        ViewDHAdapter_nv viewDHAdapterNv = new ViewDHAdapter_nv(listDH, new OnItemClickListener() {
            @Override
            public void onClick(Long id) {
                Intent intent = new Intent(HomeNV.this, ThongTinDonHang_nv.class);
                intent.putExtra("ID", id);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(viewDHAdapterNv);
    }
}

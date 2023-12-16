package com.kiddo.appmanagerclient.quanly;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.kiddo.appmanagerclient.R;
import com.kiddo.appmanagerclient.donhang_monan.ViewDHMAAdapter;
import com.kiddo.appmanagerclient.model.DonHang;
import com.kiddo.appmanagerclient.model.DonHang_MonAn;
import com.kiddo.appmanagerclient.model.NhanVien;
import com.kiddo.appmanagerclient.retrofit.QuanLyAPI;
import com.kiddo.appmanagerclient.retrofit.RetrofitService;
import com.kiddo.appmanagerclient.retrofit.TokenInterceptor;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ThongTinDonHang_ql extends AppCompatActivity {

    private TextView ten_kh, sdt, dia_chi , tien;

    private AutoCompleteTextView ten;

    private RecyclerView recyclerView;

    private Long id;

    private DonHang donHang;

    private List<NhanVien> listNV;

    RetrofitService retrofitService = new RetrofitService();
    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new TokenInterceptor()).build();
    QuanLyAPI quanLyAPI = retrofitService.getRetrofit().client(client).build().create(QuanLyAPI.class);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_tt_donhang_ql);

        ten_kh = findViewById(R.id.ten_kh);
        sdt = findViewById(R.id.sdt);
        dia_chi = findViewById(R.id.dia_chi);
        tien = findViewById(R.id.tong_tien);

        recyclerView = findViewById(R.id.ds_monan);

        id = getIntent().getExtras().getLong("ID");

        showTTDH();

        getListMA();

        onClickChooseNV();
    }

    private void showTTDH(){
        getTTDH();
        if (donHang != null) {
            ten_kh.setText(donHang.getName());
        } else {
            Toast.makeText(this, "Unable ", Toast.LENGTH_SHORT).show();
        }
//        sdt.setText(donHang.getPhone());
//        dia_chi.setText(donHang.getAddress());
//        tien.setText((int) donHang.getPrice());
    }

    private void getTTDH(){
        quanLyAPI.getDHByID(id)
                .enqueue(new Callback<DonHang>() {
                    @Override
                    public void onResponse(Call<DonHang> call, Response<DonHang> response) {
                        donHang = response.body();
                    }

                    @Override
                    public void onFailure(Call<DonHang> call, Throwable t) {

                    }
                });
    }

    private void getListMA(){
        List<DonHang_MonAn> listDHMA = new ArrayList<>();
        getTTDH();
        ViewDHMAAdapter viewDHMAAdapter = new ViewDHMAAdapter(listDHMA);
        recyclerView.setAdapter(viewDHMAAdapter);

    }

    private void onClickChooseNV(){
        quanLyAPI.getNV()
                .enqueue(new Callback<List<NhanVien>>() {
                    @Override
                    public void onResponse(Call<List<NhanVien>> call, Response<List<NhanVien>> response) {
                        listNV = response.body();
                        ArrayAdapter<String> nhanVienArrayAdapter = new ArrayAdapter<>(
                                ThongTinDonHang_ql.this, R.layout.ten_nv, getListNameNV(listNV));
                        ten = findViewById(R.id.fill_status);
                        ten.setAdapter(nhanVienArrayAdapter);

                        ten.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        });
                    }

                    @Override
                    public void onFailure(Call<List<NhanVien>> call, Throwable t) {

                    }
                });
    }

    private List<String> getListNameNV(List<NhanVien> list) {
        List<String> name = new ArrayList<>();
        for (NhanVien nhanVien : list) {
            name.add(nhanVien.getName());
        }
        return name;
    }
}

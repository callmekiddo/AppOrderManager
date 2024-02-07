package com.kiddo.appmanagerclient.nhanvien;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.kiddo.appmanagerclient.R;
import com.kiddo.appmanagerclient.donhang_monan.ViewDHMAAdapter;
import com.kiddo.appmanagerclient.model.DonHang;
import com.kiddo.appmanagerclient.model.NhanVien;
import com.kiddo.appmanagerclient.quanly.ThongTinDonHang_ql;
import com.kiddo.appmanagerclient.retrofit.NhanVienAPI;
import com.kiddo.appmanagerclient.retrofit.RetrofitService;
import com.kiddo.appmanagerclient.retrofit.TokenInterceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ThongTinDonHang_nv extends AppCompatActivity {

    private TextView ten_kh, sdt, dia_chi, tien;

    private AutoCompleteTextView autoCompleteTextView;

    private Button hoan_thanh;

    private RecyclerView recyclerView;

    private Long id;

    private DonHang donHang;

    private ViewDHMAAdapter adapter;

    private String trang_thai;

    private Boolean isComplete;

    RetrofitService retrofitService = new RetrofitService();
    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new TokenInterceptor()).build();
    NhanVienAPI nhanVienAPI = retrofitService.getRetrofit().client(client).build().create(NhanVienAPI.class);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_tt_donhang_nv);

        ten_kh = findViewById(R.id.ten_kh);
        sdt = findViewById(R.id.sdt);
        dia_chi = findViewById(R.id.dia_chi);
        tien = findViewById(R.id.tong_tien);
        hoan_thanh = findViewById(R.id.hoan_thanh);

        adapter = new ViewDHMAAdapter(new ArrayList<>());
        recyclerView = findViewById(R.id.ds_monan);
        recyclerView.setAdapter(adapter);
        id = Objects.requireNonNull(getIntent().getExtras()).getLong("ID");

        getTTDH();

        onClickChooseStatus();

        onClickComplete();
    }

    private void getTTDH(){
        nhanVienAPI.getDHByID(id)
                .enqueue(new Callback<DonHang>() {
                    @Override
                    public void onResponse(Call<DonHang> call, Response<DonHang> response) {
                        if(response.isSuccessful()){
                            donHang = response.body();
                            assert donHang != null;
                            sdt.setText(donHang.getPhone());
                            dia_chi.setText(donHang.getAddress());
                            tien.setText(String.valueOf(donHang.getPrice()));
                            ten_kh.setText(donHang.getName());
                            adapter.setList(donHang.getOrderItemDtoList());
                        }
                        else{
                            Toast.makeText(ThongTinDonHang_nv.this,"Something's wrong",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<DonHang> call, Throwable t) {
                        Toast.makeText(ThongTinDonHang_nv.this,t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void onClickChooseStatus(){
        String[] status = new String[]{"ĐÃ NHẬN", "ĐÃ HỦY"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.trang_thai, status);
        autoCompleteTextView = findViewById(R.id.fill_status);
        autoCompleteTextView.setAdapter(adapter);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                trang_thai = autoCompleteTextView.getText().toString();
            }
        });
    }

    private void onClickComplete(){
        hoan_thanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(trang_thai != null) {
                    isComplete = trang_thai.equals("ĐÃ NHẬN");
                    nhanVienAPI.isComplete(id, isComplete)
                            .enqueue(new Callback<Map<Long, String>>() {
                                @Override
                                public void onResponse(Call<Map<Long, String>> call, Response<Map<Long, String>> response) {
                                    if (response.isSuccessful()) {
                                        Toast.makeText(ThongTinDonHang_nv.this,
                                                "Đơn hàng: " + trang_thai, Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(ThongTinDonHang_nv.this, HomeNV.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }

                                @Override
                                public void onFailure(Call<Map<Long, String>> call, Throwable t) {

                                }
                            });
                }else {
                    Toast.makeText(ThongTinDonHang_nv.this, "Chưa chọn trạng thái đơn hàng", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

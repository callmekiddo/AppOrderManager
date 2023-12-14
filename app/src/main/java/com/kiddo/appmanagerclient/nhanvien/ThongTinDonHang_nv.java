package com.kiddo.appmanagerclient.nhanvien;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.kiddo.appmanagerclient.R;
import com.kiddo.appmanagerclient.retrofit.NhanVienAPI;
import com.kiddo.appmanagerclient.retrofit.QuanLyAPI;
import com.kiddo.appmanagerclient.retrofit.RetrofitService;

public class ThongTinDonHang_nv extends AppCompatActivity {

    private TextView ten_kh, sdt, dia_chi;

    RetrofitService retrofitService = new RetrofitService();
    NhanVienAPI nhanVienAPI = retrofitService.getRetrofit().create(NhanVienAPI.class);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_tt_donhang_nv);

        ten_kh.findViewById(R.id.ten_kh);
        sdt.findViewById(R.id.sdt);
        dia_chi.findViewById(R.id.dia_chi);

    }

    private void getKH(){

    }
}

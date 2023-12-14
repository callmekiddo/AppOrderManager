package com.kiddo.appmanagerclient.quanly;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.kiddo.appmanagerclient.R;
import com.kiddo.appmanagerclient.model.NhanVien;
import com.kiddo.appmanagerclient.retrofit.QuanLyAPI;
import com.kiddo.appmanagerclient.retrofit.RetrofitService;

import java.util.List;

public class ThongTinDonHang_ql extends AppCompatActivity {

    private TextView ten_kh, sdt, dia_chi;

    private AutoCompleteTextView ten;

    RetrofitService retrofitService = new RetrofitService();
    QuanLyAPI quanLyAPI = retrofitService.getRetrofit().create(QuanLyAPI.class);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_tt_donhang_ql);

        ten_kh.findViewById(R.id.ten_kh);
        sdt.findViewById(R.id.sdt);
        dia_chi.findViewById(R.id.dia_chi);

        
    }

    private void getKH(){

    }

    private void onClickChooseNV(){
        ArrayAdapter<NhanVien> nhanVienArrayAdapter = new ArrayAdapter<>(this, R.layout.ten_nv);
        ten = findViewById(R.id.fill_ten);
        ten.setAdapter(nhanVienArrayAdapter);

        ten.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                
            }
        });
    }
}

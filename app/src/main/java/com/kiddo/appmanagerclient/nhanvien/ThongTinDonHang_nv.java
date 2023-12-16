package com.kiddo.appmanagerclient.nhanvien;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.kiddo.appmanagerclient.R;
import com.kiddo.appmanagerclient.retrofit.NhanVienAPI;
import com.kiddo.appmanagerclient.retrofit.RetrofitService;
import com.kiddo.appmanagerclient.retrofit.TokenInterceptor;

import okhttp3.OkHttpClient;

public class ThongTinDonHang_nv extends AppCompatActivity {

    private TextView ten_kh, sdt, dia_chi;

    private AutoCompleteTextView autoCompleteTextView;

    RetrofitService retrofitService = new RetrofitService();
    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new TokenInterceptor()).build();
    NhanVienAPI nhanVienAPI = retrofitService.getRetrofit().client(client).build().create(NhanVienAPI.class);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_tt_donhang_nv);

        ten_kh = findViewById(R.id.ten_kh);
        sdt = findViewById(R.id.sdt);
        dia_chi = findViewById(R.id.dia_chi);

        onClickChooseStatus();

    }

    private void getKH(){

    }

    private void onClickChooseStatus(){
        String[] status = new String[]{"CANCEL", "COMPLETE"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.trang_thai, status);
        autoCompleteTextView = findViewById(R.id.fill_status);
        autoCompleteTextView.setAdapter(adapter);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }
}

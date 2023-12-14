package com.kiddo.appmanagerclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kiddo.appmanagerclient.nhanvien.LoginNV;
import com.kiddo.appmanagerclient.quanly.LoginQL;

public class InPutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_interface);

        Button NutNV = findViewById(R.id.NutNV);
        Button NutQL = findViewById(R.id.NutQL);

        NutNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InPutActivity.this, LoginNV.class);
                startActivity(intent);
            }
        });

        NutQL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InPutActivity.this, LoginQL.class);
                startActivity(intent);
            }
        });
    }
}
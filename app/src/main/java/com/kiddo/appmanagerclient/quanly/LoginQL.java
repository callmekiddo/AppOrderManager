package com.kiddo.appmanagerclient.quanly;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.kiddo.appmanagerclient.R;
import com.kiddo.appmanagerclient.datastore.TokenStore;
import com.kiddo.appmanagerclient.model.Account;
import com.kiddo.appmanagerclient.model.AuthReponse;
import com.kiddo.appmanagerclient.retrofit.LoginAPI;
import com.kiddo.appmanagerclient.retrofit.QuanLyAPI;
import com.kiddo.appmanagerclient.retrofit.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginQL extends AppCompatActivity {

    private Button loginbt;
    private TextInputEditText username, password;

    private Account account;

    private AuthReponse authReponse;

    private final String Role = "ROLE_MANAGER";

    RetrofitService retrofitService = new RetrofitService();
    LoginAPI loginAPI = retrofitService.getRetrofit().build().create(LoginAPI.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_ql);

        username = findViewById(R.id.user_ql);
        password = findViewById(R.id.pass_ql);
        loginbt = findViewById(R.id.lg_ql);

        onClickLogin();
    }

    private void onClickLogin() {
        loginbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkUser();
                account = new Account();
                account.setUserName(username.getText().toString().trim());
                account.setPassword(password.getText().toString().trim());

                loginAPI.loginQL(account)
                        .enqueue(new Callback<AuthReponse>() {
                            @Override
                            public void onResponse(Call<AuthReponse> call, Response<AuthReponse> response) {
                                if(!response.isSuccessful()){
                                    Toast.makeText(LoginQL.this, "Tên đăng nhập hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                                }else {
                                    authReponse = response.body();
                                    if(authReponse.getRole().get(0).equals(Role)){
                                        TokenStore tokenStore = new TokenStore();
                                        tokenStore.saveToken(authReponse.getAccessToken());

                                        Intent intent = new Intent(LoginQL.this, HomeQL.class);
                                        startActivity(intent);
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call<AuthReponse> call, Throwable t) {

                            }
                        });
            }
        });
    }


    private void checkUser(){
        if(!validateUsername() || !validatePassword()){
        }
    }

    private boolean validateUsername(){
        String user = username.getText().toString();
        if(user.isEmpty()){
            Toast.makeText(LoginQL.this, "Không được để trống tên đăng nhập", Toast.LENGTH_SHORT).show();
            return false;
        }else{
            return true;
        }
    }

    private boolean validatePassword(){
        String pass = password.getText().toString();
        if(pass.isEmpty()){
            Toast.makeText(LoginQL.this, "Không được để trống mật khẩu", Toast.LENGTH_SHORT).show();
            return false;
        }else{
            return true;
        }
    }
}

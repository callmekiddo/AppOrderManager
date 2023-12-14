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

    private String Role = "ROLE_MANAGER";

    RetrofitService retrofitService = new RetrofitService();
    QuanLyAPI quanLyAPI = retrofitService.getRetrofit().create(QuanLyAPI.class);

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

                quanLyAPI.login(account)
                        .enqueue(new Callback<AuthReponse>() {
                            @Override
                            public void onResponse(Call<AuthReponse> call, Response<AuthReponse> response) {
                                if(!response.isSuccessful()){
                                    Toast.makeText(LoginQL.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                                }else {
                                    authReponse = response.body();
                                    if(authReponse.getRole().get(0).equals(Role)){
                                        Intent intent = new Intent(LoginQL.this, HomeQL.class);
                                        TokenStore tokenStore = new TokenStore();
                                        tokenStore.saveToken(authReponse.getAccessToken());

                                        startActivity(intent);
                                    }else{
                                      Toast.makeText(LoginQL.this, "Tên đăng nhập hoặc mật khẩu không đúng",
                                              Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call<AuthReponse> call, Throwable t) {
                                Toast.makeText(LoginQL.this, "?",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }


    private void checkUser(){
        if(!validateUsername() || !validatePassword()){
            return;
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

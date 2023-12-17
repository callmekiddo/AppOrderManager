package com.kiddo.appmanagerclient.retrofit;

import com.kiddo.appmanagerclient.datastore.TokenStore;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class TokenInterceptor implements Interceptor {
    private final TokenStore store = new TokenStore();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request newRequest = chain.request().newBuilder().addHeader("Authorization","Bearer " + store.getToken()).build();
        return chain.proceed(newRequest);
    }
}

package com.kiddo.appmanagerclient.model;

import java.util.List;

public class AuthReponse {
    private String accessToken;
    private String userName;
    private List<String> role;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List getRole() {
        return role;
    }

    public void setRole(List role) {
        this.role = role;
    }
}

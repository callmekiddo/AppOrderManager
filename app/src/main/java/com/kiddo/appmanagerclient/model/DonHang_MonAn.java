package com.kiddo.appmanagerclient.model;

public class DonHang_MonAn {
    private MonAn ma_id;
    private DonHang dh_id;
    private int so_luong;

    public MonAn getMa_id() {
        return ma_id;
    }

    public void setMa_id(MonAn ma_id) {
        this.ma_id = ma_id;
    }

    public DonHang getDh_id() {
        return dh_id;
    }

    public void setDh_id(DonHang dh_id) {
        this.dh_id = dh_id;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }
}

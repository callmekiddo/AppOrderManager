package com.kiddo.appmanagerclient.model;

public class KhachHang {
    private Long id;
    private String ten;
    private String dia_chi;
    private Long sdt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public Long getSdt() {
        return sdt;
    }

    public void setSdt(Long sdt) {
        this.sdt = sdt;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}

package com.kiddo.appmanagerclient.model;

import java.util.Date;

public class DonHang {
    private Long id;

    private KhachHang kh_id;

    private ChiNhanh cn_id;

    private NhanVien nv_id;
    private Date create_at;
    private Date deliver_at;
    private String dia_chi;
    private String trang_thai;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public KhachHang getKh_id() {
        return kh_id;
    }

    public void setKh_id(KhachHang kh_id) {
        this.kh_id = kh_id;
    }

    public ChiNhanh getCn_id() {
        return cn_id;
    }

    public void setCn_id(ChiNhanh cn_id) {
        this.cn_id = cn_id;
    }

    public NhanVien getNv_id() {
        return nv_id;
    }

    public void setNv_id(NhanVien nv_id) {
        this.nv_id = nv_id;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public Date getDeliver_at() {
        return deliver_at;
    }

    public void setDeliver_at(Date deliver_at) {
        this.deliver_at = deliver_at;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public String getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(String trang_thai) {
        this.trang_thai = trang_thai;
    }
}

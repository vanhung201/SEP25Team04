package com.example.user.Entity;

public class KetquaDaiPhatDTO {
    private Integer mien;
    private Integer tinh;
    private Integer giaithuong;
    private String sotrungthuong;
    private String ngay;
    private String loaive;

    public KetquaDaiPhatDTO(String giaithuong, String sotrungthuong, String ngay, String tinh, String mien) {
        this.giaithuong = Integer.valueOf(giaithuong);
        this.sotrungthuong = sotrungthuong;
        this.ngay = ngay;
        this.tinh = Integer.valueOf(tinh);
        this.mien = Integer.valueOf(mien);
    }

    public Integer getGiaithuong() {
        return giaithuong;
    }

    public void setGiaithuong(Integer giaithuong) {
        this.giaithuong = giaithuong;
    }

    public Integer getMien() {
        return mien;
    }

    public void setMien(Integer mien) {
        this.mien = mien;
    }

    public Integer getTinh() {
        return tinh;
    }

    public void setTinh(Integer tinh) {
        this.tinh = tinh;
    }

    public String getLoaive() {
        return loaive;
    }

    public void setLoaive(String loaive) {
        this.loaive = loaive;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getSotrungthuong() {
        return sotrungthuong;
    }

    public void setSotrungthuong(String sotrungthuong) {
        this.sotrungthuong = sotrungthuong;
    }

}


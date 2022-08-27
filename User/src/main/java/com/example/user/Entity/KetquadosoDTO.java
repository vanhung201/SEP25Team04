package com.example.user.Entity;

public class KetquadosoDTO {
    private Integer mien;
    private Integer tinh;
    private Integer giaithuong;
    private String sotrungthuong;
    private String loaive;
    private String ngay;

    public KetquadosoDTO(Integer mien, Integer tinh, Integer giaithuong, String sotrungthuong, String loaive, String ngay) {
        this.mien = mien;
        this.tinh = tinh;
        this.giaithuong = giaithuong;
        this.sotrungthuong = sotrungthuong;
        this.loaive = loaive;
        this.ngay = ngay;
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

    public Integer getGiaithuong() {
        return giaithuong;
    }

    public void setGiaithuong(Integer giaithuong) {
        this.giaithuong = giaithuong;
    }

    public String getSotrungthuong() {
        return sotrungthuong;
    }

    public void setSotrungthuong(String sotrungthuong) {
        this.sotrungthuong = sotrungthuong;
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
}

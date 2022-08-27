package com.example.user.Entity;

public class KetquaMinhNgocDTO {
    private Integer mien;
    private Integer tinh;
    private Integer giaithuong;
    private String sotrungthuong;
    private String loaive;
    private String ngay;

    public KetquaMinhNgocDTO(String idmien, String tinh,String ngay ,String loaive, String giaithuong,
                             String sotrungthuong) {
        this.mien = Integer.valueOf(idmien);
        this.tinh = Integer.valueOf(tinh);
        this.ngay = ngay;
        this.loaive = loaive;
        this.giaithuong = Integer.valueOf(giaithuong);
        this.sotrungthuong = sotrungthuong;
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

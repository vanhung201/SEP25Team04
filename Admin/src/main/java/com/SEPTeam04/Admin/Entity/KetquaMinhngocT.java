package com.SEPTeam04.Admin.Entity;

import javax.persistence.*;

@Entity
@Table(name = "ketqua_minhngoc_t")
public class KetquaMinhngocT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "idmien")
    private Integer idmien;

    @Column(name = "tinh")
    private Integer tinh;

    @Column(name = "ngay")
    private String ngay;

    @Column(name = "loaive")
    private String loaive;

    @Column(name = "giaithuong")
    private String giaithuong;

    @Column(name = "sotrungthuong")
    private String sotrungthuong;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdmien() {
        return idmien;
    }

    public void setIdmien(Integer idmien) {
        this.idmien = idmien;
    }

    public Integer getTinh() {
        return tinh;
    }

    public void setTinh(Integer tinh) {
        this.tinh = tinh;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getLoaive() {
        return loaive;
    }

    public void setLoaive(String loaive) {
        this.loaive = loaive;
    }

    public String getGiaithuong() {
        return giaithuong;
    }

    public void setGiaithuong(String giaithuong) {
        this.giaithuong = giaithuong;
    }

    public String getSotrungthuong() {
        return sotrungthuong;
    }

    public void setSotrungthuong(String sotrungthuong) {
        this.sotrungthuong = sotrungthuong;
    }

}
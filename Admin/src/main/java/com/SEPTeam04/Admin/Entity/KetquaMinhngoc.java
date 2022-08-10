package com.SEPTeam04.Admin.Entity;

import javax.persistence.*;

@Entity
@Table(name = "KETQUA_MINHNGOC")
public class KetquaMinhngoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mien")
    private Mien mien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tinhthanhpho")
    private TinhThanhpho tinhThanhpho;

    @Column(name = "sotrungthuong", length = 50)
    private String sotrungthuong;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_giaithuong")
    private Giaithuong giaithuong;

    @Column(name = "kyhieuve", length = 30)
    private String kyhieuve;

    @Column(name = "ngay", length = 15)
    private String ngay;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Mien getMien() {
        return mien;
    }

    public void setMien(Mien mien) {
        this.mien = mien;
    }

    public TinhThanhpho getTinhThanhpho() {
        return tinhThanhpho;
    }

    public void setTinhThanhpho(TinhThanhpho tinhThanhpho) {
        this.tinhThanhpho = tinhThanhpho;
    }

    public String getSotrungthuong() {
        return sotrungthuong;
    }

    public void setSotrungthuong(String sotrungthuong) {
        this.sotrungthuong = sotrungthuong;
    }

    public Giaithuong getGiaithuong() {
        return giaithuong;
    }

    public void setGiaithuong(Giaithuong giaithuong) {
        this.giaithuong = giaithuong;
    }

    public String getKyhieuve() {
        return kyhieuve;
    }

    public void setKyhieuve(String kyhieuve) {
        this.kyhieuve = kyhieuve;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }
}
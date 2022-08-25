package com.SEPTeam04.Admin.Entity;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

@Entity
@Table(name = "KETQUA_MINHNGOC")
public class KetquaMinhngoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "id_mien")
    private Integer idMien;

    @Column(name = "id_tinhthanhpho")
    private Integer idTinhthanhpho;

    @Column(name = "sotrungthuong", length = 50)
    private String sotrungthuong;

    @Column(name = "id_giaithuong")
    private Integer idGiaithuong;

    @Nationalized
    @Column(name = "kyhieuve", length = 30)
    private String kyhieuve;

    @Column(name = "ngay", length = 50)
    private String ngay;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdMien() {
        return idMien;
    }

    public void setIdMien(Integer idMien) {
        this.idMien = idMien;
    }

    public Integer getIdTinhthanhpho() {
        return idTinhthanhpho;
    }

    public void setIdTinhthanhpho(Integer idTinhthanhpho) {
        this.idTinhthanhpho = idTinhthanhpho;
    }

    public String getSotrungthuong() {
        return sotrungthuong;
    }

    public void setSotrungthuong(String sotrungthuong) {
        this.sotrungthuong = sotrungthuong;
    }

    public Integer getIdGiaithuong() {
        return idGiaithuong;
    }

    public void setIdGiaithuong(Integer idGiaithuong) {
        this.idGiaithuong = idGiaithuong;
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
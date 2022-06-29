package com.SEPTeam04.Admin.Entity;

import javax.persistence.*;

@Entity
@Table(name = "KETQUADOSO")
public class Ketquadoso {
    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "SoTrungThuong", length = 6)
    private String soTrungThuong;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_VePhatHanh")
    private Vephathanh idVephathanh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Mien")
    private Mien idMien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_TinhThanhPho")
    private TinhThanhpho idTinhthanhpho;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_GiaiThuong")
    private Giaithuong idGiaithuong;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSoTrungThuong() {
        return soTrungThuong;
    }

    public void setSoTrungThuong(String soTrungThuong) {
        this.soTrungThuong = soTrungThuong;
    }

    public Vephathanh getIdVephathanh() {
        return idVephathanh;
    }

    public void setIdVephathanh(Vephathanh idVephathanh) {
        this.idVephathanh = idVephathanh;
    }

    public Mien getIdMien() {
        return idMien;
    }

    public void setIdMien(Mien idMien) {
        this.idMien = idMien;
    }

    public TinhThanhpho getIdTinhthanhpho() {
        return idTinhthanhpho;
    }

    public void setIdTinhthanhpho(TinhThanhpho idTinhthanhpho) {
        this.idTinhthanhpho = idTinhthanhpho;
    }

    public Giaithuong getIdGiaithuong() {
        return idGiaithuong;
    }

    public void setIdGiaithuong(Giaithuong idGiaithuong) {
        this.idGiaithuong = idGiaithuong;
    }

}
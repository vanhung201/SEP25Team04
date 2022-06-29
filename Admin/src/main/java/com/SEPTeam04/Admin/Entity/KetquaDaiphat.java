package com.SEPTeam04.Admin.Entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "KETQUA_DAIPHAT")
public class KetquaDaiphat {
    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Mien")
    private Mien idMien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_TinhThanhPho")
    private TinhThanhpho idTinhthanhpho;

    @Column(name = "SoTrungThuong", length = 6)
    private String soTrungThuong;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_GiaiThuong")
    private Giaithuong idGiaithuong;

    @Column(name = "KyHieuVe", length = 10)
    private String kyHieuVe;

    @Column(name = "ThoiGianMoThuong")
    private LocalDate thoiGianMoThuong;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getSoTrungThuong() {
        return soTrungThuong;
    }

    public void setSoTrungThuong(String soTrungThuong) {
        this.soTrungThuong = soTrungThuong;
    }

    public Giaithuong getIdGiaithuong() {
        return idGiaithuong;
    }

    public void setIdGiaithuong(Giaithuong idGiaithuong) {
        this.idGiaithuong = idGiaithuong;
    }

    public String getKyHieuVe() {
        return kyHieuVe;
    }

    public void setKyHieuVe(String kyHieuVe) {
        this.kyHieuVe = kyHieuVe;
    }

    public LocalDate getThoiGianMoThuong() {
        return thoiGianMoThuong;
    }

    public void setThoiGianMoThuong(LocalDate thoiGianMoThuong) {
        this.thoiGianMoThuong = thoiGianMoThuong;
    }

}
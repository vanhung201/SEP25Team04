package com.SEPTeam04.Admin.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "VEPHATHANH")
public class Vephathanh {
    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "ThoiGianMoThuong")
    private LocalDate thoiGianMoThuong;

    @Column(name = "KyHieuVe", length = 35)
    private String kyHieuVe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getThoiGianMoThuong() {
        return thoiGianMoThuong;
    }

    public void setThoiGianMoThuong(LocalDate thoiGianMoThuong) {
        this.thoiGianMoThuong = thoiGianMoThuong;
    }

    public String getKyHieuVe() {
        return kyHieuVe;
    }

    public void setKyHieuVe(String kyHieuVe) {
        this.kyHieuVe = kyHieuVe;
    }

}
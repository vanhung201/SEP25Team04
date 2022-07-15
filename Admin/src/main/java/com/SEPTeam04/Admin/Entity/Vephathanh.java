package com.SEPTeam04.Admin.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "idVephathanh")
    private Set<Ketquadoso> ketquadosos = new LinkedHashSet<>();

    public Set<Ketquadoso> getKetquadosos() {
        return ketquadosos;
    }

    public void setKetquadosos(Set<Ketquadoso> ketquadosos) {
        this.ketquadosos = ketquadosos;
    }

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
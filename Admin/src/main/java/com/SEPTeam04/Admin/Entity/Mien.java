package com.SEPTeam04.Admin.Entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "MIEN")
public class Mien {
    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "TenMien", length = 50)
    private String tenMien;

    @OneToMany(mappedBy = "idMien")
    private Set<KetquaDaiphat> ketquaDaiphats = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idMien")
    private Set<Ketquadoso> ketquadosos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idMien")
    private Set<KetquaMinhngoc> ketquaMinhngocs = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idMien")
    private Set<TinhThanhpho> tinhThanhphos = new LinkedHashSet<>();

    public Set<TinhThanhpho> getTinhThanhphos() {
        return tinhThanhphos;
    }

    public void setTinhThanhphos(Set<TinhThanhpho> tinhThanhphos) {
        this.tinhThanhphos = tinhThanhphos;
    }

    public Set<KetquaMinhngoc> getKetquaMinhngocs() {
        return ketquaMinhngocs;
    }

    public void setKetquaMinhngocs(Set<KetquaMinhngoc> ketquaMinhngocs) {
        this.ketquaMinhngocs = ketquaMinhngocs;
    }

    public Set<Ketquadoso> getKetquadosos() {
        return ketquadosos;
    }

    public void setKetquadosos(Set<Ketquadoso> ketquadosos) {
        this.ketquadosos = ketquadosos;
    }

    public Set<KetquaDaiphat> getKetquaDaiphats() {
        return ketquaDaiphats;
    }

    public void setKetquaDaiphats(Set<KetquaDaiphat> ketquaDaiphats) {
        this.ketquaDaiphats = ketquaDaiphats;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenMien() {
        return tenMien;
    }

    public void setTenMien(String tenMien) {
        this.tenMien = tenMien;
    }

}
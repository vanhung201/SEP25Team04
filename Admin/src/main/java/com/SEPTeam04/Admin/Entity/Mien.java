package com.SEPTeam04.Admin.Entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "MIEN")
public class Mien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "tenmien", length = 20)
    private String tenmien;

    @OneToMany(mappedBy = "idMien")
    private Set<Ketquadoso> ketquadosos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idMien")
    private Set<KetquaDaiphat> ketquaDaiphats = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idMien")
    private Set<KetquaMinhngoc> ketquaMinhngocs = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idMien")
    private Set<TinhThanhpho> tinhThanhphos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenmien() {
        return tenmien;
    }

    public void setTenmien(String tenmien) {
        this.tenmien = tenmien;
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

    public Set<KetquaMinhngoc> getKetquaMinhngocs() {
        return ketquaMinhngocs;
    }

    public void setKetquaMinhngocs(Set<KetquaMinhngoc> ketquaMinhngocs) {
        this.ketquaMinhngocs = ketquaMinhngocs;
    }

    public Set<TinhThanhpho> getTinhThanhphos() {
        return tinhThanhphos;
    }

    public void setTinhThanhphos(Set<TinhThanhpho> tinhThanhphos) {
        this.tinhThanhphos = tinhThanhphos;
    }

}
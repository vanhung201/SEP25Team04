package com.SEPTeam04.Admin.Entity;

import javax.persistence.*;
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

    @OneToMany(mappedBy = "mien", cascade = CascadeType.ALL)
    private Set<KetquaMinhngoc> ketQuaMinhNgoc;

    @OneToMany(mappedBy = "mien", cascade = CascadeType.ALL)
    private Set<TinhThanhpho> tinhThanhPho;

    @OneToMany(mappedBy = "mien", cascade = CascadeType.ALL)
    private Set<KetquaDaiphat> ketQuaDaiPhat;

    @OneToMany(mappedBy = "mien", cascade = CascadeType.ALL)
    private Set<Ketquadoso> ketQuaDoSo;

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

    public Set<KetquaMinhngoc> getKetQuaMinhNgoc() {
        return ketQuaMinhNgoc;
    }

    public void setKetQuaMinhNgoc(Set<KetquaMinhngoc> ketQuaMinhNgoc) {
        this.ketQuaMinhNgoc = ketQuaMinhNgoc;
    }

    public Set<TinhThanhpho> getTinhThanhPho() {
        return tinhThanhPho;
    }

    public void setTinhThanhPho(Set<TinhThanhpho> tinhThanhPho) {
        this.tinhThanhPho = tinhThanhPho;
    }

    public Set<KetquaDaiphat> getKetQuaDaiPhat() {
        return ketQuaDaiPhat;
    }

    public void setKetQuaDaiPhat(Set<KetquaDaiphat> ketQuaDaiPhat) {
        this.ketQuaDaiPhat = ketQuaDaiPhat;
    }

    public Set<Ketquadoso> getKetQuaDoSo() {
        return ketQuaDoSo;
    }

    public void setKetQuaDoSo(Set<Ketquadoso> ketQuaDoSo) {
        this.ketQuaDoSo = ketQuaDoSo;
    }
}
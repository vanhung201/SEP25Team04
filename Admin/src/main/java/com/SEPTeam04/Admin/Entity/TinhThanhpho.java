package com.SEPTeam04.Admin.Entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "TINH_THANHPHO")
public class TinhThanhpho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "matinh_thanhpho", length = 5)
    private String matinhThanhpho;

    @Column(name = "tentinh_thanhpho", length = 20)
    private String tentinhThanhpho;

    @OneToMany(mappedBy = "tinhThanhpho", cascade = CascadeType.ALL)
    private Set<KetquaMinhngoc> ketQuaMinhNgoc;

    @OneToMany(mappedBy = "tinhThanhpho", cascade = CascadeType.ALL)
    private Set<KetquaDaiphat> ketQuaDaiPhat;

    @OneToMany(mappedBy = "tinhThanhpho", cascade = CascadeType.ALL)
    private Set<Ketquadoso> ketQuaDoSo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mien")
    private Mien mien;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatinhThanhpho() {
        return matinhThanhpho;
    }

    public void setMatinhThanhpho(String matinhThanhpho) {
        this.matinhThanhpho = matinhThanhpho;
    }

    public String getTentinhThanhpho() {
        return tentinhThanhpho;
    }

    public void setTentinhThanhpho(String tentinhThanhpho) {
        this.tentinhThanhpho = tentinhThanhpho;
    }

    public Set<KetquaMinhngoc> getKetQuaMinhNgoc() {
        return ketQuaMinhNgoc;
    }

    public void setKetQuaMinhNgoc(Set<KetquaMinhngoc> ketQuaMinhNgoc) {
        this.ketQuaMinhNgoc = ketQuaMinhNgoc;
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

    public Mien getMien() {
        return mien;
    }

    public void setMien(Mien mien) {
        this.mien = mien;
    }
}
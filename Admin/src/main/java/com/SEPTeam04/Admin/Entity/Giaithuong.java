package com.SEPTeam04.Admin.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "GIAITHUONG")
public class Giaithuong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "tengiaithuong", length = 20)
    private String tengiaithuong;

    @Column(name = "sotienthuong")
    private Integer sotienthuong;

    @OneToMany(mappedBy = "giaithuong", cascade = CascadeType.ALL)
    private Set<KetquaMinhngoc> ketQuaMinhNgoc;

    @OneToMany(mappedBy = "giaithuong", cascade = CascadeType.ALL)
    private Set<KetquaDaiphat> ketQuaDaiPhat;

    @OneToMany(mappedBy = "giaithuong", cascade = CascadeType.ALL)
    private Set<Ketquadoso> ketQuaDoSo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTengiaithuong() {
        return tengiaithuong;
    }

    public void setTengiaithuong(String tengiaithuong) {
        this.tengiaithuong = tengiaithuong;
    }

    public Integer getSotienthuong() {
        return sotienthuong;
    }

    public void setSotienthuong(Integer sotienthuong) {
        this.sotienthuong = sotienthuong;
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
}
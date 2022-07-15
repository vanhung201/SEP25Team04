package com.SEPTeam04.Admin.Entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "GIAITHUONG")
public class Giaithuong {
    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "TenGiaiThuong", length = 20)
    private String tenGiaiThuong;

    @Column(name = "SoTienThuong")
    private Integer soTienThuong;

    @OneToMany(mappedBy = "idGiaithuong")
    private Set<KetquaDaiphat> ketquaDaiphats = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idGiaithuong")
    private Set<Ketquadoso> ketquadosos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idGiaithuong")
    private Set<KetquaMinhngoc> ketquaMinhngocs = new LinkedHashSet<>();

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

    public String getTenGiaiThuong() {
        return tenGiaiThuong;
    }

    public void setTenGiaiThuong(String tenGiaiThuong) {
        this.tenGiaiThuong = tenGiaiThuong;
    }

    public Integer getSoTienThuong() {
        return soTienThuong;
    }

    public void setSoTienThuong(Integer soTienThuong) {
        this.soTienThuong = soTienThuong;
    }

}
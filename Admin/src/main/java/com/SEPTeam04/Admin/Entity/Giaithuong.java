package com.SEPTeam04.Admin.Entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
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

    @OneToMany(mappedBy = "idGiaithuong")
    private Set<Ketquadoso> ketquadosos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idGiaithuong")
    private Set<KetquaDaiphat> ketquaDaiphats = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idGiaithuong")
    private Set<KetquaMinhngoc> ketquaMinhngocs = new LinkedHashSet<>();

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

}
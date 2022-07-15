package com.SEPTeam04.Admin.Entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "TINH_THANHPHO")
public class TinhThanhpho {
    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "MaTinh_ThanhPho", length = 5)
    private String matinhThanhpho;

    @Column(name = "TenTinh_ThanhPho", length = 20)
    private String tentinhThanhpho;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Mien")
    private Mien idMien;

    @OneToMany(mappedBy = "idTinhthanhpho")
    private Set<KetquaDaiphat> ketquaDaiphats = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idTinhthanhpho")
    private Set<Ketquadoso> ketquadosos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idTinhthanhpho")
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

    public Mien getIdMien() {
        return idMien;
    }

    public void setIdMien(Mien idMien) {
        this.idMien = idMien;
    }

}
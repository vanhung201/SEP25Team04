package com.SEPTeam04.Admin.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "VEPHATHANH")
public class Vephathanh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "thoigianmothuong")
    private LocalDate thoigianmothuong;

    @Column(name = "kyhieuve", length = 35)
    private String kyhieuve;

    @OneToMany(mappedBy = "idVephathanh")
    private Set<Ketquadoso> ketquadosos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getThoigianmothuong() {
        return thoigianmothuong;
    }

    public void setThoigianmothuong(LocalDate thoigianmothuong) {
        this.thoigianmothuong = thoigianmothuong;
    }

    public String getKyhieuve() {
        return kyhieuve;
    }

    public void setKyhieuve(String kyhieuve) {
        this.kyhieuve = kyhieuve;
    }

    public Set<Ketquadoso> getKetquadosos() {
        return ketquadosos;
    }

    public void setKetquadosos(Set<Ketquadoso> ketquadosos) {
        this.ketquadosos = ketquadosos;
    }

}
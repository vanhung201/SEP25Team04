package com.SEPTeam04.Admin.Entity;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

@Entity
@Table(name = "MIEN")
public class Mien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "tenmien", length = 20)
    private String tenmien;

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

}
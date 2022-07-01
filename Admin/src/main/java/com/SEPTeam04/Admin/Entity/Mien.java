package com.SEPTeam04.Admin.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MIEN")
public class Mien {
    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "TenMien", length = 50)
    private String tenMien;

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
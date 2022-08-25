package com.SEPTeam04.Admin.Entity;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

@Entity
@Table(name = "GIAITHUONG")
public class Giaithuong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "tengiaithuong", length = 20)
    private String tengiaithuong;

    @Column(name = "sotienthuong")
    private Integer sotienthuong;

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

}
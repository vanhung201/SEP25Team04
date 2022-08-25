package com.SEPTeam04.Admin.Entity;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

@Entity
@Table(name = "ADMIN_ACCOUNT")
public class AdminAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username", length = 25)
    private String username;

    @Column(name = "password", length = 128)
    private String password;

    @Nationalized
    @Column(name = "hovaten", length = 30)
    private String hovaten;

    @Column(name = "trangthaitaikhoan")
    private Boolean trangthaitaikhoan;

    @Column(name = "role", length = 10)
    private String role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHovaten() {
        return hovaten;
    }

    public void setHovaten(String hovaten) {
        this.hovaten = hovaten;
    }

    public Boolean getTrangthaitaikhoan() {
        return trangthaitaikhoan;
    }

    public void setTrangthaitaikhoan(Boolean trangthaitaikhoan) {
        this.trangthaitaikhoan = trangthaitaikhoan;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
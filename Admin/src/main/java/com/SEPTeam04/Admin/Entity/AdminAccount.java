package com.SEPTeam04.Admin.Entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ADMIN_ACCOUNT", indexes = {
        @Index(name = "UK_ADMIN_ACCOUNT", columnList = "UserName", unique = true)
})
public class AdminAccount {
    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "UserName", length = 25)
    private String userName;

    @Column(name = "Password", length = 128)
    private String password;

    @Column(name = "HoVaTen", length = 30)
    private String hoVaTen;

    @Column(name = "NgayTaoTaiKhoan")
    private LocalDate ngayTaoTaiKhoan;

    @Column(name = "TrangThaiTaiKhoan")
    private Boolean trangThaiTaiKhoan;

    @Column(name = "Role", length = 25)
    private String role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public LocalDate getNgayTaoTaiKhoan() {
        return ngayTaoTaiKhoan;
    }

    public void setNgayTaoTaiKhoan(LocalDate ngayTaoTaiKhoan) {
        this.ngayTaoTaiKhoan = ngayTaoTaiKhoan;
    }

    public Boolean getTrangThaiTaiKhoan() {
        return trangThaiTaiKhoan;
    }

    public void setTrangThaiTaiKhoan(Boolean trangThaiTaiKhoan) {
        this.trangThaiTaiKhoan = trangThaiTaiKhoan;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
package com.SEPTeam04.Admin.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
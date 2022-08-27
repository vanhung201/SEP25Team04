package com.SEPTeam04.Admin.Entity;

import javax.persistence.*;

@Entity
@Table(name = "TINH_THANHPHO")
public class TinhThanhpho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "matinh_thanhpho", length = 5)
    private String matinhThanhpho;

    @Column(name = "tentinh_thanhpho", length = 20)
    private String tentinhThanhpho;

    @Column(name = "id_mien")
    private Integer idMien;

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

    public Integer getIdMien() {
        return idMien;
    }

    public void setIdMien(Integer idMien) {
        this.idMien = idMien;
    }

}
package com.SEPTeam04.Admin.Entity;

import javax.persistence.*;

@Entity
@Table(name = "KETQUADOSO")
public class Ketquadoso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "sotrungthuong", length = 6)
    private String sotrungthuong;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vephathanh")
    private Vephathanh idVephathanh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mien")
    private Mien idMien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tinhthanhpho")
    private TinhThanhpho idTinhthanhpho;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_giaithuong")
    private Giaithuong idGiaithuong;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSotrungthuong() {
        return sotrungthuong;
    }

    public void setSotrungthuong(String sotrungthuong) {
        this.sotrungthuong = sotrungthuong;
    }

    public Vephathanh getIdVephathanh() {
        return idVephathanh;
    }

    public void setIdVephathanh(Vephathanh idVephathanh) {
        this.idVephathanh = idVephathanh;
    }

    public Mien getIdMien() {
        return idMien;
    }

    public void setIdMien(Mien idMien) {
        this.idMien = idMien;
    }

    public TinhThanhpho getIdTinhthanhpho() {
        return idTinhthanhpho;
    }

    public void setIdTinhthanhpho(TinhThanhpho idTinhthanhpho) {
        this.idTinhthanhpho = idTinhthanhpho;
    }

    public Giaithuong getIdGiaithuong() {
        return idGiaithuong;
    }

    public void setIdGiaithuong(Giaithuong idGiaithuong) {
        this.idGiaithuong = idGiaithuong;
    }

}
package com.SEPTeam04.Admin.Entity;

import javax.persistence.*;
import java.time.LocalDate;

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
    @JoinColumn(name = "id_mien")
    private Mien idMien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tinhthanhpho")
    private TinhThanhpho idTinhthanhpho;

    @Column(name = "kyhieuve", length = 30)
    private String kyhieuve;

    @Column(name = "thoigianmothuong")
    private LocalDate thoigianmothuong;

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

    public String getKyhieuve() {
        return kyhieuve;
    }

    public void setKyhieuve(String kyhieuve) {
        this.kyhieuve = kyhieuve;
    }

    public LocalDate getThoigianmothuong() {
        return thoigianmothuong;
    }

    public void setThoigianmothuong(LocalDate thoigianmothuong) {
        this.thoigianmothuong = thoigianmothuong;
    }

    public Giaithuong getIdGiaithuong() {
        return idGiaithuong;
    }

    public void setIdGiaithuong(Giaithuong idGiaithuong) {
        this.idGiaithuong = idGiaithuong;
    }

}
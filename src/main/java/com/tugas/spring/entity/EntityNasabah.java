package com.tugas.spring.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="tbl_nasabah")
public class EntityNasabah {
    @Id
    @Column(length = 7)
    private String noCif;

    @Column(length = 50)
    private String nama;
    @Column(length = 50)
    private String alamat;
    @Column(length = 16)
    private String ktp;
    @Column(length = 13)
    private String noHp;

    @OneToMany(mappedBy = "entityNasabah", cascade = CascadeType.ALL)
    private List<EntityRekening> rekenings;


    // Getter dan Setter
    public String getNoCif() {
        return noCif;
    }

    public void setNoCif(String noCif) {
        this.noCif = noCif;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKtp() {
        return ktp;
    }

    public void setKtp(String ktp) {
        this.ktp = ktp;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String nohp) {
        this.noHp = nohp;
    }

    public List<EntityRekening> getRekenings() { return rekenings; }
    public void setRekenings(List<EntityRekening> rekenings) { this.rekenings = rekenings; }

}

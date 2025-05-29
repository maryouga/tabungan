package com.tugas.spring.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tbl_rekening")
public class EntityRekening {
    @Id
    @Column(length = 6)
    private String noRek;

    @Column(length = 20)
    private Double saldo;

    @Column(name = "tgl_buka")
    private LocalDate tglBuka;

    @ManyToOne
    @JoinColumn(name = "no_cif", referencedColumnName = "noCif")
    private EntityNasabah entityNasabah;

    @OneToMany(mappedBy = "entityRekening", cascade = CascadeType.ALL)
    private List<EntityTransaksi> listTransaksi;

    // Getter dan Setter
    public String getNoRek() {
        return noRek;
    }

    public void setNoRek(String noRek) {
        this.noRek = noRek;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getTglBuka() {
        return tglBuka;
    }

    public void setTglBuka(LocalDate tglBuka) {
        this.tglBuka = tglBuka;
    }

    public EntityNasabah getEntityNasabah() {
        return entityNasabah;
    }

    public void setEntityNasabah(EntityNasabah entityNasabah) {
        this.entityNasabah = entityNasabah;
    }

    public List<EntityTransaksi> getListTransaksi() {
        return listTransaksi;
    }

    public void setListTransaksi(List<EntityTransaksi> listTransaksi) {
        this.listTransaksi = listTransaksi;
    }
}


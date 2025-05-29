package com.tugas.spring.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_transaksi")
public class EntityTransaksi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 13)
    private Long idTx;


    private LocalDate tglTx;
    @Column(length = 1)
    private String jenis;
    @Column(length = 5)
    private String kdStaff;
    @Column(length = 20)
    private Double jumlah;

    @ManyToOne
    @JoinColumn(name = "no_rek", referencedColumnName = "noRek")
    private EntityRekening entityRekening;

    // Getter dan Setter
    public Long getIdTx() {
        return idTx;
    }

    public void setIdTx(Long idTx) {
        this.idTx = idTx;
    }

    public LocalDate getTglTx() {
        return tglTx;
    }

    public void setTglTx(LocalDate tglTx) {
        this.tglTx = tglTx;
    }

    public String getJenis() {return jenis; }
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getKdStaff() {
        return kdStaff;
    }
    public void setKdStaff(String kdStaff) {
        this.kdStaff = kdStaff;
    }

    public Double getJumlah() {
        return jumlah;
    }
    public void setJumlah(Double jumlah) {
        this.jumlah = jumlah;
    }

    public EntityRekening getEntityRekening() {
        return entityRekening;
    }


    public void setEntityRekening(EntityRekening entityRekening) {
        this.entityRekening = entityRekening;
    }
}


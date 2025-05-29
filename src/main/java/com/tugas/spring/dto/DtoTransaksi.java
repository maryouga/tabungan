package com.tugas.spring.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DtoTransaksi {
    private Long idTx;
    private LocalDate tglTx;

    @Pattern(regexp = "D|K", message = "Jenis hanya boleh D atau K")
    private String jenis;

    @Pattern(regexp = "\\d+", message = "kdStaff hanya boleh berisi angka")
    private String kdStaff;

    @Positive(message = "Jumlah harus lebih dari 0")
    private Double jumlah;

    private String noRek; // FK ke Rekening

    public Long getIdTx() {
        return idTx;
    }

    public void setIdTx(Long idTx) {
        this.idTx = idTx;
    }


    public String getNoRek() {
        return noRek;
    }

    public void setNoRek(String noRek) {
        this.noRek = noRek;
    }

    public LocalDate getTglTx() {
        return tglTx;
    }

    public void setTglTx(LocalDate tglTx) {
        this.tglTx = tglTx;
    }

    public String getJenis() {
        return jenis;
    }

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

}

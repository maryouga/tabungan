package com.tugas.spring.dto;

import lombok.Data;

import java.util.List;

@Data
public class DtoNasabah {
    private String noCif;
    private String nama;
    private String alamat;
    private String ktp;
    private String noHp;

    private List<DtoRekening> rekenings;

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

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public List<DtoRekening> getRekenings() {
        return rekenings;
    }

    public void setRekenings(List<DtoRekening> rekenings) {
        this.rekenings = rekenings;
    }
}

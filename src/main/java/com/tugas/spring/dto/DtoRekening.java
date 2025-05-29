package com.tugas.spring.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DtoRekening {
        private String noRek;
        private Double saldo;
        private LocalDate tglBuka;
        private String noCif; // foreign key Nasabah

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

        public String getNoCif() {
                return noCif;
        }

        public void setNoCif(String noCif) {
                this.noCif = noCif;
        }

}

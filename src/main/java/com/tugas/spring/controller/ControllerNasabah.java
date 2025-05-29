package com.tugas.spring.controller;

import com.tugas.spring.dto.DtoNasabah;
import com.tugas.spring.service.ServiceNasabah;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nasabah")

public class ControllerNasabah {
    @Autowired
    private ServiceNasabah serviceNasabah;

    @GetMapping
    public List<DtoNasabah> getAll() {
        return serviceNasabah.getAllNasabah();
    }

    @GetMapping("/{noCif}")
    public DtoNasabah getById(@PathVariable String noCif) {
        return serviceNasabah.getNasabahById(noCif);
    }

    @PostMapping
    public DtoNasabah create(@RequestBody DtoNasabah dtoNasabah) {
        return serviceNasabah.saveNasabah(dtoNasabah);
    }

    @PutMapping("/{noCif}")
    public DtoNasabah update(@PathVariable String noCif, @RequestBody DtoNasabah dtoNasabah) {
        return serviceNasabah.updateNasabah(noCif, dtoNasabah);
    }

    @DeleteMapping("/{noCif}")
    public void delete(@PathVariable String noCif) {
        serviceNasabah.deleteNasabah(noCif);
    }
}

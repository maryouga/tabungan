package com.tugas.spring.controller;

import com.tugas.spring.dto.DtoTransaksi;
import com.tugas.spring.service.ServiceTransaksi;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/transaksi")

public class ControllerTransaksi {
    @Autowired
    private ServiceTransaksi serviceTransaksi;

    @GetMapping
    public List<DtoTransaksi> getAll() {
        return serviceTransaksi.getAll();
    }

    @GetMapping("/{idTx}")
    public DtoTransaksi getById(@PathVariable Long idTx) {
        return serviceTransaksi.getById(idTx);
    }

    @PostMapping
    public DtoTransaksi create(@Valid @RequestBody DtoTransaksi dto) {
        return serviceTransaksi.create(dto);
    }

    @PutMapping("/{idTx}")
    public DtoTransaksi update(@PathVariable Long idTx, @RequestBody DtoTransaksi dto) {
        return serviceTransaksi.update(idTx, dto);
    }

    @DeleteMapping("/{idTx}")
    public void delete(@PathVariable Long idTx) {
        serviceTransaksi.delete(idTx);
    }
}

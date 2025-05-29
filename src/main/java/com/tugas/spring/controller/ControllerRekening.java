package com.tugas.spring.controller;

import com.tugas.spring.dto.DtoRekening;
import com.tugas.spring.entity.EntityRekening;
import com.tugas.spring.service.ServiceRekening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rekening")
public class ControllerRekening {

    @Autowired
    private ServiceRekening serviceRekening;

    @GetMapping
    public List<DtoRekening> getAll() {
        return serviceRekening.getAll();
    }

    @GetMapping("/{noRek}")
    public DtoRekening getById(@PathVariable String noRek) {
        return serviceRekening.getById(noRek);
    }

    @PostMapping
    public DtoRekening create(@RequestBody DtoRekening dto) {
        return serviceRekening.create(dto);
    }

    @PutMapping("/{noRek}")
    public DtoRekening update(@PathVariable String noRek, @RequestBody DtoRekening dto) {
        return serviceRekening.update(noRek, dto);
    }

    @DeleteMapping("/{noRek}")
    public void delete(@PathVariable String noRek) {
        serviceRekening.delete(noRek);
    }
}

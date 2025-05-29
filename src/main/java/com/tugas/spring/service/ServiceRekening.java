package com.tugas.spring.service;

import com.tugas.spring.dto.DtoRekening;
import com.tugas.spring.entity.EntityNasabah;
import com.tugas.spring.entity.EntityRekening;
import com.tugas.spring.mapper.MapperRekening;
import com.tugas.spring.repository.RepositoryNasabah;
import com.tugas.spring.repository.RepositoryRekening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceRekening {

    @Autowired
    private RepositoryRekening repositoryRekening;

    @Autowired
    private RepositoryNasabah repositoryNasabah;

    public List<DtoRekening> getAll() {
        return repositoryRekening.findAll()
                .stream()
                .map(MapperRekening::toDto)
                .collect(Collectors.toList());
    }

    public DtoRekening getById(String noRek) {
        EntityRekening entity = repositoryRekening.findById(noRek)
                .orElseThrow(() -> new RuntimeException("Rekening not found"));
        return MapperRekening.toDto(entity);
    }

    public DtoRekening create(DtoRekening dto) {
        EntityNasabah nasabah = repositoryNasabah.findById(dto.getNoCif())
                .orElseThrow(() -> new RuntimeException("Nasabah not found"));
        EntityRekening entity = MapperRekening.toEntity(dto, nasabah);
        entity = repositoryRekening.save(entity);
        return MapperRekening.toDto(entity);
    }

    public DtoRekening update(String noRek, DtoRekening dto) {
        EntityRekening entity = repositoryRekening.findById(noRek)
                .orElseThrow(() -> new RuntimeException("Rekening not found"));

        EntityNasabah nasabah = repositoryNasabah.findById(dto.getNoCif())
                .orElseThrow(() -> new RuntimeException("Nasabah not found"));

        entity.setSaldo(dto.getSaldo());
        entity.setTglBuka(dto.getTglBuka());
        entity.setEntityNasabah(nasabah);

        entity = repositoryRekening.save(entity);
        return MapperRekening.toDto(entity);
    }

    public void delete(String noRek) {
        repositoryRekening.deleteById(noRek);
    }
}

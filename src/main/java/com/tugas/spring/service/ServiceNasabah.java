package com.tugas.spring.service;

import com.tugas.spring.dto.DtoNasabah;
import com.tugas.spring.entity.EntityNasabah;
import com.tugas.spring.mapper.MapperNasabah;
import com.tugas.spring.repository.RepositoryNasabah;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceNasabah {

    @Autowired
    private RepositoryNasabah repositoryNasabah;

    public List<DtoNasabah> getAllNasabah() {
        return repositoryNasabah.findAll()
                .stream()
                .map(MapperNasabah::toDto)
                .collect(Collectors.toList());
    }

    public DtoNasabah getNasabahById(String noCif) {
        EntityNasabah entityNasabah = repositoryNasabah.findById(noCif)
                .orElseThrow(() -> new RuntimeException("Nasabah not found"));
        return MapperNasabah.toDto(entityNasabah);
    }

    public DtoNasabah saveNasabah(DtoNasabah dtoNasabah) {
        EntityNasabah entityNasabah = MapperNasabah.toEntity(dtoNasabah);
        entityNasabah = repositoryNasabah.save(entityNasabah);
        return MapperNasabah.toDto(entityNasabah);
    }

    public DtoNasabah updateNasabah(String noCif, DtoNasabah dtoNasabah) {
        EntityNasabah entityNasabah = repositoryNasabah.findById(noCif)
                .orElseThrow(() -> new RuntimeException("Nasabah not found"));

        entityNasabah.setNama(dtoNasabah.getNama());
        entityNasabah.setAlamat(dtoNasabah.getAlamat());
        entityNasabah.setKtp(dtoNasabah.getKtp());
        entityNasabah.setNoHp(dtoNasabah.getNoHp());

        entityNasabah = repositoryNasabah.save(entityNasabah);
        return MapperNasabah.toDto(entityNasabah);
    }

    public void deleteNasabah(String noCif) {
        repositoryNasabah.deleteById(noCif);
    }
}

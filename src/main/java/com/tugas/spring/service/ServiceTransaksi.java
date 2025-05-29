package com.tugas.spring.service;


import com.tugas.spring.dto.DtoTransaksi;
import com.tugas.spring.entity.EntityRekening;
import com.tugas.spring.entity.EntityTransaksi;
import com.tugas.spring.mapper.MapperTransaksi;
import com.tugas.spring.repository.RepositoryRekening;
import com.tugas.spring.repository.RepositoryTransaksi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceTransaksi {

    @Autowired
    private RepositoryTransaksi repositoryTransaksi;

    @Autowired
    private RepositoryRekening repositoryRekening;

    public List<DtoTransaksi> getAll() {
        return repositoryTransaksi.findAll()
                .stream()
                .map(MapperTransaksi::toDto)
                .collect(Collectors.toList());
    }

    public DtoTransaksi getById(Long id) {
        EntityTransaksi entity = repositoryTransaksi.findById(id)
                .orElseThrow(() -> new RuntimeException("Data Tidak Ada"));
        return MapperTransaksi.toDto(entity);
    }

    public DtoTransaksi create(DtoTransaksi dto) {
        EntityRekening rekening = repositoryRekening.findById(dto.getNoRek())
                .orElseThrow(() -> new RuntimeException("Rekening not found"));
        EntityTransaksi entity = MapperTransaksi.toEntity(dto, rekening);
        entity = repositoryTransaksi.save(entity);
        return MapperTransaksi.toDto(entity);
    }

    public DtoTransaksi update(Long id, DtoTransaksi dto) {
        EntityTransaksi entity = repositoryTransaksi.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaksi not found"));

        EntityRekening rekening = repositoryRekening.findById(dto.getNoRek())
                .orElseThrow(() -> new RuntimeException("Rekening not found"));

        entity.setTglTx(dto.getTglTx());
        entity.setJenis(dto.getJenis());
        entity.setKdStaff(dto.getKdStaff());
        entity.setJumlah(dto.getJumlah());
        entity.setEntityRekening(rekening);

        entity = repositoryTransaksi.save(entity);
        return MapperTransaksi.toDto(entity);
    }

    public void delete(Long id) {
        repositoryTransaksi.deleteById(id);
    }

}

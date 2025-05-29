package com.tugas.spring.mapper;

import com.tugas.spring.dto.DtoTransaksi;
import com.tugas.spring.entity.EntityRekening;
import com.tugas.spring.entity.EntityTransaksi;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class MapperTransaksi {
    public static EntityTransaksi toEntity(DtoTransaksi dto, EntityRekening rekening) {
        EntityTransaksi entity = new EntityTransaksi();
        entity.setIdTx(dto.getIdTx());
        entity.setTglTx(dto.getTglTx());
        entity.setJenis(dto.getJenis());
        entity.setKdStaff(dto.getKdStaff());
        entity.setJumlah(dto.getJumlah());
        entity.setEntityRekening(rekening);

        return entity;
    }

    public static DtoTransaksi toDto(EntityTransaksi entity) {
        DtoTransaksi dto = new DtoTransaksi();
        dto.setIdTx(entity.getIdTx());
        dto.setTglTx(entity.getTglTx());
        dto.setJenis(entity.getJenis());
        dto.setKdStaff(entity.getKdStaff());
        dto.setJumlah(entity.getJumlah());
        dto.setNoRek(entity.getEntityRekening().getNoRek());
        return dto;
    }
}

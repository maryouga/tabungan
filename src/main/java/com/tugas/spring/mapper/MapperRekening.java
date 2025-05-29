package com.tugas.spring.mapper;

import com.tugas.spring.dto.DtoRekening;
import com.tugas.spring.entity.EntityNasabah;
import com.tugas.spring.entity.EntityRekening;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class MapperRekening {
    public static EntityRekening toEntity(DtoRekening dto, EntityNasabah nasabah) {
        EntityRekening entity = new EntityRekening();
        entity.setNoRek(dto.getNoRek());
        entity.setSaldo(dto.getSaldo());
        entity.setTglBuka(dto.getTglBuka());
        entity.setEntityNasabah(nasabah);
        return entity;
    }

    public static DtoRekening toDto(EntityRekening entity) {
        DtoRekening dto = new DtoRekening();
        dto.setNoRek(entity.getNoRek());
        dto.setSaldo(entity.getSaldo());
        dto.setTglBuka(entity.getTglBuka());
        dto.setNoCif(entity.getEntityNasabah().getNoCif());
        return dto;
    }
}

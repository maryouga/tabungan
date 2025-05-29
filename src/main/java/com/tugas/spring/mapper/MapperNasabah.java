package com.tugas.spring.mapper;

import com.tugas.spring.dto.DtoNasabah;
import com.tugas.spring.dto.DtoRekening;
import com.tugas.spring.entity.EntityNasabah;

import java.util.List;
import java.util.stream.Collectors;

public class MapperNasabah {
    public static EntityNasabah toEntity(DtoNasabah dtoNasabah) {
        EntityNasabah entityNasabah = new EntityNasabah();
        entityNasabah.setNoCif(dtoNasabah.getNoCif());
        entityNasabah.setNama(dtoNasabah.getNama());
        entityNasabah.setAlamat(dtoNasabah.getAlamat());
        entityNasabah.setKtp(dtoNasabah.getKtp());
        entityNasabah.setNoHp(dtoNasabah.getNoHp());
        return entityNasabah;
    }

    public static DtoNasabah toDto(EntityNasabah entityNasabah) {
        DtoNasabah dtoNasabah = new DtoNasabah();
        dtoNasabah.setNoCif(entityNasabah.getNoCif());
        dtoNasabah.setNama(entityNasabah.getNama());
        dtoNasabah.setAlamat(entityNasabah.getAlamat());
        dtoNasabah.setKtp(entityNasabah.getKtp());
        dtoNasabah.setNoHp(entityNasabah.getNoHp());

        // Mapping rekening
        if (entityNasabah.getRekenings() != null) {
            List<DtoRekening> dtoRekenings = entityNasabah.getRekenings()
                    .stream()
                    .map(MapperRekening::toDto) // panggil mapper rekening
                    .collect(Collectors.toList());

            dtoNasabah.setRekenings(dtoRekenings);
        }
        return dtoNasabah;
    }
}

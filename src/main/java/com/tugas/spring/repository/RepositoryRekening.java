package com.tugas.spring.repository;

import com.tugas.spring.entity.EntityRekening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryRekening extends JpaRepository<EntityRekening, String> {

}

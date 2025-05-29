package com.tugas.spring.repository;

import com.tugas.spring.entity.EntityNasabah;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

    public interface RepositoryNasabah extends JpaRepository<EntityNasabah, String>{

    }

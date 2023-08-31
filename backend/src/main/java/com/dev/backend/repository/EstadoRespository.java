package com.dev.backend.repository;

import com.dev.backend.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRespository extends JpaRepository<Estado, Long> {
}

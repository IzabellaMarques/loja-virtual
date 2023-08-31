package com.dev.backend.repository;

import com.dev.backend.entity.Marca;
import com.dev.backend.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
}

package com.dev.backend.repository;

import com.dev.backend.entity.Categoria;
import com.dev.backend.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}

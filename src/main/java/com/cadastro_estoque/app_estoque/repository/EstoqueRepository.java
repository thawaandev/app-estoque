package com.cadastro_estoque.app_estoque.repository;

import com.cadastro_estoque.app_estoque.entity.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}

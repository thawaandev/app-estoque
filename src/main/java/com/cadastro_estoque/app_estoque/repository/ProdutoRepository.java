package com.cadastro_estoque.app_estoque.repository;

import com.cadastro_estoque.app_estoque.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}

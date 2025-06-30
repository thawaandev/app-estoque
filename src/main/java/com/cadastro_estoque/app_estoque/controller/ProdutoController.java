package com.cadastro_estoque.app_estoque.controller;

import com.cadastro_estoque.app_estoque.entity.Produto;
import com.cadastro_estoque.app_estoque.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Void> salvarProduto(@RequestBody Produto produto) {
        produtoService.registrarProduto(produto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(produtoService.buscarProdutoPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProdutoPorId(@PathVariable Long id) {
        produtoService.apagarProduto(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarProdutoPorId(@PathVariable Long id, @RequestBody Produto produto) {
        produtoService.editarProduto(id, produto);
        return ResponseEntity.ok().build();
    }

}

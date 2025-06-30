package com.cadastro_estoque.app_estoque.service;

import com.cadastro_estoque.app_estoque.entity.Produto;
import com.cadastro_estoque.app_estoque.exceptions.RecursoNaoEncontradoException;
import com.cadastro_estoque.app_estoque.repository.ProdutoRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto registrarProduto(Produto produto) {
        return produtoRepository.saveAndFlush(produto);
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id).orElseThrow(
                () -> new RecursoNaoEncontradoException("Produto de ID:"+id+" não encontrado.")
        );
    }

    public void apagarProduto(Long id) {
        if(!produtoRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Produto de ID:"+id+" não encontrado.");
        }
        produtoRepository.deleteById(id);
    }

    public void editarProduto(Long id, Produto produto) {
        Produto produtoEntity =  produtoRepository.findById(id).orElseThrow(
                () -> new RecursoNaoEncontradoException("Produto de ID:"+id+" não encontrado.")
        );
        Produto produtoAtualizado = Produto.builder()
                .nome(produto.getNome() != null ? produto.getNome() : produtoEntity.getNome())
                .preco(produto.getPreco() != null ? produto.getPreco() : produtoEntity.getPreco())
                .id(produtoEntity.getId())
                .build();
        produtoRepository.save(produtoAtualizado);
    }

}

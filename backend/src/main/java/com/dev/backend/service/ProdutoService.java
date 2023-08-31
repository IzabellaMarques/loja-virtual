package com.dev.backend.service;

import com.dev.backend.entity.Produto;
import com.dev.backend.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {

    @Autowired
    private ProdutoRepository respository;

    public List<Produto> buscarTodos() {
        return respository.findAll();
    }

    public Produto inserir(Produto produto) {
        produto.setDataCriacao(new Date());
        return respository.saveAndFlush(produto);
    }

    public Produto alterar(Produto produto) {
        produto.setDataAtualizacao(new Date());
        return respository.saveAndFlush(produto);
    }

    public void excluir(Long id) {
        Produto pessoa = respository.findById(id).get();
        respository.delete(pessoa);
    }
}

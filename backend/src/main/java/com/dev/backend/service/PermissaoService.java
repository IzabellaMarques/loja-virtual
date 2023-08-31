package com.dev.backend.service;

import com.dev.backend.entity.Permissao;
import com.dev.backend.entity.Produto;
import com.dev.backend.repository.PermissaoRepository;
import com.dev.backend.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PermissaoService {

    @Autowired
    private PermissaoRepository respository;

    public List<Permissao> buscarTodos() {
        return respository.findAll();
    }

    public Permissao inserir(Permissao permissao) {
        permissao.setDataCriacao(new Date());
        return respository.saveAndFlush(permissao);
    }

    public Permissao alterar(Permissao permissao) {
        permissao.setDataAtualizacao(new Date());
        return respository.saveAndFlush(permissao);
    }

    public void excluir(Long id) {
        Permissao pessoa = respository.findById(id).get();
        respository.delete(pessoa);
    }
}

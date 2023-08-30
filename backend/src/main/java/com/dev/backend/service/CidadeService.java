package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Cidade;
import com.dev.backend.repository.CidadeRepostory;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepostory respository;

    public List<Cidade> buscarTodos() {
        return respository.findAll();
    }

    public Cidade inserir(Cidade cidade) {
        cidade.setDataCriacao(new Date());
        return respository.saveAndFlush(cidade);
    }

    public Cidade alterar(Cidade cidade) {
        cidade.setDataAtualizacao(new Date());
        return respository.saveAndFlush(cidade);
    }

    public void excluir(Long id) {
        Cidade estado = respository.findById(id).get();
        respository.delete(estado);
    }
}

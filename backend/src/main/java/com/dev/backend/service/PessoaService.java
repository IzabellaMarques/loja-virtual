package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import com.dev.backend.entity.Pessoa;
import com.dev.backend.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Cidade;
import com.dev.backend.repository.CidadeRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository respository;

    public List<Pessoa> buscarTodos() {
        return respository.findAll();
    }

    public Pessoa inserir(Pessoa pessoa) {
        pessoa.setDataCriacao(new Date());
        return respository.saveAndFlush(pessoa);
    }

    public Pessoa alterar(Pessoa pessoa) {
        pessoa.setDataAtualizacao(new Date());
        return respository.saveAndFlush(pessoa);
    }

    public void excluir(Long id) {
        Pessoa pessoa = respository.findById(id).get();
        respository.delete(pessoa);
    }
}

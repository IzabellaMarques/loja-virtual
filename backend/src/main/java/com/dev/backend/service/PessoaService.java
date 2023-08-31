package com.dev.backend.service;

import com.dev.backend.entity.Pessoa;
import com.dev.backend.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
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

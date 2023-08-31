package com.dev.backend.service;

import com.dev.backend.entity.Estado;
import com.dev.backend.repository.EstadoRespository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class EstadoService {

    @Autowired
    private EstadoRespository respository;

    public List<Estado> buscarTodos() {
        return respository.findAll();
    }

    public Estado inserir(Estado estado) {
        estado.setDataCriacao(new Date());
        return respository.saveAndFlush(estado);
    }

    public Estado alterar(Estado estado) {
        estado.setDataAtualizacao(new Date());
        return respository.saveAndFlush(estado);
    }

    public void excluir(Long id) {
        Estado estado = respository.findById(id).get();
        respository.delete(estado);
    }
}

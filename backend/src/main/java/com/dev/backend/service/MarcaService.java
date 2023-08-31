package com.dev.backend.service;

import com.dev.backend.entity.Marca;
import com.dev.backend.repository.MarcaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class MarcaService {

    @Autowired
    private MarcaRepository respository;

    public List<Marca> buscarTodos() {
        return respository.findAll();
    }

    public Marca inserir(Marca marca) {
        marca.setDataCriacao(new Date());
        return respository.saveAndFlush(marca);
    }

    public Marca alterar(Marca marca) {
        marca.setDataAtualizacao(new Date());
        return respository.saveAndFlush(marca);
    }

    public void excluir(Long id) {
        Marca marca = respository.findById(id).get();
        respository.delete(marca);
    }
}

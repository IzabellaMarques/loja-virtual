package com.dev.backend.service;

import com.dev.backend.dto.PessoaClienteRequestDTO;
import com.dev.backend.entity.Pessoa;
import com.dev.backend.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class PessoaClienteService {

    @Autowired
    private PessoaRepository respository;

    @Autowired
    private PermissaoPessoaService permissaoPessoaService;

    public Pessoa registrar(PessoaClienteRequestDTO pessoaClienteRequestDTO) {
        var pessoa =  new PessoaClienteRequestDTO().mapper(pessoaClienteRequestDTO);
        pessoa.setDataCriacao(new Date());

        Pessoa pessoaBd = respository.saveAndFlush(pessoa);
        permissaoPessoaService.vinclularPessoaPermissaoCliente(pessoaBd);

        return pessoaBd;
    }
}

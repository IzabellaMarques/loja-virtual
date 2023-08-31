package com.dev.backend.service;

import com.dev.backend.entity.Permissao;
import com.dev.backend.entity.PermissaoPessoa;
import com.dev.backend.entity.Pessoa;
import com.dev.backend.repository.PermissaoPessoaRepository;
import com.dev.backend.repository.PermissaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PermissaoPessoaService {

    @Autowired
    private PermissaoPessoaRepository respository;

    @Autowired
    private PermissaoRepository permissaoRepository;

    public void vinclularPessoaPermissaoCliente(Pessoa pessoa) {
        List<Permissao> listaPermissao = permissaoRepository.findByNome("cliente");

        if (listaPermissao.size() > 0){
            PermissaoPessoa permissaoPessoa =  new PermissaoPessoa();
            permissaoPessoa.setPessoa(pessoa);
            permissaoPessoa.setPermissao(listaPermissao.get(0));
            permissaoPessoa.setDataCriacao(new Date());
            respository.saveAndFlush(permissaoPessoa);
        }
    }

}

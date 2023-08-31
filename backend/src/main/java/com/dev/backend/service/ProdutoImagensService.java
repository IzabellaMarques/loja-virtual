package com.dev.backend.service;

import com.dev.backend.entity.Produto;
import com.dev.backend.entity.ProdutoImagens;
import com.dev.backend.repository.ProdutoImagensRepository;
import com.dev.backend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Service
public class ProdutoImagensService {

    @Autowired
    private ProdutoImagensRepository repository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoImagens> buscarTodos() {
        return repository.findAll();
    }

    public ProdutoImagens inserir(Long idProduto, MultipartFile file) {
        Produto produto = produtoRepository.findById(idProduto).get();
        ProdutoImagens imagens = new ProdutoImagens();

        try {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String nomeImagem = produto.getId() + file.getOriginalFilename();
                Path caminho = Paths
                        .get("c:/imagens/" +nomeImagem );
                Files.write(caminho, bytes);
                imagens.setNome(nomeImagem);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        imagens.setProduto(produto);
        imagens.setDataCriacao(new Date());
        imagens = repository.saveAndFlush(imagens);
        return imagens;
    }

    public ProdutoImagens alterar(ProdutoImagens objeto) {
        objeto.setDataAtualizacao(new Date());
        return repository.saveAndFlush(objeto);
    }

    public void excluir(Long id) {
        ProdutoImagens objeto = repository.findById(id).get();
        repository.delete(objeto);
    }
}

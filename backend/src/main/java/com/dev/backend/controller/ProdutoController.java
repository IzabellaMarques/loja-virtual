package com.dev.backend.controller;

import com.dev.backend.entity.Pessoa;
import com.dev.backend.entity.Produto;
import com.dev.backend.service.PessoaService;
import com.dev.backend.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping("/")
    public List<Produto> buscarTodos() {
        return service.buscarTodos();
    }

    @PostMapping("/")
    public Produto inserir(@RequestBody Produto produto) {
        return service.inserir(produto);
    }

    @PutMapping("/")
    public Produto alterar(@RequestBody Produto produto) {
        return service.alterar(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        service.excluir(id);
        return ResponseEntity.ok().build();
    }
}

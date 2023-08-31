package com.dev.backend.controller;

import com.dev.backend.entity.Marca;
import com.dev.backend.service.MarcaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marca")
@AllArgsConstructor
public class MarcaController {

    @Autowired
    private MarcaService service;

    @GetMapping("/")
    public List<Marca> buscarTodos() {
        return service.buscarTodos();
    }

    @PostMapping("/")
    public Marca inserir(@RequestBody Marca marca) {
        return service.inserir(marca);
    }

    @PutMapping("/")
    public Marca alterar(@RequestBody Marca marca) {
        return service.alterar(marca);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        service.excluir(id);
        return ResponseEntity.ok().build();
    }
}

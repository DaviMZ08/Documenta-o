package com.treino.treinamento.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/salvar")
    public Categoria salvar(@RequestBody Categoria categoria) { return categoriaService.cadastrarCategoria(categoria); }

    @GetMapping("/listar")
    public List<Categoria> listar() { return categoriaService.listarCategorias(); }

    @GetMapping("/buscar/{id}")
    public Categoria buscar(@PathVariable Integer id) { return categoriaService.buscarCategoria(id); }

    @PutMapping("/atualizar/{id}")
    public Categoria atualizar(@PathVariable Integer id, @RequestBody Categoria categoria) { return categoriaService.atualizarCategoria(id, categoria); }

    @DeleteMapping("/deletar/{id}")
    public String deletar(@PathVariable Integer id) {
        return categoriaService.deletarCategoria(id) ? "Deletada com sucesso!" : "Não encontrada.";
    }
}

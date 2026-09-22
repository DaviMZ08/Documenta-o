package com.treino.treinamento.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/salvar")
    public Produto salvar(@RequestBody Produto produto) { return produtoService.cadastrarProduto(produto); }

    @GetMapping("/listar")
    public List<Produto> listar() { return produtoService.listarProdutos(); }

    @GetMapping("/buscar/{id}")
    public Produto buscar(@PathVariable Integer id) { return produtoService.buscarProduto(id); }

    @PutMapping("/atualizar/{id}")
    public Produto atualizar(@PathVariable Integer id, @RequestBody Produto produto) { return produtoService.atualizarProduto(id, produto); }

    @DeleteMapping("/deletar/{id}")
    public String deletar(@PathVariable Integer id) {
        return produtoService.deletarProduto(id) ? "Deletado com sucesso!" : "Não encontrado.";
    }
}

package com.treino.treinamento.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.treino.treinamento.models.Produto;
import com.treino.treinamento.repositories.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto cadastrarProduto(Produto produto) { return produtoRepository.save(produto); }
    public List<Produto> listarProdutos() { return produtoRepository.findAll(); }
    public Produto buscarProduto(Integer id) { return produtoRepository.findById(id).orElse(null); }
    
    public Boolean deletarProduto(Integer id) {
        if(produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Produto atualizarProduto(Integer id, Produto produto) {
        Produto prodRecuperado = buscarProduto(id);
        if(prodRecuperado != null) {
            prodRecuperado.setId(id);
            if(produto.getNome() != null) prodRecuperado.setNome(produto.getNome());
            if(produto.getPreco() != null) prodRecuperado.setPreco(produto.getPreco());
            if(produto.getCategoria() != null) prodRecuperado.setCategoria(produto.getCategoria());
            return produtoRepository.save(prodRecuperado);
        }
        return null;
    }
}
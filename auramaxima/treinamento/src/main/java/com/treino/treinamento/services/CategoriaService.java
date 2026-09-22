package com.treino.treinamento.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.treino.treinamento.services.models.Categoria;
import com.treino.treinamento.services.repositories.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria cadastrarCategoria(Categoria categoria) { return categoriaRepository.save(categoria); }
    public List<Categoria> listarCategorias() { return categoriaRepository.findAll(); }
    public Categoria buscarCategoria(Integer id) { return categoriaRepository.findById(id).orElse(null); }
    
    public Boolean deletarCategoria(Integer id) {
        if(categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Categoria atualizarCategoria(Integer id, Categoria categoria) {
        Categoria catRecuperada = buscarCategoria(id);
        if(catRecuperada != null) {
            catRecuperada.setId(id);
            if(categoria.getNome() != null) catRecuperada.setNome(categoria.getNome());
            return categoriaRepository.save(catRecuperada);
        }
        return null;
    }
}

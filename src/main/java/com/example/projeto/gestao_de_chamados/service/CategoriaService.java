package com.example.projeto.gestao_de_chamados.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.projeto.gestao_de_chamados.entity.Categoria;
import com.example.projeto.gestao_de_chamados.repository.CategoriaRepository;

@Service 
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria>listaCategorias(){
        return categoriaRepository.findAll();
    }

    public Categoria buscarCategoria(Long id){
        return categoriaRepository.findById(id).get();
    }

    public Categoria inserirCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }
}

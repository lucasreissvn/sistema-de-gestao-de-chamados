package com.example.projeto.gestao_de_chamados.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.projeto.gestao_de_chamados.dto.CategoriaCreateDTO;
import com.example.projeto.gestao_de_chamados.dto.CategoriaResponseDTO;
import com.example.projeto.gestao_de_chamados.entity.Categoria;
import com.example.projeto.gestao_de_chamados.repository.CategoriaRepository;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<CategoriaResponseDTO> listaCategorias() {
        return categoriaRepository.findAll()
                .stream()
                .map(categoria -> new CategoriaResponseDTO(
                        categoria.getId(),
                        categoria.getNome()))
                .toList();
    }

    public CategoriaResponseDTO buscarCategoria(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não existe"));
        return new CategoriaResponseDTO(categoria.getId(), categoria.getNome());
    }

    public CategoriaResponseDTO inserirCategoria(CategoriaCreateDTO categoriaCreateDTO) {
        Categoria categoria = new Categoria();
        categoria.setNome(categoriaCreateDTO.nome());
        Categoria categoriaSalvo = categoriaRepository.save(categoria);

        return new CategoriaResponseDTO(categoriaSalvo.getId(), categoriaSalvo.getNome());
    }

    public CategoriaResponseDTO atualizarCategoria(Long id, CategoriaCreateDTO categoriaCreateDTO) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não existe"));
        categoria.setNome(categoriaCreateDTO.nome());
        Categoria categoriaSalvo = categoriaRepository.save(categoria);
        return new CategoriaResponseDTO(categoriaSalvo.getId(), categoriaSalvo.getNome());
    }

    public void deletarCategoria(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não existe"));
        categoriaRepository.delete(categoria);
    }
}

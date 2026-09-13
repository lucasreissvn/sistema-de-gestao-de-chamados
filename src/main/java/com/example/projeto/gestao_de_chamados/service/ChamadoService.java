package com.example.projeto.gestao_de_chamados.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.projeto.gestao_de_chamados.dto.ChamadoCreateDTO;
import com.example.projeto.gestao_de_chamados.dto.ChamadoResponseDTO;
import com.example.projeto.gestao_de_chamados.entity.Categoria;
import com.example.projeto.gestao_de_chamados.entity.Chamado;
import com.example.projeto.gestao_de_chamados.enums.StatusChamado;
import com.example.projeto.gestao_de_chamados.exception.CategoriaNotFoundException;
import com.example.projeto.gestao_de_chamados.exception.ChamadoNotFoundException;
import com.example.projeto.gestao_de_chamados.repository.CategoriaRepository;
import com.example.projeto.gestao_de_chamados.repository.ChamadoRepository;

@Service
public class ChamadoService {
    private final ChamadoRepository chamadoRepository;
    private final CategoriaRepository categoriaRepository;

    public ChamadoService(ChamadoRepository chamadoRepository, CategoriaRepository categoriaRepository) {
        this.chamadoRepository = chamadoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public List<ChamadoResponseDTO> listarChamado() {
        return chamadoRepository.findAll()
                .stream()
                .map(chamado -> new ChamadoResponseDTO(
                        chamado.getId(),
                        chamado.getTitulo(),
                        chamado.getDescricao(),
                        chamado.getStatus(),
                        chamado.getPrioridade(),
                        chamado.getDataAbertura(),
                        chamado.getDataAtualizacao(),
                        chamado.getUsuarioSolicitante() != null ? chamado.getUsuarioSolicitante().getId() : null,
                        chamado.getAtendente() != null ? chamado.getAtendente().getId() : null,
                        chamado.getCategoria().getId()))
                .toList();
    }

    public ChamadoResponseDTO buscarChamado(Long id) {
        Chamado chamado = chamadoRepository.findById(id)
                .orElseThrow(() -> new ChamadoNotFoundException("Chamado não existe"));
        return new ChamadoResponseDTO(
                chamado.getId(),
                chamado.getTitulo(),
                chamado.getDescricao(),
                chamado.getStatus(),
                chamado.getPrioridade(),
                chamado.getDataAbertura(),
                chamado.getDataAtualizacao(),
                chamado.getUsuarioSolicitante() != null ? chamado.getUsuarioSolicitante().getId() : null,
                chamado.getAtendente() != null ? chamado.getAtendente().getId() : null,
                chamado.getCategoria().getId());
    }

    public ChamadoResponseDTO inserirChamado(ChamadoCreateDTO chamadoCreateDTO) {
        Chamado chamado = new Chamado();
        chamado.setTitulo(chamadoCreateDTO.titulo());
        chamado.setDescricao(chamadoCreateDTO.descricao());
        chamado.setPrioridade(chamadoCreateDTO.prioridade());
        chamado.setStatus(StatusChamado.ABERTO);
        chamado.setDataAbertura(LocalDateTime.now());

        Categoria categoria = categoriaRepository.findById(chamadoCreateDTO.categoriaId())
                .orElseThrow(() -> new CategoriaNotFoundException("Categoria não existe"));
        chamado.setCategoria(categoria);

        Chamado chamadoSalvo = chamadoRepository.save(chamado);

        return new ChamadoResponseDTO(
                chamadoSalvo.getId(),
                chamadoSalvo.getTitulo(),
                chamadoSalvo.getDescricao(),
                chamadoSalvo.getStatus(),
                chamadoSalvo.getPrioridade(),
                chamadoSalvo.getDataAbertura(),
                chamadoSalvo.getDataAtualizacao(),
                chamadoSalvo.getUsuarioSolicitante() != null ? chamadoSalvo.getUsuarioSolicitante().getId() : null,
                chamadoSalvo.getAtendente() != null ? chamadoSalvo.getAtendente().getId() : null,
                chamadoSalvo.getCategoria().getId());

    }

    public ChamadoResponseDTO atualizarChamado(Long id, ChamadoCreateDTO chamadoCreateDTO) {
        Chamado chamado = chamadoRepository.findById(id)
                .orElseThrow(() -> new ChamadoNotFoundException("Chamado não existe"));
        chamado.setTitulo(chamadoCreateDTO.titulo());
        chamado.setDescricao(chamadoCreateDTO.descricao());
        chamado.setPrioridade(chamadoCreateDTO.prioridade());

        Categoria categoria = categoriaRepository.findById(chamadoCreateDTO.categoriaId())
                .orElseThrow(() -> new CategoriaNotFoundException("Categoria não existe"));
        chamado.setCategoria(categoria);

        chamado.setDataAtualizacao(LocalDateTime.now());

        Chamado chamadoSalvo = chamadoRepository.save(chamado);

        return new ChamadoResponseDTO(
                chamadoSalvo.getId(),
                chamadoSalvo.getTitulo(),
                chamadoSalvo.getDescricao(),
                chamadoSalvo.getStatus(),
                chamadoSalvo.getPrioridade(),
                chamadoSalvo.getDataAbertura(),
                chamadoSalvo.getDataAtualizacao(),
                chamadoSalvo.getUsuarioSolicitante() != null ? chamadoSalvo.getUsuarioSolicitante().getId() : null,
                chamadoSalvo.getAtendente() != null ? chamadoSalvo.getAtendente().getId() : null,
                chamadoSalvo.getCategoria().getId());
    }

    public void deletarChamado(Long id) {
        Chamado chamado = chamadoRepository.findById(id)
                .orElseThrow(() -> new ChamadoNotFoundException("Chamado não existe"));
        chamadoRepository.delete(chamado);
    }
}

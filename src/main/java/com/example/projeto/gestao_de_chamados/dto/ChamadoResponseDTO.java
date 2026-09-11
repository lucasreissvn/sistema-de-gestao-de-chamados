package com.example.projeto.gestao_de_chamados.dto;

import java.time.LocalDateTime;

import com.example.projeto.gestao_de_chamados.enums.Prioridade;
import com.example.projeto.gestao_de_chamados.enums.StatusChamado;

public record ChamadoResponseDTO(
    Long id,
    String titulo,
    String descricao,
    StatusChamado status,
    Prioridade prioridade,
    LocalDateTime dataAbertura,
    LocalDateTime dataAtualizacao,
    Long usuarioSolicitanteId,
    Long usuarioAtendenteId,
    Long categoriaId
) {}

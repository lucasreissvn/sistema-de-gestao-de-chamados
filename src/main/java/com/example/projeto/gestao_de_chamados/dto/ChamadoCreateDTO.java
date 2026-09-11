package com.example.projeto.gestao_de_chamados.dto;

import com.example.projeto.gestao_de_chamados.enums.Prioridade;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ChamadoCreateDTO(
    @NotBlank String titulo,
    @NotBlank String descricao,
    @NotNull Prioridade prioridade,
    @NotNull Long categoriaId
) {}

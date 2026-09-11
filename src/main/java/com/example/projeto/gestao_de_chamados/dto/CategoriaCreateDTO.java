package com.example.projeto.gestao_de_chamados.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoriaCreateDTO(
    @NotBlank String nome
) {}

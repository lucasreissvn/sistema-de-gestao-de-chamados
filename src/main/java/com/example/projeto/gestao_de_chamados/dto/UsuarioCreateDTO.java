package com.example.projeto.gestao_de_chamados.dto;

import com.example.projeto.gestao_de_chamados.enums.Role;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioCreateDTO(
    @NotBlank String nome,
    @NotBlank String email,
    @NotBlank String senha,
    @NotNull Role role
){}


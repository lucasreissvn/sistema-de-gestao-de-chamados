package com.example.projeto.gestao_de_chamados.dto;

import com.example.projeto.gestao_de_chamados.enums.Role;

public record UsuarioResponseDTO(
    Long id,
    String nome,
    String email,
    Role role
){}

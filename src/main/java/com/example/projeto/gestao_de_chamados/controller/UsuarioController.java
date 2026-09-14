package com.example.projeto.gestao_de_chamados.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projeto.gestao_de_chamados.dto.UsuarioCreateDTO;
import com.example.projeto.gestao_de_chamados.dto.UsuarioResponseDTO;
import com.example.projeto.gestao_de_chamados.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarUsuario() {
        List<UsuarioResponseDTO> list = usuarioService.listarUsuario();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscarUsuario(@PathVariable Long id) {
        UsuarioResponseDTO usuario = usuarioService.buscarUsuario(id);
        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> inserirUsuario(@Valid @RequestBody UsuarioCreateDTO usuarioCreateDTO) {
        UsuarioResponseDTO usuario = usuarioService.inserirUsuario(usuarioCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> atualizarUsuario(@PathVariable Long id,
            @Valid @RequestBody UsuarioCreateDTO usuarioCreateDTO) {
        UsuarioResponseDTO usuario = usuarioService.atualizarUsuario(id, usuarioCreateDTO);
        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

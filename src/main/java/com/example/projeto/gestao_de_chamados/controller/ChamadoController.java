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

import com.example.projeto.gestao_de_chamados.dto.ChamadoCreateDTO;
import com.example.projeto.gestao_de_chamados.dto.ChamadoResponseDTO;
import com.example.projeto.gestao_de_chamados.service.ChamadoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/chamados")
public class ChamadoController {

    private final ChamadoService chamadoService;

    public ChamadoController(ChamadoService chamadoService) {
        this.chamadoService = chamadoService;
    }

    @GetMapping
    public ResponseEntity<List<ChamadoResponseDTO>> listarChamado() {
        List<ChamadoResponseDTO> list = chamadoService.listarChamado();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChamadoResponseDTO> buscarChamado(@PathVariable Long id) {
        ChamadoResponseDTO chamado = chamadoService.buscarChamado(id);
        return ResponseEntity.status(HttpStatus.OK).body(chamado);
    }

    @PostMapping
    public ResponseEntity<ChamadoResponseDTO> inserirChamado(@Valid @RequestBody ChamadoCreateDTO chamadoCreateDTO) {
        ChamadoResponseDTO chamado = chamadoService.inserirChamado(chamadoCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(chamado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChamadoResponseDTO> atualizarChamado(@PathVariable Long id,
            @Valid @RequestBody ChamadoCreateDTO chamadoCreateDTO) {
        ChamadoResponseDTO chamado = chamadoService.atualizarChamado(id, chamadoCreateDTO);
        return ResponseEntity.status(HttpStatus.OK).body(chamado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarChamado(@PathVariable Long id) {
        chamadoService.deletarChamado(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

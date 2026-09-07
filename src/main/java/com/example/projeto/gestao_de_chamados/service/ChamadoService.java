package com.example.projeto.gestao_de_chamados.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.projeto.gestao_de_chamados.entity.Chamado;
import com.example.projeto.gestao_de_chamados.repository.ChamadoRepository;

@Service
public class ChamadoService {
    private final ChamadoRepository chamadoRepository;

    public ChamadoService(ChamadoRepository chamadoRepository) {
        this.chamadoRepository = chamadoRepository;
    }

    public List<Chamado> listarChamado(){
        return chamadoRepository.findAll();
    }

    public Chamado buscarChamado(Long id){
        return chamadoRepository.findById(id).get();
    }

    public Chamado inserirChamado(Chamado chamado){
        return chamadoRepository.save(chamado);
    }

    public Chamado atualizarChamado(Chamado chamado){
       return chamadoRepository.save(chamado);
    }

    public void deletarChamado(Long id){
        chamadoRepository.deleteById(id);
    }
}

package com.example.projeto.gestao_de_chamados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projeto.gestao_de_chamados.entity.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado,Long> {

}

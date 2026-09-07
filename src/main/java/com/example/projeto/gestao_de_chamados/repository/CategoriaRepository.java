package com.example.projeto.gestao_de_chamados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projeto.gestao_de_chamados.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria,Long>{

}

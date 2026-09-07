package com.example.projeto.gestao_de_chamados.entity;

import java.time.LocalDateTime;

import com.example.projeto.gestao_de_chamados.enums.Prioridade;
import com.example.projeto.gestao_de_chamados.enums.StatusChamado;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table (name = "tb_chamado")
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    @Enumerated (EnumType.STRING)
    private StatusChamado status;
    @Enumerated (EnumType.STRING)
    private Prioridade prioridade;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataAtualizacao;
    @ManyToOne
    @JoinColumn (name="usuario_id_solicitante")
    private Usuario usuarioSolicitante;
    @ManyToOne
    @JoinColumn (name="usuario_id_atendente")
    private Usuario atendente;
    @ManyToOne
    @JoinColumn (name = "categoria_id")
    private Categoria categoria;

    public Chamado(){}

    public Chamado(Long id, String titulo, String descricao, StatusChamado status, Prioridade prioridade,
            LocalDateTime dataAbertura, LocalDateTime dataAtualizacao, Usuario usuarioSolicitante, Usuario atendente,
            Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.prioridade = prioridade;
        this.dataAbertura = dataAbertura;
        this.dataAtualizacao = dataAtualizacao;
        this.usuarioSolicitante = usuarioSolicitante;
        this.atendente = atendente;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusChamado getStatus() {
        return status;
    }

    public void setStatus(StatusChamado status) {
        this.status = status;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Usuario getUsuarioSolicitante() {
        return usuarioSolicitante;
    }

    public void setUsuarioSolicitante(Usuario usuarioSolicitante) {
        this.usuarioSolicitante = usuarioSolicitante;
    }

    public Usuario getAtendente() {
        return atendente;
    }

    public void setAtendente(Usuario atendente) {
        this.atendente = atendente;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    

}

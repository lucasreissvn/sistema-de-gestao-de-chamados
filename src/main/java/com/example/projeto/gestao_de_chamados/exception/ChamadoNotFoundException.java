package com.example.projeto.gestao_de_chamados.exception;

public class ChamadoNotFoundException extends RuntimeException{
    public ChamadoNotFoundException(String msg){
        super(msg);
    }
}

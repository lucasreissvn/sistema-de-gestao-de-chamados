package com.example.projeto.gestao_de_chamados.exception;

public class UsuarioNotFoundException extends RuntimeException{
    public UsuarioNotFoundException(String msg){
        super(msg);
    }
}

package com.example.projeto.gestao_de_chamados.exception;

public class CategoriaNotFoundException extends  RuntimeException{
    public CategoriaNotFoundException(String msg){
        super(msg);
    }
}

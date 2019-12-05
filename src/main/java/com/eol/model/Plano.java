package com.eol.model;

public enum Plano {

    MONO("Monofasico"),
    BI("Bifasico"),
    TRI("Trifasico");

    private String nome;

    Plano(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }
}

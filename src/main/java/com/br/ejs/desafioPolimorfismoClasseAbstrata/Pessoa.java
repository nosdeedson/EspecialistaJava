package com.br.ejs.desafioPolimorfismoClasseAbstrata;

public abstract class Pessoa {

    private String nome;

    public Pessoa() {
    }

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public abstract double calcularImpostos();
}

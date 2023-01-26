package com.br.ejs.generics.desafio;

import jdk.net.ExtendedSocketOptions;

public class GerenciadorEstoque<T extends Estocavel> {

    private int quantidadeTotal;

    public void adicionar(T estocavel){
        this.quantidadeTotal += estocavel.getQuantidadeEstoque();
    }

    public int getQuantidadeTotal(){
        return this.quantidadeTotal;
    }
}

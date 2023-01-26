package com.br.ejs.generics.interfaceGenerics;

public class Produto {
    private String descricao;

    public Produto(){}

    public Produto(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "descricao='" + descricao + '\'' +
                '}';
    }
}

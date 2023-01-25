package com.br.ejs.generics.classGeneric;

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
}

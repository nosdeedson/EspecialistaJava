package com.br.ejs.generics.desafio;

public class Roupa implements Estocavel{

    private String descricao;

    private int quantidadeEstoque;

    public Roupa(String descricao, int quantidadeEstoque) {
        this.descricao = descricao;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    @Override
    public int getQuantidadeEstoque() {
        return this.quantidadeEstoque;
    }
}

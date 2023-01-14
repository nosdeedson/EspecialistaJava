package com.br.ejs.model;

public class ItemCardapio {

    private String descricao;
    private double preco;

    public ItemCardapio(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "ItemCardapio{" +
                "descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}

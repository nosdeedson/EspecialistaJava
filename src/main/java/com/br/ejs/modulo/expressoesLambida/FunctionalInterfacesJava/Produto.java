package com.br.ejs.modulo.expressoesLambida.FunctionalInterfacesJava;

import java.math.BigDecimal;
import java.util.Objects;

public class Produto {

    public enum  Status{
        ATIVO, INATIVO
    }

    private String nome;
    private BigDecimal preco;
    private int quantidade;
    private  Status status = Status.ATIVO;

    public Produto(String nome) {
        this.nome = nome;
    }

    public Produto(String nome, BigDecimal preco, int quantidade) {
        this(nome);
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Produto(String nome, BigDecimal preco, int quantidade, Status status) {
        this(nome, preco, quantidade);
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Status getStatus() {
        return status;
    }

    public void inativar(){
        status = Status.INATIVO;
    }

    public void ativar() {
        status = Status.ATIVO;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(nome, produto.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                ", status=" + status +
                '}';
    }
}

package com.br.ejs.apiStream.estoque;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Produto implements Comparable<Produto> {

    @Override
    public int compareTo(Produto produto) {
        // comparing names the return will be -1 to smaller 0 to equal and 1 to bigger
        return this.getNome().compareTo(produto.getNome());
    }

    public enum Status{
        ATIVO, INATIVO
    }

    private String nome;
    private BigDecimal preco;
    private int quantidade;
    private Status status = Status.ATIVO;
    private final Fabricante fabricante;
    private final Set<Categoria> categorias = new HashSet<>();

    public Produto(String nome, BigDecimal preco, int quantidade,
                   Fabricante fabricante, Categoria... categorias) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.status = status;
        this.fabricante = fabricante;
        this.categorias.addAll(Set.of(categorias));
    }

    public Produto(String nome, BigDecimal preco, int quantidade,
                   Fabricante fabricante, Status status, Categoria... categorias) {
        this(nome, preco, quantidade, fabricante, categorias);
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

    public Fabricante getFabricante() {
        return fabricante;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    public void inativar(){
        this.status = Status.INATIVO;
    }

    public void ativar(){
        this.status = Status.ATIVO;
    }

    public boolean isInativo(){
        return Status.INATIVO.equals(this.status);
    }

    public void adicionarCategoria(Categoria categoria){
        this.categorias.add(categoria);
    }

    public void removerCategoria(Categoria categoria){
        this.categorias.remove(categoria);
    }

    public boolean temEstoque(){
        return getQuantidade() > 0;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                ", status=" + status +
                ", fabricante=" + fabricante +
                ", categorias=" + categorias +
                '}';
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
}

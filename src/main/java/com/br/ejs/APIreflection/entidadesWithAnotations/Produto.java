package com.br.ejs.APIreflection.entidadesWithAnotations;

import com.br.ejs.APIreflection.geradorCSV.Campo;

import java.math.BigDecimal;

public class Produto {

    private final Long codigo;
    @Campo
    private final String nome;
    @Campo
    private String descricao;
    @Campo
    private BigDecimal precoUnitario;
    @Campo
    private Integer quantidadeEstoque;

    public Produto(Long codigo, String nome, String descricao, BigDecimal precoUnitario, Integer quantidadeEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
}

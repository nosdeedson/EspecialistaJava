package com.br.ejs.desafioConstrutores;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Participante {

    static  final int SALDO_PONTOS_INICIAL = 0;

    private String nome;
    private int saldoDePontos;

    Participante(String nome){
        this(nome, SALDO_PONTOS_INICIAL);
    }

    Participante(String nome, int saldoDePontosInicial){
        Objects.requireNonNull(nome, "Nome não poder ser nulo.");
        if(!StringUtils.isNotEmpty(nome)){
            throw  new IllegalArgumentException("Nome não pode ser nulo");
        }
        Objects.requireNonNull(Integer.valueOf(saldoDePontos), "Não pode ser nulo.");

        this.nome = nome;
        this.saldoDePontos = saldoDePontosInicial;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "nome='" + nome + '\'' +
                ", saldoDePontos=" + saldoDePontos +
                '}';
    }
}

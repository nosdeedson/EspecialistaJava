package com.br.ejs.desafioPolimorfismoClasseAbstrata;

public class GestorDeImpostos {

    private double valorTotalImpostos;

    public void adicionar(Pessoa pessoa){
        valorTotalImpostos += pessoa.calcularImpostos();
    }

    public double getValorTotalImpostos() {
        return valorTotalImpostos;
    }
}

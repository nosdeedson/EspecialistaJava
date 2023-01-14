package com.br.ejs.desafioPolimorfismoClasseAbstrata;

public abstract class PessoaJuridica extends Pessoa {

    private double faturamentoAnual;

    private double despesaAnual;

    public PessoaJuridica(String nome, double faturamentoAnual, double despesaAnual) {
        super(nome);
        this.faturamentoAnual = faturamentoAnual;
        this.despesaAnual = despesaAnual;
    }

    public double lucroAnual(){
        return this.faturamentoAnual - this.despesaAnual;
    }

    public double getFaturamentoAnual() {
        return faturamentoAnual;
    }

    public double getDespesaAnual() {
        return despesaAnual;
    }
}

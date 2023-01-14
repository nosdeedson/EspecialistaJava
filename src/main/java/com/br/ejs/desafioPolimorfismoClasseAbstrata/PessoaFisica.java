package com.br.ejs.desafioPolimorfismoClasseAbstrata;

public class PessoaFisica extends Pessoa{

    public double RECEITA_ANUAL_ISENCAO = 50000;

    public double ALIQUOTA_IMPOSTO_RENDA = 0.2;

    private double receitaAnual;

    public PessoaFisica (){}

    public PessoaFisica(String nome, double receitaAnual) {
        super(nome);
        this.receitaAnual = receitaAnual;
    }

    @Override
    public double calcularImpostos() {
        double imposto = 0;
        if(this.receitaAnual > RECEITA_ANUAL_ISENCAO){
            imposto = this.receitaAnual * ALIQUOTA_IMPOSTO_RENDA;
        }
        System.out.println("Pagador: " + this.getNome());
        System.out.println("Saldo devedor: " + imposto);
        System.out.println("##############################################\n");
        return imposto;
    }

    public double getReceitaAnual() {
        return receitaAnual;
    }
}

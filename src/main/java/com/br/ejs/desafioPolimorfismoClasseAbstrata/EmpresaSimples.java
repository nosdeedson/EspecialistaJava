package com.br.ejs.desafioPolimorfismoClasseAbstrata;

public class EmpresaSimples extends PessoaJuridica{

    private double ALIQUOTA_IMPOSTO_FATURAMENTO = 0.06;

    public EmpresaSimples(String nome, double faturamentoAnual, double despesaAnual) {
        super(nome, faturamentoAnual, despesaAnual);
    }

    @Override
    public double calcularImpostos() {
        double imposto = this.getFaturamentoAnual() * this.ALIQUOTA_IMPOSTO_FATURAMENTO;
        System.out.println("Pagador: " + this.getNome());
        System.out.println("Saldo devedor: " + imposto);
        System.out.println("##############################################\n");
        return imposto;
    }
}

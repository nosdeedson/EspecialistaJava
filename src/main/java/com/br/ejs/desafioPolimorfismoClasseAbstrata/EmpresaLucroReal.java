package com.br.ejs.desafioPolimorfismoClasseAbstrata;

public class EmpresaLucroReal extends PessoaJuridica{

    private double ALIQUOTA_IMPOSTO_LUCRO = 0.25;

    public EmpresaLucroReal(String nome, double faturamentoAnual, double despesaAnual) {
        super(nome, faturamentoAnual, despesaAnual);
    }

    @Override
    public double calcularImpostos() {
        double imposto = this.getFaturamentoAnual() * this.ALIQUOTA_IMPOSTO_LUCRO;
        System.out.println("Pagador: " + this.getNome());
        System.out.println("Saldo devedor: " + imposto);
        System.out.println("##############################################\n");
        return imposto;
    }
}

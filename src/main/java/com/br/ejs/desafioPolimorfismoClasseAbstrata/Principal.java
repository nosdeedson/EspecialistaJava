package com.br.ejs.desafioPolimorfismoClasseAbstrata;

public class Principal {

    public static void main(String[] args) {
        PessoaFisica pf = new PessoaFisica("jose", 65000);
        PessoaFisica pf2 = new PessoaFisica("joão", 50000);

        PessoaJuridica pj = new EmpresaLucroReal("bar do jose", 50000, 25000);
        PessoaJuridica pj2 = new EmpresaSimples("papelaria", 30000, 15000);

        GestorDeImpostos gestorDeImpostos = new GestorDeImpostos();
        gestorDeImpostos.adicionar(pf);
        gestorDeImpostos.adicionar(pf2);
        gestorDeImpostos.adicionar(pj);
        gestorDeImpostos.adicionar(pj2);


        System.out.println("Impostos a receber: " + gestorDeImpostos.getValorTotalImpostos());

    }
}

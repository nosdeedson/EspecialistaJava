package com.br.ejs.desafioInterfaces;

public class ServicoPropostaSegura {

    public void emitir(BemSeguravel bem){
        System.out.println("_______Calculando valor prêmio________");
        String proposta = bem.descrever() + " Terá o seguinte seguro " + bem.calcularValorPremio();
        System.out.println(proposta);
        System.out.println("_______Prêmio calculado__________");
    }
}

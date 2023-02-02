package com.br.ejs.collections;

import java.util.List;

public class Principal {

    public static void main(String[] args) {

        CadastroPacoreViagem cadastro = new CadastroPacoreViagem();
        cadastro.adicionar("Istambul e Capadócia (20 noites)", 18_000);
        cadastro.adicionar("Neve em Bariloche (10 noites)", 11_000);
        cadastro.adicionar("Neve em Bariloche (5 noites)", 11_000);
        cadastro.adicionar("Neve em Bariloche (7 noites)", 11_000);

        cadastro.adicionar("Disney (10 noites)", 20_000);
        cadastro.adicionar("Natal Luz em Gramado (5 noites)", 8_500);

        try {
            cadastro.removerPorDescricao("Disney (7 noites)");
        } catch (PacoteViagemException e){
            System.out.println(e.getMessage());
        }

        cadastro.ordenar();
        imprimirPacotes(cadastro.obterTodos());

        cadastro.ordenarPorPrecoDecrescente();

//        PacoteViagem pacoteEncontrado = cadastro.buscarPorDescricao("Disney (7 noites)");
//        System.out.println(pacoteEncontrado);

        imprimirPacotes(cadastro.obterTodos());
    }

    private static void imprimirPacotes(List<PacoteViagem> pacotes) {
        for (PacoteViagem pacote : pacotes) {
            System.out.println(pacote.toString());
        }
        System.out.println("\n");
    }

}

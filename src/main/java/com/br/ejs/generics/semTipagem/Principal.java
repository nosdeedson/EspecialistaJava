package com.br.ejs.generics.semTipagem;

public class Principal {

    public static void main(String[] args) {
        String[] nomes = {"maria", "jose", "joao"};
        String nome = Sorteador.<String>sortear(nomes);

        System.out.println(nome);

        Cliente[] clientes = {new Cliente("posto", 100D),
                new Cliente("padaria", 1000D)};

        var cliente = Sorteador.sortear(clientes);

        System.out.println("Nome:" + cliente.getRazaoSocial() + " Faturamento: " + cliente.getFaturamentoMensal());

        Double[] numeros = {1D, 2d, 3d};

        double numero = Sorteador.sortear(numeros);

        System.out.println(numero);

    }
}

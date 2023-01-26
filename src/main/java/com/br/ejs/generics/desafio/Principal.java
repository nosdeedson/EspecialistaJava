package com.br.ejs.generics.desafio;

public class Principal {

    public static void main(String[] args) {
        GerenciadorEstoque<Roupa> gerenciadorRoupa = new GerenciadorEstoque<>();

        Roupa r = new Roupa("calça" , 10);
        Roupa r2 = new Roupa("bermuda" , 8);

        gerenciadorRoupa.adicionar(r);
        gerenciadorRoupa.adicionar(r2);

        System.out.println("quantidade de roupa"+gerenciadorRoupa.getQuantidadeTotal());

        Carro carro = new Carro("Palio", 3);
        Carro carro2 = new Carro("Gol", 4);
        GerenciadorEstoque<Carro> estoqueCarro = new GerenciadorEstoque<>();
        estoqueCarro.adicionar(carro);
        estoqueCarro.adicionar(carro2);
        System.out.println(estoqueCarro.getQuantidadeTotal());


    }
}

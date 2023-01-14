package com.br.ejs.arrays;

import com.br.ejs.model.Calendario;
import com.br.ejs.model.Cardapio;
import com.br.ejs.model.CardapioList;
import com.br.ejs.model.ItemCardapio;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Calendario calendario = new Calendario();
        String mes = calendario.obterMes(6);
        System.out.println("Mês: " + mes);

        System.out.println("################################");

        Cardapio cardapio = new Cardapio();
        ItemCardapio itemCardapio = new ItemCardapio("Porção batata frita", 10D);

        ItemCardapio itemCardapio1 = new ItemCardapio("Rib Eye 500g", 95);
        ItemCardapio itemCardapio2 = new ItemCardapio("Picanha", 102.5);

        cardapio.adicionarItem(itemCardapio);
        cardapio.adicionarItem(itemCardapio1);
        cardapio.adicionarItem(itemCardapio2);
        System.out.println(cardapio.toString());

        cardapio.removerItem(1);

        System.out.println(cardapio.toString());
        System.out.println("\n");
        cardapio.imprimir(10, 150);

        System.out.println("################################");
        CardapioList cardapioList = new CardapioList();
        cardapioList.adicionar(itemCardapio);
        cardapioList.adicionar(itemCardapio1);
        cardapioList.adicionar(itemCardapio2);
        cardapioList.imprimir();

        List<ItemCardapio> baratos = cardapioList.itensBaratos(10, 100);
        System.out.println(Arrays.asList(baratos).toString());
    }
}
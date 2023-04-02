package com.br.ejs.modulo.expressoesLambida.FunctionalInterfacesJava.interfaceFunction;

import com.br.ejs.modulo.expressoesLambida.FunctionalInterfacesJava.Produto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;

public class Principal {

    public static void main(String[] args) {
        var produtos = new ArrayList<Produto>();
        produtos.add(new Produto("Sabão", new BigDecimal("9.9"), 11));
        produtos.add(new Produto("Leite", new BigDecimal("3.4"), 22));
        produtos.add(new Produto("Macarrão", new BigDecimal("9.3"), 0));
        produtos.add(new Produto("Cerveja", new BigDecimal("5.8"), 14));
        produtos.add(new Produto("Arroz", new BigDecimal("15.9"), 0));
        produtos.add(new Produto("Chocolate", new BigDecimal("25.1"), 10, Produto.Status.INATIVO));

//        produtos.forEach(System.out::println);

//        produtos.sort((produto1, produto2) -> Integer.compare(produto1.getQuantidade(), produto2.getQuantidade()));
//        Function<Produto, Integer> function = produto -> produto.getQuantidade();  // this function return the key to extract the value to use int the comparation
//        Function<Produto, String> function1 = produto -> produto.getNome(); // this function return the key to extract the value to use int the comparation

//        produtos.sort(Comparator.comparing(function));
//        produtos.sort(Comparator.comparing(function).thenComparing(function1));

        produtos.sort(Comparator.comparing(produto -> (Integer) produto.getQuantidade()));
//        ToIntFunction<Produto> intFunction = produto -> produto.getQuantidade();
//        produtos.sort(Comparator.comparingInt(intFunction));

        System.out.println("");
        System.out.println("");
        produtos.forEach(System.out::println);

    }
}

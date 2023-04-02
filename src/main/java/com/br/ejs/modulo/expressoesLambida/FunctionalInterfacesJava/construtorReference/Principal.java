package com.br.ejs.modulo.expressoesLambida.FunctionalInterfacesJava.construtorReference;

import com.br.ejs.modulo.expressoesLambida.FunctionalInterfacesJava.Produto;

import java.util.function.Function;

public class Principal {

    public static void main(String[] args) {
//        Function<String, Produto> function = nome -> new Produto(nome); // return a new Produto
        Function<String, Produto> function = Produto::new;
        Produto produto = function.apply("Arroz");
        System.out.println(produto);
    }
}

package com.br.ejs.modulo.expressoesLambida.FunctionalInterfacesJava.methodReference;

import com.br.ejs.modulo.expressoesLambida.FunctionalInterfacesJava.Produto;
import com.br.ejs.modulo.expressoesLambida.FunctionalInterfacesJava.ServicoInativacaoProduto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;

public class Principal {

    public static void main(String[] args) {
        var produtos = new ArrayList<Produto>();
        produtos.add(new Produto("Sabão", new BigDecimal("9.9"), 11));
        produtos.add(new Produto("Leite", new BigDecimal("3.4"), 22));
        produtos.add(new Produto("Macarrão", new BigDecimal("9.3"), 0));
        produtos.add(new Produto("Cerveja", new BigDecimal("5.8"), 14));
        produtos.add(new Produto("Arroz", new BigDecimal("15.9"), 0));
        produtos.add(new Produto("Chocolate", new BigDecimal("25.1"), 10, Produto.Status.INATIVO));

        // using instanciation of the interfaces
//        Function<Produto, Integer> produtoFunction = Produto::getQuantidade;
//        produtos.sort(Comparator.comparing(produtoFunction));
//        Consumer<Produto> produtoConsumer = Produto::inativar;
//        produtos.forEach(produtoConsumer);

//        produtos.forEach(Produto::inativar);

        // using another class to inative the Produto class
        var inativacaoProduto = new ServicoInativacaoProduto();

//        Consumer<Produto> produtoConsumer = inativacaoProduto::processar;
//        produtos.forEach(produtoConsumer);
        produtos.forEach(inativacaoProduto::processar);
        produtos.sort(Comparator.comparing(Produto::getQuantidade));
        produtos.forEach(System.out::println);

//        produtos.forEach(produto -> ServicoInativacaoProduto.processarStaticamente(produto));
        produtos.forEach(ServicoInativacaoProduto::processarStaticamente);

        produtos.forEach(System.out::println);

    }
}
